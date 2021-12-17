package com.airpnp.domainmodel;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ParkingSpace {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;
    @OneToOne
    @PrimaryKeyJoinColumn
    private RentalTicket ticket;
    private int price;
    private Date startDate;
    private Date endDate;
    private String streetAddress;
    @ManyToOne
    @PrimaryKeyJoinColumn
    private Lender owner;


    public ParkingSpace(int price, Date startDate, Date endDate, String streetAddress) {
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.streetAddress = streetAddress;
    }

    public ParkingSpace() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }


    public RentalTicket getTicket() {
        return ticket;
    }

    public void setTicket(RentalTicket ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return "ParkingSpace{" +
                "id=" + id +
                ", price=" + price +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", streetAddress='" + streetAddress + '\'' +
                '}';
    }
}
