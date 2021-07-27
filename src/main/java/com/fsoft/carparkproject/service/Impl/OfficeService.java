package com.fsoft.carparkproject.service.Impl;

import com.fsoft.carparkproject.dto.OfficeDTO;

import com.fsoft.carparkproject.Entity.OfficeEnt;
import com.fsoft.carparkproject.Entity.PlaceEnt;
import com.fsoft.carparkproject.repository.OfficeRepository;
import com.fsoft.carparkproject.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public  class OfficeService {

    private  OfficeRepository officeRepository;
    private  PlaceRepository placeRepository;

    public OfficeService(OfficeRepository officeRepository, PlaceRepository placeRepository) {
        this.officeRepository = officeRepository;
        this.placeRepository = placeRepository;
    }



//    public List<OfficeDTO> getAllOffice(){
//        List<OfficeEnt> listOfficeEnt = officeRepository.findAll();
//        return listOfficeEnt.stream().map(OfficeDTO::new).collect(Collectors.toList());
//    }
    public void addOffice(OfficeDTO office){
        Optional<PlaceEnt> places = placeRepository.findById(office.getPlace_id());
        OfficeEnt newOfficeEnt = new OfficeEnt();
        newOfficeEnt.setName(office.getName());
        newOfficeEnt.setPrice(office.getPrice());
        newOfficeEnt.setPhone(office.getPhone());
        newOfficeEnt.setContractDeadline(office.getContractDeadline());
        newOfficeEnt.setPlaces(places.get());
        officeRepository.save(newOfficeEnt);

    }
    public void deleteOffice(Long id){
        if(!officeRepository.existsById(id)){
            officeRepository.deleteById(id);
        }
    };
    public void getOfficeById(Long id){
        Optional<OfficeEnt> office = Optional.ofNullable(officeRepository.findById(id).orElseThrow(() -> new IllegalStateException("Office with id " + id + " is not exist")));
    }

    @Transactional
    public void updateOffice(Long id, OfficeEnt newOfice){

        OfficeEnt officeEnt = officeRepository.findById(id).orElseThrow(()-> {
            return new IllegalStateException("Office with id "+ id + " is not exist");
        });
        if(newOfice.getName().isEmpty() || newOfice.getName().trim().equals(""))
        officeEnt.setName(newOfice.getName());
        officeEnt.setPhone(newOfice.getPhone());
        officeEnt.setPrice(newOfice.getPrice());
        officeEnt.setContractDeadline(officeEnt.getContractDeadline());

    }
}
