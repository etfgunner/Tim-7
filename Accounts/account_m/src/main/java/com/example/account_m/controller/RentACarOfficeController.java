package com.example.account_m.controller;


import com.example.account_m.entity.RentACarOffice;
import com.example.account_m.entity.request.AddRentACarOfficeRequest;
import com.example.account_m.repository.RentACarOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RentACarOfficeController {

    private RentACarOfficeRepository rentACarOfficeRepository;

    @Autowired
    public RentACarOfficeController(RentACarOfficeRepository rentACarOfficeRepository) {
        this.rentACarOfficeRepository = rentACarOfficeRepository;
    }

    @RequestMapping(value = "rentacaroffice", method = RequestMethod.GET)
    public List<RentACarOffice> findAllRentACarOffices(){
        return rentACarOfficeRepository.findAll();
    }

    @RequestMapping(value = "rentacaroffice", method = RequestMethod.POST)
    public void addRentACarOffice(@RequestBody AddRentACarOfficeRequest addRentACarOfficeRequest){
        RentACarOffice rentACarOffice = new RentACarOffice();
        rentACarOffice.setOfficeName(addRentACarOfficeRequest.getOfficeName());
        rentACarOffice.setCarsNumber(addRentACarOfficeRequest.getCarsNumber());
        rentACarOffice.setLocationID(addRentACarOfficeRequest.getLocationID());
        rentACarOfficeRepository.save(rentACarOffice);
    }
}
