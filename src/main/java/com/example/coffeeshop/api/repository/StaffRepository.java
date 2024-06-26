package com.example.coffeeshop.api.repository;

import com.example.coffeeshop.api.entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StaffRepository extends JpaRepository<Staff, Integer> {

    Boolean existsByPhone(String phone);

    Optional<Staff> findByPhoneAndStopWorkIsFalse(String phone);

    Boolean existsByPhoneAndStopWorkIsFalse(String phone);

    List<Staff> findAllByStopWorkIsFalse();

    List<Staff> findAllByStopWorkIsTrue();

    @Modifying
    @Query("UPDATE Staff AS s SET s.stopWork = true WHERE s.phone = ?1")
    void editStaffByStopWork(String phone);

    List<Staff> findAllByNameAndPhoneAndStopWork(String name, String phone, Boolean stopWork);

    @Modifying
    @Query("UPDATE Staff  AS s SET s.image = ?1 WHERE s.phone = ?2")
    void editStaffImage(String image, String phone);
}
