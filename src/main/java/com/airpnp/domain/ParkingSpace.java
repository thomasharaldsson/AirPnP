package com.airpnp.domain;

import java.util.Date;

public class ParkingSpace {

    private int id;
    private int price;
    private Date startDate;
    private Date endDate;
    private String streetAddress;

    public ParkingSpace(int id, int price, Date startDate, Date endDate, String streetAddress) {
        this.id = id;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.streetAddress = streetAddress;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getStreetAddress() {
        return streetAddress;
    }
}
