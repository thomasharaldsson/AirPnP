package com.airpnp.AirPnP.domain;

import com.airpnp.AirPnP.domain.Rating;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {

    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    private long id;
    private String firstName;
    private String surName;
    private String email;
    private String phoneNumber;
    @OneToMany
    List<Rating> ratings = new ArrayList<>();

    public Customer() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public void addRating(Rating rating) {
        ratings.add(rating);
    }

    public double getRating() {
        double totalValueOfRatings = 0;
        for(Rating rating : ratings) {
            totalValueOfRatings = totalValueOfRatings + rating.getRating();
        }
        return totalValueOfRatings;
    }

    @Override
    public String toString() {
        return "Customer name: " + firstName + " " + surName;
    }
}
