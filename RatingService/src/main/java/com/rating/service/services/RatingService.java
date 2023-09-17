package com.rating.service.services;

import java.util.List;

import com.rating.service.entities.Rating;

public interface RatingService {
	
	
	Rating getRating(String id);
	
	List<Rating> getAllRatings();
	
	Rating saveRating(Rating rating);
	
	List<Rating> getRatingByUserId(String id);
	
	List<Rating> getRatingByHotelId(String id);

}
