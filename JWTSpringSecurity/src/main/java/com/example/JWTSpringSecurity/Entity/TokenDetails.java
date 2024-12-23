package com.example.JWTSpringSecurity.Entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TokenDetails {
   

    private String username;
    private List<String> roles;
    private String jwtToken;

}
