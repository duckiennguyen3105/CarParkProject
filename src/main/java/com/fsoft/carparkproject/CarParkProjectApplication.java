package com.fsoft.carparkproject;

import com.fsoft.carparkproject.service.IEmployeeService;
import com.fsoft.carparkproject.service.Impl.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CarParkProjectApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(CarParkProjectApplication.class, args);
    }

}
