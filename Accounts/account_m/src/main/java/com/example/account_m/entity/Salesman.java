package com.example.account_m.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Salesman extends Person{

    private int JMBG;

    private Date birthDate;

    private double pay;


    //@OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    @JoinColumn(name = "rentACarOffice_id")
    private RentACarOffice rentACarOffice;


    public int getJMBG() {
        return JMBG;
    }

    public void setJMBG(int JMBG) {
        this.JMBG = JMBG;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    public RentACarOffice getRentACarOffice() {
        return rentACarOffice;
    }

    public void setRentACarOffice(RentACarOffice rentACarOffice) {
        this.rentACarOffice = rentACarOffice;
    }
}
