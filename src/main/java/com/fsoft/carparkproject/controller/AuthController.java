package com.fsoft.carparkproject.controller;


import com.fsoft.carparkproject.dto.EmployeeDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody EmployeeDTO employeeDTO){
        return null;
    }
}