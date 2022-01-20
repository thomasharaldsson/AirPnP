package com.airpnp.domainmodel;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer extends Person {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;
    boolean isAdmin;
    @ManyToMany
    List<Rating> ratings = new ArrayList<>();

    @OneToMany(cascade = CascadeType.REMOVE)
    List<Vehicle> vehicles = new ArrayList<>();

    @OneToMany(cascade = CascadeType.REMOVE)
    List<RentalTicket> rentalTickets = new ArrayList<>();

    public Customer() {

    }

    public Customer(String firstName, String surName, String email, String phoneNumber, String username, String password, Rating r, boolean isAdmin) {
        super(firstName, surName, email, phoneNumber, username, password);
        this.setAdmin(isAdmin);
        this.ratings.add(r);
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void addRating(Rating rating) {
        ratings.add(rating);
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public double getRating() {
        double totalValueOfRatings = 0;
        for (Rating rating : ratings) {
            totalValueOfRatings = (totalValueOfRatings + rating.getRating()) / ratings.size();
        }
        return totalValueOfRatings;
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }


    public List<Vehicle> getVehicles() {
        return this.vehicles;
    }

    @Override
    public String toString() {
        return "Customer id=" + this.getId() + " name: " + this.getFirstName() + " "
                + this.getSurName();// + " with average rating: " + getRating();
    }

}
