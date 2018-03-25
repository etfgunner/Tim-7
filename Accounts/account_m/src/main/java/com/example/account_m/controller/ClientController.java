package com.example.account_m.controller;


import com.example.account_m.entity.Client;
import com.example.account_m.entity.request.AddClientRequest;
import com.example.account_m.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {

    private ClientRepository clientRepository;

    @Autowired
    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @RequestMapping(value = "client", method = RequestMethod.GET)
    public List<Client> findAllRentACarOffices(){
        return clientRepository.findAll();
    }

    @RequestMapping(value = "client", method = RequestMethod.POST)
    public void addClient(@RequestBody AddClientRequest addClientRequest){
        Client client = new Client();
        client.setName(addClientRequest.getName());
        client.setSurname(addClientRequest.getSurname());
        client.setEmailAdress(addClientRequest.getEmailAdress());
        clientRepository.save(client);
    }

}
