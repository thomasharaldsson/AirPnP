package com.airpnp.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer extends Person {

    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    private long id;

    @OneToMany
    List<Rating> ratings = new ArrayList<>();

    public Customer() {}

    public long getId() {
        return id;
    }

    public void addRating(Rating rating) {
        ratings.add(rating);
    }

    public double getRating() {
        double totalValueOfRatings = 0;
        for(Rating rating : ratings) {
            totalValueOfRatings = (totalValueOfRatings + rating.getRating()) / ratings.size();
        }
        return totalValueOfRatings;
    }

    @Override
    public String toString() {
        return "Customer name: " + this.getFirstName() + " "
                + this.getSurName() + " with average rating: " + getRating();
    }
}
