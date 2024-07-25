package com.example.coffeeshop.api.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@Entity
@Table(name = "roles")
@Setter
@Getter
@NoArgsConstructor
public class Role // implements GrantedAuthority
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * CUSTOMER
     * ADMIN
     * MANAGER
     */
    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

//    @Override
//    public String getAuthority() {
//        return "ROLE_" + name; // if you not use "ROLE_" request error 403 forbidden
//    }
}
