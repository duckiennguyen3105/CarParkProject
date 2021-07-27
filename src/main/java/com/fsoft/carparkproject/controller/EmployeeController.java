package com.fsoft.carparkproject.controller;

import com.fsoft.carparkproject.dto.EmployeeDTO;
import com.fsoft.carparkproject.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    IEmployeeService iEmployeeService;

    @GetMapping("/getAllEmployees")
    public ResponseEntity<?> listAllEmployees(){
        return new ResponseEntity<>(iEmployeeService.getAllEmployees(),HttpStatus.OK);
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<?> addEmployee(@RequestBody EmployeeDTO employeeDTO){
        iEmployeeService.addEmployee(employeeDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
