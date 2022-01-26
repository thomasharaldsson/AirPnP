package com.airpnp.domainmodel;

import javax.persistence.*;

@Entity
public class Vehicle {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;
    private String registrationNumber;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Customer owner;
    @ManyToOne
    private VehicleType type;

    public Vehicle() {
    }

    /**
     * @param registrationNumber Registartion number of vehicle.
     * @param owner              Customer ID of person who owns this vehicle.
     */
    public Vehicle(String registrationNumber, Customer owner, VehicleType type) {
        this.registrationNumber = registrationNumber;
        this.owner = owner;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }
}
