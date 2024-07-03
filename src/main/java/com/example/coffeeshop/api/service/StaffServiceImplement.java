package com.example.coffeeshop.api.service;

import com.example.coffeeshop.api.entities.Staff;
import com.example.coffeeshop.api.mapper.StaffMapper;
import com.example.coffeeshop.api.repository.StaffRepository;
import com.example.coffeeshop.api.web.staff.CreateStaffDto;
import com.example.coffeeshop.api.web.staff.StaffDto;
import com.example.coffeeshop.api.web.staff.UpdateStaffDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class StaffServiceImplement implements StaffService{

    private final StaffRepository staffRepository;
    private final StaffMapper staffMapper;

    @Override
    public void createNewStaff(CreateStaffDto createStaffDto) {

        Staff staff = staffMapper.formCreateStaffDto(createStaffDto);
        staff.setHiredDate(LocalDate.now());
        staff.setStopWork(false);
        staffRepository.save(staff);
    }

    @Override
    public void updateStaffByPhone(String phone, UpdateStaffDto updateStaffDto) {
        if (staffRepository.existsByPhoneAndStopWorkIsFalse(phone)){
            Staff staff = staffRepository.findByPhoneAndStopWorkIsFalse(phone).orElseThrow();
            staffMapper.formUpdateStaffDto(staff, updateStaffDto);
            staffRepository.save(staff);
            return;
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Staff at phone %s not found", phone));
    }

    @Transactional
    @Override
    public void deleteStaffByPhone(String phone) {
        if (staffRepository.existsByPhoneAndStopWorkIsFalse(phone)){
            staffRepository.editStaffByStopWork(phone);
            return;
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Staff at phone %s not found", phone));
    }

    @Override
    public StaffDto findByPhone(String phone) {
        Staff staff = staffRepository.findByPhoneAndStopWorkIsFalse(phone).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Staff at phone %s not found", phone))
        );
        return staffMapper.toStaffDto(staff);
    }

    @Override
    public List<StaffDto> findAllByStopWorkIsFalse() {
        List<Staff> staffs = staffRepository.findAllByStopWorkIsFalse();
        return staffMapper.toStaffDtoList(staffs);
    }

    @Override
    public List<StaffDto> findAllByStopWorkIsTrue() {
        List<Staff> staffs = staffRepository.findAllByStopWorkIsTrue();
        return staffMapper.toStaffDtoList(staffs);
    }

    @Override
    public List<StaffDto> searchStaff(String name, String phone, Boolean stopWork) {
        List<Staff> staffs = staffRepository.findAllByNameAndPhoneAndStopWork(name, phone, stopWork);
        return staffMapper.toStaffDtoList(staffs);
    }

    @Override
    public void deleteByPhone(String phone) {
        Staff staff = staffRepository.findByPhoneAndStopWorkIsFalse(phone).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Staff at phone %s not found", phone))
        );
        staffRepository.delete(staff);
    }
}
