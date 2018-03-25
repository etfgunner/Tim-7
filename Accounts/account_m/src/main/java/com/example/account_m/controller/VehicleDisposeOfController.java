package com.example.account_m.controller;


import com.example.account_m.entity.VehicleDisposeOf;
import com.example.account_m.entity.request.AddVehicleDisposeOfRequest;
import com.example.account_m.repository.VehicleDisposeOfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VehicleDisposeOfController {

    private VehicleDisposeOfRepository vehicleDisposeOfRepository;

    @Autowired
    public VehicleDisposeOfController(VehicleDisposeOfRepository vehicleDisposeOfRepository) {
        this.vehicleDisposeOfRepository = vehicleDisposeOfRepository;
    }

    @RequestMapping(value = "vehicleDisposeOf", method = RequestMethod.GET)
    public List<VehicleDisposeOf> findAllVehicleDisposeOfs(){
        return vehicleDisposeOfRepository.findAll();
    }

    @RequestMapping(value = "vehicleDisposeOf", method = RequestMethod.POST)
    public void addVehicleDisposeOf(@RequestBody AddVehicleDisposeOfRequest addVehicleDisposeOfRequest){
        VehicleDisposeOf vehicleDisposeOf = new VehicleDisposeOf();
        vehicleDisposeOf.setVehicleID(addVehicleDisposeOfRequest.getVehicleID());
        vehicleDisposeOf.setReason(addVehicleDisposeOfRequest.getReason());
        vehicleDisposeOf.setRentACarOffice(addVehicleDisposeOfRequest.getRentACarOffice());
        vehicleDisposeOf.setSalesman(addVehicleDisposeOfRequest.getSalesman());
        vehicleDisposeOfRepository.save(vehicleDisposeOf);
    }

}
