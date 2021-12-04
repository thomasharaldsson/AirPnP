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

    public Vehicle(String registrationNumber, Customer owner) {
        this.registrationNumber = registrationNumber;
        this.owner = owner;
    }

    public Customer getOwner() {
        return owner;
    }

    public Integer getId() {
        return id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }
}
