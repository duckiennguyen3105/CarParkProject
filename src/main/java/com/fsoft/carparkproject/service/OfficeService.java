package com.fsoft.carparkproject.service;

import com.fsoft.carparkproject.dto.OfficeDTO;

import com.fsoft.carparkproject.model.Office;
import com.fsoft.carparkproject.model.Place;
import com.fsoft.carparkproject.repository.OfficeRepository;
import com.fsoft.carparkproject.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OfficeService {
    private final OfficeRepository officeRepository;
    private final PlaceRepository placeRepository;
    @Autowired
    public OfficeService(OfficeRepository officeRepository, PlaceRepository placeRepository) {
        this.officeRepository = officeRepository;
        this.placeRepository = placeRepository;
    }
    public List<OfficeDTO> getAllOffice(){
        List<Office> listOffice = officeRepository.findAll();
        return listOffice.stream().map(OfficeDTO::new).collect(Collectors.toList());
    }
    public void addOffice(OfficeDTO office){
        Optional<Place> places = placeRepository.findById(office.getPlace_id());
        Office newOffice = new Office();
        newOffice.setName(office.getName());
        newOffice.setPrice(office.getPrice());
        newOffice.setPhone(office.getPhone());
        newOffice.setContractDeadline(office.getContractDeadline());
        newOffice.setPlaces(places.get());
        officeRepository.save(newOffice);
    }
    public void deleteOffice(Long id){
        if(!officeRepository.existsById(id)){
            officeRepository.deleteById(id);
        }
    };
    public void getOfficeById(Long id){
        Optional<Office> office = Optional.ofNullable(officeRepository.findById(id).orElseThrow(() -> new IllegalStateException("Office with id " + id + " is not exist")));
    }
    @Transactional
    public void updateOffice(Long id,Office newOfice){

        Office office = officeRepository.findById(id).orElseThrow(()-> new IllegalStateException("Office with id "+ id + " is not exist"));
        if(newOfice.getName().isEmpty() || newOfice.getName().trim().equals(""))
        office.setName(newOfice.getName());
        office.setPhone(newOfice.getPhone());
        office.setPrice(newOfice.getPrice());
        office.setContractDeadline(office.getContractDeadline());

    }
}
