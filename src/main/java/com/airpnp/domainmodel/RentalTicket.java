package com.airpnp.domainmodel;

import javax.persistence.*;

@Entity
public class RentalTicket {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;
    @ManyToOne
    private Customer customer;

    @OneToOne
    ParkingSpace parkingSpace;

    public RentalTicket() {

    }

    public ParkingSpace getParkingSpace() {
        return parkingSpace;
    }

    public void setParkingSpace(ParkingSpace parkingSpace) {
        this.parkingSpace = parkingSpace;
    }

    public RentalTicket(Integer id, Customer customer, Vehicle vehicle, ParkingSpace parkingSpace) {
        this.id = id;
        this.customer = customer;
        this.vehicle = vehicle;
        this.parkingSpace = parkingSpace;
    }

    @ManyToOne
    Vehicle vehicle;

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

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
