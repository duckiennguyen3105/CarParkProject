package com.fsoft.carparkproject.service.Impl;

import com.fsoft.carparkproject.Entity.EmployeeEnt;
import com.fsoft.carparkproject.dto.EmployeeDTO;
import com.fsoft.carparkproject.exception.UserAlreadyExistException;
import com.fsoft.carparkproject.repository.EmployeeRepository;
import com.fsoft.carparkproject.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.stream.Collectors;

@Service
@Primary
public class EmployeeService implements IEmployeeService  {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeEnt> listEmployee = employeeRepository.findAll();
        return listEmployee.stream().map(this::mapFromEntityToDto).collect(Collectors.toList());
    }

    @Override
    public void addEmployee(EmployeeDTO employeeDTO) throws UserAlreadyExistException {
        if(!employeeRepository.findEmployeeEntByAccount(employeeDTO.getAccount()).isEmpty()){                  
            throw new UserAlreadyExistException("User " + employeeDTO.getAccount() + " already exists");
        }else{

            EmployeeEnt employeeEnt = mapFromDtoToEnt(employeeDTO);
            employeeRepository.save(employeeEnt);
        }
    }

    @Override
    public void editEmployee(EmployeeDTO employeeDTO) {
        EmployeeEnt employeeEnt = employeeRepository.findById(employeeDTO.getId()).orElseThrow(()-> new IllegalArgumentException("User not found"));
        employeeRepository.save(employeeEnt);
    }

    @Override
    public void deleteEmployee(long id) {
        EmployeeEnt employeeEnt = employeeRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("User not found"));
        employeeRepository.deleteById(id);
    }

    @Override
    public EmployeeEnt mapFromDtoToEnt(EmployeeDTO employeeDTO) {
        EmployeeEnt employeeEnt = new EmployeeEnt();
        employeeEnt.setAccount(employeeDTO.getAccount());
        employeeEnt.setAddress(employeeDTO.getAddress());
        employeeEnt.setDepartment(employeeDTO.getDepartment());
        employeeEnt.setDob(employeeDTO.getDob());
        employeeEnt.setFullName(employeeDTO.getFullName());
        employeeEnt.setId(employeeDTO.getId());
        employeeEnt.setMail(employeeDTO.getMail());
        employeeEnt.setPass(passwordEncoder.encode(employeeDTO.getPass()));
        employeeEnt.setPhoneNumber(employeeDTO.getPhoneNumber());
        employeeEnt.setSex(employeeDTO.getSex());
        return employeeEnt;
    }

    @Override
    public EmployeeDTO mapFromEntityToDto(EmployeeEnt employeeEnt) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setAccount(employeeEnt.getAccount());
        employeeDTO.setAddress(employeeEnt.getAddress());
        employeeDTO.setDepartment(employeeEnt.getDepartment());
        employeeDTO.setDob(employeeEnt.getDob());
        employeeDTO.setFullName(employeeEnt.getFullName());
        employeeDTO.setId(employeeEnt.getId());
        employeeDTO.setMail(employeeEnt.getMail());
        employeeDTO.setPass(employeeEnt.getPass());
        employeeDTO.setPhoneNumber(employeeEnt.getPhoneNumber());
        employeeDTO.setSex(employeeEnt.getSex());
        return employeeDTO;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        EmployeeEnt employeeEnt  =  employeeRepository.findEmployeeEntByAccount(s).orElseThrow(() -> {
            throw new UsernameNotFoundException("User " + s +" not found");
        });
        UserDetails userDetails = new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
            }

            @Override
            public String getPassword() {
                return employeeEnt.getPass();
            }

            @Override
            public String getUsername() {
                return employeeEnt.getAccount();
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isEnabled() {
                return true;
            }
        };
        return userDetails;
    }
}
