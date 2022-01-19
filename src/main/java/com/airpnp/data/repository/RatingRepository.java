package com.airpnp.data.repository;

import com.airpnp.domainmodel.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Integer> {

}
