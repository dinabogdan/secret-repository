package com.freesoft.identity.manager.web.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @PostMapping("/login")
    public ResponseEntity login() {
        return null;
    }

    @PostMapping("/logout")
    public ResponseEntity logout() {
        return null;
    }
}
