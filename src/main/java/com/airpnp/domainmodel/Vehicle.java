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

    public Vehicle() {
    }

    /**
     *
     * @param id vehicle ID in database.
     * @param registrationNumber Registartion number of vehicle.
     * @param owner Customer ID of person who owns this vehicle.
     */
    public Vehicle(Integer id, String registrationNumber, Customer owner) {
        this.id = id;
        this.registrationNumber = registrationNumber;
        this.owner = owner;
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
}
