package com.example.mockupResponse.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.mockupResponse.obj.TokenRequestObj;
import com.example.mockupResponse.obj.TokenResponseObj;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/auth")
public class TokenController {
    @Value("${jwt.access-token.jwtExpirationMs}")
    private int jwtExpirationMs;

    @Value("${jwt.access-token.token}")
    private String token;

    @PostMapping("/token")
    public ResponseEntity<TokenResponseObj> token(@RequestBody TokenRequestObj requestObj) {
        return ResponseEntity.ok(new TokenResponseObj("bearer", token, jwtExpirationMs));
    }
}
