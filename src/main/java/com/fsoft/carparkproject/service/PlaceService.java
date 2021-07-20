package com.fsoft.carparkproject.service;


import com.fsoft.carparkproject.model.Place;
import com.fsoft.carparkproject.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceService {
    private final PlaceRepository placeRepository;
    @Autowired
    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }
    public List<Place> getAllPlace(){
        return placeRepository.findAll();
    }

}
