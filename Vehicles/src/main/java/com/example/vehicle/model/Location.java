package com.example.vehicle.model;

import javax.persistence.*;
import javax.validation.Valid;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private Integer id;
    @Valid
    private String name;
    @Valid
    private String address;

    public Location() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
