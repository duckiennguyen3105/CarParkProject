package com.fsoft.carparkproject.service;

import com.fsoft.carparkproject.Entity.EmployeeEnt;
import com.fsoft.carparkproject.dto.EmployeeDTO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;


public interface IEmployeeService extends UserDetailsService {
    List<EmployeeDTO> getAllEmployees();
    void addEmployee(EmployeeDTO employeeDTO);
    void editEmployee(EmployeeDTO employeeDTO);
    void deleteEmployee(long id);
    EmployeeEnt mapFromDtoToEnt(EmployeeDTO employeeDTO);
    EmployeeDTO mapFromEntityToDto(EmployeeEnt employeeEnt);

    UserDetails loadUserByUsername(String s) throws UsernameNotFoundException;
}
