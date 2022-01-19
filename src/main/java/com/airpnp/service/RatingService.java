package com.airpnp.service;

import com.airpnp.data.exception.RatingNotFoundException;
import com.airpnp.domainmodel.Rating;

import java.util.List;

public interface RatingService {
    Rating updateRating(Rating rate);
    void addRating(Rating rate);
    List<Rating>getAll();
    void deleteAll();
    Rating getRatingById(Integer ratingId) throws RatingNotFoundException;
}
