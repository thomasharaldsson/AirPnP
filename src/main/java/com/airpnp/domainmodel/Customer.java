package com.airpnp.domainmodel;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;
    private String firstName;
    private String surName;
    private String email;
    private String phoneNumber;

    @ManyToMany
    List<Rating> ratings = new ArrayList<>();

    public Customer() {

    }

    public Customer(Integer id, String firstName, String surName, String email, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.surName = surName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        //this.ratings = ratings;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
        for (Rating rating : ratings) {
            totalValueOfRatings = (totalValueOfRatings + rating.getRating()) / ratings.size();
        }
        return totalValueOfRatings;
    }

    @Override
    public String toString() {
        return "Customer id=" + this.getId() + " name: " + this.getFirstName() + " "
                + this.getSurName();// + " with average rating: " + getRating();
    }
}
