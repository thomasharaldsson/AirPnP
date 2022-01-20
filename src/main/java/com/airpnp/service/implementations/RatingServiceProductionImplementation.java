package com.airpnp.service.implementations;

import com.airpnp.data.exception.RatingNotFoundException;
import com.airpnp.data.repository.RatingRepository;
import com.airpnp.domainmodel.Rating;
import com.airpnp.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceProductionImplementation implements RatingService {

    @Autowired
    private RatingRepository data;

    @Override
    public void updateRating(Rating rate) throws RatingNotFoundException {
        Integer ratingid = rate.getRatingId();
        if (!data.existsById(ratingid)) {
            throw new RatingNotFoundException("unable to update rating" + ratingid);
        }
    }

    @Override
    public void addRating(Rating rate) {
        data.save(rate);
    }


    @Override
    public List<Rating> getAll() {
        return data.findAll();
        
    }

    @Override
    public void deleteAll() {
        data.deleteAll();
    }

    @Override
    public Rating getRatingById(Integer ratingId) throws RatingNotFoundException {
        if(data.findById(ratingId).isPresent()) {
            return data.findById(ratingId).get();
        }else {
            throw new RatingNotFoundException("no rating found for: " + ratingId);
        }
    }
}
