package com.example.vehicle.model;

import javax.persistence.*;
import javax.validation.Valid;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private Integer id;
    @Valid
    private String brand;
    @Valid
    private String name;
    @Valid
    private String type;
    @Valid
    private Integer producedYear;
    @Valid
    private String transmission;
    @Valid
    private String color;
    @OneToOne
    @JoinColumn(name = "id")
    private Location locationID;
    @Valid
    private boolean available;

    public Vehicle() {
    }

    public Vehicle(@Valid String brand, @Valid String name, @Valid String type, @Valid Integer producedYear, @Valid String transmission, @Valid String color, Location locationID, @Valid boolean available) {
        this.brand = brand;
        this.name = name;
        this.type = type;
        this.producedYear = producedYear;
        this.transmission = transmission;
        this.color = color;
        this.locationID = locationID;
        this.available = available;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getProducedYear() {
        return producedYear;
    }

    public void setProducedYear(Integer producedYear) {
        this.producedYear = producedYear;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Location getLocationID() {
        return locationID;
    }

    public void setLocationID(Location locationID) {
        this.locationID = locationID;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString(){
        return "Vehicle{" + " id = "+ id +
                            " brand = "+ brand +
                            " name = " + name +
                            " type = " + type +
                            " producedYear = " + producedYear +
                            " transmission = " + transmission +
                            " color = " + color +
                            " locationID = " + locationID +
                            " available= " + available +
                        '}';
    }
}
