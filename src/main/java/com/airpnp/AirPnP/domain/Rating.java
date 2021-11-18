package com.airpnp.AirPnP.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/** This is a simple rating class.
 *  A Person can take a rating.
 *  Perhaps should person have a list of ratings
 *  and then we take the average value of the ratings.
 */

@Entity
@Table(name = "ratings")
public class Rating {
    @Id
    private int ratingId;
    private double rating;

    // needed for JPA - ignore until then
    public Rating() {}

    public Rating(double rating) {
        setRating(rating);
    }


    public void setRating(double rating) {
        if(rating > 0 && rating <= 5)
        this.rating = rating;
    }

    public double getRating() {
        return rating;
    }

}
