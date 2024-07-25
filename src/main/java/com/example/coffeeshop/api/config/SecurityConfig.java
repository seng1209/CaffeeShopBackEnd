//package com.example.coffeeshop.api.config;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@RequiredArgsConstructor
//public class SecurityConfig {
//
//    private final PasswordEncoder passwordEncoder;
//    private final UserDetailsService userDetailsService;
//
///*    @Bean
//    InMemoryUserDetailsManager configUserSecurity(){
//        UserDetails user = User
//                .withUsername("sna")
//                .password(passwordEncoder.encode("sna123"))
//                .roles("USER")
//                .build();
//        UserDetails admin = User
//                .withUsername("hong")
//                .password(passwordEncoder.encode("hong123"))
//                .roles("USER", "ADMIN")
//                .build();
//        UserDetails manager = User
//                .withUsername("leang")
//                .password(passwordEncoder.encode("leang123"))
//                .roles("USER", "MANAGER")
//                .build();
//        InMemoryUserDetailsManager management = new InMemoryUserDetailsManager();
//        management.createUser(user);
//        management.createUser(admin);
//        management.createUser(manager);
//        return management;
//    }*/
//
//    @Bean
//    DaoAuthenticationProvider configDaoAuthenticationProvider(){ // implement authentication with database
//
//        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
//        auth.setPasswordEncoder(passwordEncoder);
//        auth.setUserDetailsService(userDetailsService);
//
//        return auth;
//    }
//
//    @Bean
//    SecurityFilterChain configApiSecurity(HttpSecurity httpSecurity) throws Exception {
//
//        // EndPoint Security Config
//        httpSecurity.authorizeHttpRequests(endpoint -> endpoint
//                // customer
//                .requestMatchers(HttpMethod.GET, "api/v2/customers/**").hasAnyRole("USER")
//                .requestMatchers(HttpMethod.POST, "api/v2/customers/**").hasAnyRole("USER")
//                .requestMatchers(HttpMethod.PUT, "api/v2/customers/**").hasAnyRole("USER")
//                .requestMatchers(HttpMethod.PATCH, "api/v2/customers/**").hasAnyRole("USER")
//                .requestMatchers(HttpMethod.DELETE, "api/v2/customers/**").hasAnyRole("ADMIN", "MANAGER")
//                // staff
//                .requestMatchers(HttpMethod.GET, "api/v2/staffs/**").hasAnyRole("ADMIN", "MANAGER")
//                .requestMatchers(HttpMethod.POST, "api/v2/staffs/**").hasAnyRole("ADMIN", "MANAGER")
//                .requestMatchers(HttpMethod.PUT, "api/v2/staffs/**").hasAnyRole("ADMIN", "MANAGER")
//                .requestMatchers(HttpMethod.PATCH, "api/v2/staffs/**").hasAnyRole("ADMIN", "MANAGER")
//                .requestMatchers(HttpMethod.DELETE, "api/v2/staffs/**").hasAnyRole("ADMIN", "MANAGER")
//                // user
//                .requestMatchers(HttpMethod.GET, "api/v2/users/**").hasAnyRole("ADMIN", "MANAGER")
//                .requestMatchers(HttpMethod.POST, "api/v2/users/**").hasAnyRole("ADMIN", "MANAGER")
//                .requestMatchers(HttpMethod.PUT, "api/v2/users/**").hasAnyRole("ADMIN", "MANAGER")
//                .requestMatchers(HttpMethod.PATCH, "api/v2/users/**").hasAnyRole("ADMIN", "MANAGER")
//                .requestMatchers(HttpMethod.DELETE, "api/v2/users/**").hasAnyRole("ADMIN", "MANAGER")
//                .anyRequest()
//                .authenticated());
//
//        // Security Mechanism (HTTP Basic Auth)
//        // HTTP Basic Auth (Username , Password)
//        httpSecurity.httpBasic(Customizer.withDefaults());
//
//        // Disabled CSRF token
//        httpSecurity.csrf(token -> token.disable());
//
//        // Make Stateless Session
//        httpSecurity.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//
//        return httpSecurity.build();
//    }
//
//}
