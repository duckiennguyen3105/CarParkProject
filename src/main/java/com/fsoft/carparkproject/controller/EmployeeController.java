package com.fsoft.carparkproject.controller;

import com.fsoft.carparkproject.dto.EmployeeDTO;
import com.fsoft.carparkproject.exception.UserAlreadyExistException;
import com.fsoft.carparkproject.service.IEmployeeService;
import com.fsoft.carparkproject.service.Impl.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    IEmployeeService iEmployeeService;


    @GetMapping()
    public ResponseEntity<?> listAllEmployees(){
        return new ResponseEntity<>(iEmployeeService.getAllEmployees(),HttpStatus.OK);
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<?> addEmployee(@RequestBody EmployeeDTO employeeDTO){
        try {
            iEmployeeService.addEmployee(employeeDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (UserAlreadyExistException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping()
    public ResponseEntity<?> deleteEmployee(@RequestBody EmployeeDTO employeeDTO){
        try {
            iEmployeeService.addEmployee(employeeDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (UserAlreadyExistException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

}
