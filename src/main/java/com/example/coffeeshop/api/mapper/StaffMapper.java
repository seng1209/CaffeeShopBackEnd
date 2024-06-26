package com.example.coffeeshop.api.mapper;

import com.example.coffeeshop.api.entities.Staff;
import com.example.coffeeshop.api.web.staff.CreateStaffDto;
import com.example.coffeeshop.api.web.staff.StaffDto;
import com.example.coffeeshop.api.web.staff.UpdateStaffDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StaffMapper {

    // create new staff

    /**
     * mapping CreateStaffDto to Staff Entity
     * @param createStaffDto
     */
    Staff formCreateStaffDto(CreateStaffDto createStaffDto);

    // update staff

    /**
     * mapping for patch update UpdateStaffDto to Staff Entity
     * @param staff
     * @param updateStaffDto
     */
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void formUpdateStaffDto(@MappingTarget Staff staff, UpdateStaffDto updateStaffDto);

    // select staff

    /**
     * mapping Staff Entity to StaffDto
     * @param staff
     * @return
     */
    StaffDto toStaffDto(Staff staff);

    // select all staff

    /**
     * mapping list of Staff Entity to list of StaffDto
     * @param staffs
     * @return
     */
    List<StaffDto> toStaffDtoList(List<Staff> staffs);

}
