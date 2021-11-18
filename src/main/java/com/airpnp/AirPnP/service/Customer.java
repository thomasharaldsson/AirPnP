package com.airpnp.AirPnP.service;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {

    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    private long id;
    private String firstName;
    private String surName;
    private String email;
    private String phoneNumber;

    public Customer() {}

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", surName='" + surName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
