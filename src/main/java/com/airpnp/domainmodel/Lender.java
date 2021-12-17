package com.airpnp.domainmodel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Lender extends Person {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;

    public Lender() {
    }

    public Lender(String firstName, String surName, String email, String phoneNumber, Integer id, String username, String password) {
        super(firstName, surName, email, phoneNumber, username, password);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
