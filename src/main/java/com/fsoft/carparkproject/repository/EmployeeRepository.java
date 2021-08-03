package com.fsoft.carparkproject.repository;

import com.fsoft.carparkproject.Entity.EmployeeEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<EmployeeEnt,Long>{
    Optional<EmployeeEnt> findEmployeeEntByAccount(String account);


}
