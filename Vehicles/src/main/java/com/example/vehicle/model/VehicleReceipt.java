package com.example.vehicle.model;

import javax.persistence.*;
import javax.validation.Valid;

@Entity
public class VehicleReceipt {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private Integer id;
    @OneToOne
    @JoinColumn(name = "id")
    private Vehicle vehicleID;
    @Valid
    private float costPerDay;
    @Valid
    private float deposit;

    public VehicleReceipt() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Vehicle getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(Vehicle vehicleID) {
        this.vehicleID = vehicleID;
    }

    public float getCostPerDay() {
        return costPerDay;
    }

    public void setCostPerDay(float costPerDay) {
        this.costPerDay = costPerDay;
    }

    public float getDeposit() {
        return deposit;
    }

    public void setDeposit(float deposit) {
        this.deposit = deposit;
    }
}
