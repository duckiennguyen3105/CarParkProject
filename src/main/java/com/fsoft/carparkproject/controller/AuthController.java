package com.fsoft.carparkproject.controller;


import com.fsoft.carparkproject.dto.EmployeeDTO;
import com.fsoft.carparkproject.dto.LoginDTO;
import com.fsoft.carparkproject.service.IAuthService;
import com.fsoft.carparkproject.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    IAuthService iAuthService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO user){
        iAuthService.login(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
