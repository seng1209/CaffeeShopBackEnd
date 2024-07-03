package com.example.coffeeshop.api.service;

import com.example.coffeeshop.api.web.staff.CreateStaffDto;
import com.example.coffeeshop.api.web.staff.StaffDto;
import com.example.coffeeshop.api.web.staff.UpdateStaffDto;

import java.util.List;

public interface StaffService {

    // create new staff
    void createNewStaff(CreateStaffDto createStaffDto);

    // update staff by phone
    void updateStaffByPhone(String phone, UpdateStaffDto updateStaffDto);

    // delete staff by phone
    void deleteStaffByPhone(String phone);

    // select staff by phone
    StaffDto findByPhone(String phone);

    // select all staff by stop work = false
    List<StaffDto> findAllByStopWorkIsFalse();

    // select all staff by stop work = true
    List<StaffDto> findAllByStopWorkIsTrue();

    // search by name and phone and stopWork
    List<StaffDto> searchStaff(String name, String phone, Boolean stopWork);

    // delete staff by phone
    void deleteByPhone(String phone);

}
