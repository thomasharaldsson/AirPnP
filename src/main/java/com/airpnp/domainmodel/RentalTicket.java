package com.airpnp.domainmodel;

import javax.persistence.*;
import java.util.Date;

@Entity
public class RentalTicket {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Vehicle vehicle;

    @OneToOne
    private ParkingSpace parkingSpace;

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

    private Date startDate;

    private Date endDate;


    public RentalTicket() {

    }

    public ParkingSpace getParkingSpace() {
        return parkingSpace;
    }

    public void setParkingSpace(ParkingSpace parkingSpace) {
        this.parkingSpace = parkingSpace;
    }

    public RentalTicket(Customer customer, Vehicle vehicle, ParkingSpace parkingSpace) {

        this.customer = customer;
        this.vehicle = vehicle;
        this.parkingSpace = parkingSpace;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void removeCustomer() {
        customer = null;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public RentalTicket getRentalTicketByCustomerId(int id) {
        if (id == customer.getId()) {
            return this;
        }
        else {
            System.out.println("Did not find a rental ticket containing this customer ID");
            return null;
        }
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
