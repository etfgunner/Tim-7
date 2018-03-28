package com.example.vehicle.resource;

import com.example.vehicle.model.Vehicle;
import com.example.vehicle.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/vehicle")
public class VehicleResource {

    @Autowired
    VehicleRepository vehicleRepository;

    @GetMapping(value = "/all")
    public List<Vehicle> getAll() {
        return vehicleRepository.findAll();
    }

    @PostMapping(value="/insert")
    public List<Vehicle> persist (@RequestBody final Vehicle vehicle)
    {
        vehicleRepository.save(vehicle);
        return vehicleRepository.findAll();
    }

}
