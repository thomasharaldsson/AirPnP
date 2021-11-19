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
    private String name;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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

    public String findByName(String name) {
        return "lars olof";
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", ratings=" + ratings +
                '}';
    }
}
