package com.fsoft.carparkproject.repository;

import com.fsoft.carparkproject.Entity.PlaceEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends JpaRepository<PlaceEnt,Long> {

}
