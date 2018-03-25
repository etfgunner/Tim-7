package com.example.account_m.entity.request;

import com.example.account_m.entity.RentACarOffice;
import com.example.account_m.entity.Salesman;

public class AddVehicleDisposeOfRequest {

    private int vehicleID;

    private String reason;

    private RentACarOffice rentACarOffice;

    private Salesman salesman;

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
