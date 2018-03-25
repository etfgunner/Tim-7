package com.example.account_m.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class RentACarOffice {

    @Id
    @GeneratedValue
    private long id;

    private String officeName;

    private int carsNumber;

    private int locationID;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public int getCarsNumber() {
        return carsNumber;
    }

    public void setCarsNumber(int carsNumber) {
        this.carsNumber = carsNumber;
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }
}
