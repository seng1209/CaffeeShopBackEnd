package com.example.coffeeshop.api.repository;

import com.example.coffeeshop.api.entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface StaffRepository extends JpaRepository<Staff, Long> {

    Boolean existsByPhone(String phone);

    Optional<Staff> findByPhoneAndStopWorkIsFalse(String phone);

    Boolean existsByPhoneAndStopWorkIsFalse(String phone);

    List<Staff> findAllByStopWorkIsFalse();

    List<Staff> findAllByStopWorkIsTrue();

    @Modifying
    @Query("UPDATE Staff AS s SET s.stopWork = true WHERE s.phone = ?1")
    void editStaffByStopWork(String phone);

    List<Staff> findAllByNameAndPhoneAndStopWork(String name, String phone, Boolean stopWork);

    @Query("SELECT S FROM Staff AS S WHERE S.name LIKE %?1%")
    List<Staff> findAllByName(String name);

    @Query("SELECT SUM(S.salary) FROM Staff AS S WHERE S.stopWork = false ")
    BigDecimal getTotalSalary();

    @Query("SELECT S FROM Staff AS S WHERE lower(S.phone) LIKE lower(concat('%', ?1, '%') ) ")
    List<Staff> findAllByPhone(String phone);

    @Query("SELECT S FROM Staff AS S WHERE lower(S.position) LIKE lower(concat('%', ?1, '%') ) ")
    List<Staff> findAllByPosition(String position);
}
