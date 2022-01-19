package com.airpnp.domainmodel;

import javax.persistence.*;

/** This is a simple rating class.
 *  A Person can take a rating.
 *  Perhaps should person have a list of ratings
 *  and then we take the average value of the ratings.
 */

@Entity
@Table(name = "ratings")
public class Rating {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int ratingId;
    private double rating;

    // needed for JPA - ignore until then
    public Rating() {}

    public Rating(double rating) {
        setRating(rating);
    }


    public int getRatingId() {
        return ratingId;
    }

    public void setRating(double rating) {
        if(rating > 0 && rating <= 5)
        this.rating = rating;
    }

    public double getRating() {
        return rating;
    }

}
