package com.rating.service.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rating.service.entities.Rating;
import com.rating.service.exceptions.RatingNotFoundException;
import com.rating.service.repository.RatingRepository;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingRepository ratingRepo;
	
	@Override
	public Rating getRating(String id) {
		// TODO Auto-generated method stub
		return ratingRepo.findById(id).orElseThrow(()-> new RatingNotFoundException("rating is not found with id "+id));
	}

	@Override
	public List<Rating> getAllRatings() {
		// TODO Auto-generated method stub
		return ratingRepo.findAll();
	}

	@Override
	public Rating saveRating(Rating rating) {
		String ratingId=UUID.randomUUID().toString();
		rating.setRatingId(ratingId);
		return ratingRepo.save(rating);
	}

	@Override
	public List<Rating> getRatingByUserId(String id) {
		
		return ratingRepo.findByUserId(id) ;
	}

	@Override
	public List<Rating> getRatingByHotelId(String id) {
		// TODO Auto-generated method stub
		return ratingRepo.findByHotelId(id);
	}

}
