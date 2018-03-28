package com.example.vehicle.resource;

import com.example.vehicle.model.VehicleReceipt;
import com.example.vehicle.repository.VehicleReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/vehiclereceipt")
public class VehicleReceiptResource {

    @Autowired
    VehicleReceiptRepository vehicleReceiptRepository;

    @GetMapping(value = "/all")
    public List<VehicleReceipt> getAll()
    {
        return vehicleReceiptRepository.findAll();
    }

    @PostMapping(value = "/insert")
    public List<VehicleReceipt> persist (@RequestBody final VehicleReceipt vehicleReceipt)
    {
        vehicleReceiptRepository.save(vehicleReceipt);
        return vehicleReceiptRepository.findAll();
    }
}
