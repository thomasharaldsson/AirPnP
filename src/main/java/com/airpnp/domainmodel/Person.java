package com.airpnp.domainmodel;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Person {
    private String firstName;
    private String surName;
    private String email;
    private String phoneNumber;
    private String password;
    private String username;

    public Person() {
    }

    public Person(String firstName, String surName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.surName = surName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
