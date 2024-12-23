package com.example.JWTSpringSecurity.Entity;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    // Implementing getAuthority() from GrantedAuthority
    @Override
    public String getAuthority() {
        return name;  // Assuming "name" is the role (e.g., "ROLE_USER", "ROLE_ADMIN")
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
