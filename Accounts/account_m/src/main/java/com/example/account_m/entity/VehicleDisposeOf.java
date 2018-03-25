package com.example.account_m.entity;

import javax.persistence.*;

@Entity
public class VehicleDisposeOf {

    @Id
    @GeneratedValue
    private long id;

    private int vehicleID;

    private String reason;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    @JoinColumn(name = "rentACarOffice_id")
    private RentACarOffice rentACarOffice;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    @JoinColumn(name = "salesman_id")
    private Salesman salesman;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public RentACarOffice getRentACarOffice() {
        return rentACarOffice;
    }

    public void setRentACarOffice(RentACarOffice rentACarOffice) {
        this.rentACarOffice = rentACarOffice;
    }

    public Salesman getSalesman() {
        return salesman;
    }

    public void setSalesman(Salesman salesman) {
        this.salesman = salesman;
    }
}
