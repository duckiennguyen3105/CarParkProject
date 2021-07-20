package com.fsoft.carparkproject.controller;

import com.fsoft.carparkproject.dto.OfficeDTO;

import com.fsoft.carparkproject.model.Office;
import com.fsoft.carparkproject.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("office")
public class OfficeController {

    private final OfficeService officeService;
    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }
    @GetMapping("/list-office")
    public List<OfficeDTO> getAllOffice(){
        return officeService.getAllOffice();
    }
    @PostMapping("/insert")
    public void insertOffice(@RequestBody OfficeDTO office){
        officeService.addOffice(office);
    }

}
