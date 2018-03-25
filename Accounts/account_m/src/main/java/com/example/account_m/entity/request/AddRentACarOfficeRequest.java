package com.example.account_m.entity.request;

public class AddRentACarOfficeRequest {

    private String officeName;

    private int carsNumber;

    private int locationID;


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
