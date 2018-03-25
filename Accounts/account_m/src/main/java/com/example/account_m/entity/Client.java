package com.example.account_m.entity;

import javax.persistence.Entity;

@Entity
public class Client extends Person {

    private String emailAdress;

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }
}
