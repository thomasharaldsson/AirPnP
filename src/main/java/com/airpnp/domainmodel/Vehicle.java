package com.airpnp.domainmodel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vehicle {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;
    private String registrationNumber;
}
