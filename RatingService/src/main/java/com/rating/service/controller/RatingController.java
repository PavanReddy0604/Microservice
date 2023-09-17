package com.rating.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rating.service.entities.Rating;
import com.rating.service.services.RatingServiceImpl;

@RestController
@RequestMapping("/rating")
public class RatingController {

	@Autowired
	private RatingServiceImpl ratingService;
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Rating> getRating(@PathVariable("id") String id){
		return new ResponseEntity<Rating>(ratingService.getRating(id),HttpStatus.OK);
	}
	@GetMapping("/user/{id}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable("id") String id){
		return new ResponseEntity<List<Rating>>(ratingService.getRatingByUserId(id),HttpStatus.OK);
	}
	
	@GetMapping("/hotel/{id}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable("id") String id){
		return new ResponseEntity<List<Rating>>(ratingService.getRatingByHotelId(id),HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Rating>> getAllRatings(){
		return new ResponseEntity<List<Rating>>(ratingService.getAllRatings(),HttpStatus.OK);
		
	}
	@PostMapping("/")
	public ResponseEntity<Rating> saveRating(@RequestBody Rating rating){
		return new ResponseEntity<Rating>(ratingService.saveRating(rating),HttpStatus.OK);
	}
}
