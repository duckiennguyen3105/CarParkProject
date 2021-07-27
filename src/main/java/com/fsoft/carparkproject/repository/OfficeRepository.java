package com.fsoft.carparkproject.repository;

import com.fsoft.carparkproject.dto.OfficeDTO;
import com.fsoft.carparkproject.Entity.OfficeEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeRepository extends JpaRepository<OfficeEnt,Long> {
//    void addOffice(OfficeDTO office);

}


