package com.example.coffeeshop.api.dataInit;

import com.example.coffeeshop.api.entities.Role;
import com.example.coffeeshop.api.entities.Staff;
import com.example.coffeeshop.api.entities.User;
import com.example.coffeeshop.api.repository.RoleRepository;
import com.example.coffeeshop.api.repository.StaffRepository;
import com.example.coffeeshop.api.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Component
//@RequiredArgsConstructor
@AllArgsConstructor
public class DataInit {

    private final StaffRepository staffRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    void init () {
        if (staffRepository.count() == 0){
            Staff s1 = new Staff();
            s1.setAddress("Phnom Penh");
            s1.setHiredDate(LocalDate.now());
            s1.setStopWork(false);
            s1.setGender("Male");
            s1.setBirthDate(LocalDate.parse("2000-10-10"));
            s1.setImage("image.png");
            s1.setName("Hong");
            s1.setPhone("200-200-200");
            s1.setPosition("ADMIN");
            s1.setSalary(BigDecimal.valueOf(450));
            staffRepository.save(s1);

            Staff s2 = new Staff();
            s2.setAddress("Phnom Penh");
            s2.setHiredDate(LocalDate.now());
            s2.setStopWork(false);
            s2.setGender("Male");
            s2.setBirthDate(LocalDate.parse("2000-10-10"));
            s2.setImage("image.png");
            s2.setName("Meng Leang");
            s2.setPhone("200-200-201");
            s2.setPosition("MANAGER");
            s2.setSalary(BigDecimal.valueOf(450));
            staffRepository.save(s2);

            Staff s3 = new Staff();
            s3.setAddress("Phnom Penh");
            s3.setHiredDate(LocalDate.now());
            s3.setStopWork(false);
            s3.setGender("Male");
            s3.setBirthDate(LocalDate.parse("2000-10-10"));
            s3.setImage("image.png");
            s3.setName("VEA SNA");
            s3.setPhone("200-200-202");
            s3.setPosition("CUSTOMER");
            s3.setSalary(BigDecimal.valueOf(450));
            staffRepository.save(s3);
        }

        if (roleRepository.count() == 0){
            Role customer = new Role();
            customer.setName("CUSTOMER");

            Role user = new Role();
            user.setName("USER");

            Role admin = new Role();
            admin.setName("ADMIN");

            Role manager = new Role();
            manager.setName("MANAGER");

            roleRepository.saveAll(List.of(customer, user, admin, manager));
        }

        if (userRepository.count() == 0){

            List<Staff> staffs = staffRepository.findAllByStopWorkIsFalse();

            List<Role> roles = roleRepository.findAll();

            User user1 = new User();
            user1.setUsername("sna");
            user1.setPassword(passwordEncoder.encode("sna123"));
            user1.setStaff(staffs.get(2));
            user1.setRoles(List.of(roles.get(1), roles.get(0)));

            User user2 = new User();
            user2.setUsername("hong");
            user2.setPassword(passwordEncoder.encode("hong123"));
            user2.setStaff(staffs.get(0));
            user2.setRoles(List.of(roles.get(1), roles.get(2)));

            User user3 = new User();
            user3.setUsername("leang");
            user3.setPassword(passwordEncoder.encode("leang123"));
            user3.setStaff(staffs.get(1));
            user3.setRoles(List.of(roles.get(1), roles.get(3)));

            userRepository.saveAll(List.of(user1, user2, user3));

        }
    }

}
