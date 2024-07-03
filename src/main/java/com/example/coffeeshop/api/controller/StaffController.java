package com.example.coffeeshop.api.controller;

import com.example.coffeeshop.api.service.StaffService;
import com.example.coffeeshop.api.web.staff.CreateStaffDto;
import com.example.coffeeshop.api.web.staff.StaffDto;
import com.example.coffeeshop.api.web.staff.UpdateStaffDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/staffs")
@AllArgsConstructor
public class StaffController {

    private final StaffService staffService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createNewStaff(@RequestBody @Valid CreateStaffDto createStaffDto){
        staffService.createNewStaff(createStaffDto);
    }

    @GetMapping
    public List<StaffDto> findAllByStopWorkIsFalse(){
        return staffService.findAllByStopWorkIsFalse();
    }

    @GetMapping("/true")
    public List<StaffDto> findAllByStopWorkIsTrue(){
        return staffService.findAllByStopWorkIsTrue();
    }

    @GetMapping("/{phone}")
    public StaffDto selectStaffByPhone(@PathVariable ("phone") String p){
        return staffService.findByPhone(p);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{phone}")
    public void updateStaffByPhone(@PathVariable String phone, @RequestBody UpdateStaffDto updateStaffDto){
        staffService.updateStaffByPhone(phone, updateStaffDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{phone}")
    public void deleteStaffByPhone(@PathVariable String phone){
        staffService.deleteStaffByPhone(phone);
    }

    @GetMapping("/search")
    public List<StaffDto> searchStaff(
            @RequestParam(required = false, defaultValue = "") String name,
            @RequestParam(required = false, defaultValue = "") String phone,
            @RequestParam(required = false, defaultValue = "false") Boolean stopWork
    )
    {
        return staffService.searchStaff(name, phone, stopWork);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{phone}")
    public void deleteByPhone(@PathVariable String phone){
        staffService.deleteByPhone(phone);
    }

}
