package com.fsoft.carparkproject.service.Impl;


import com.fsoft.carparkproject.Entity.PlaceEnt;
import com.fsoft.carparkproject.repository.PlaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceService {

    private final PlaceRepository placeRepository;

    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }
    public List<PlaceEnt> getAllPlace(){
        return placeRepository.findAll();
    }

}
