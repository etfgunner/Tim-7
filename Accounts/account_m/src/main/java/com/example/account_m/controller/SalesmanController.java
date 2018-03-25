package com.example.account_m.controller;

import com.example.account_m.entity.Salesman;
import com.example.account_m.entity.request.AddSalesmanRequest;
import com.example.account_m.repository.SalesmanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SalesmanController {

    private SalesmanRepository salesmanRepository;

    @Autowired
    public SalesmanController(SalesmanRepository salesmanRepository) {
        this.salesmanRepository = salesmanRepository;
    }

    @RequestMapping(value = "salesman", method = RequestMethod.GET)
    public List<Salesman> findAllSalesmans(){
        return salesmanRepository.findAll();
    }

    @RequestMapping(value = "salesman", method = RequestMethod.POST)
    public void addSalesman(@RequestBody AddSalesmanRequest addSalesmanRequest){
        Salesman salesman = new Salesman();
        salesman.setName(addSalesmanRequest.getName());
        salesman.setSurname(addSalesmanRequest.getSurname());
        salesman.setJMBG(addSalesmanRequest.getJMBG());
        salesman.setBirthDate(addSalesmanRequest.getBirthDate());
        salesman.setPay(addSalesmanRequest.getPay());
        salesman.setRentACarOffice(addSalesmanRequest.getRentACarOffice());
        salesmanRepository.save(salesman);
    }

}
