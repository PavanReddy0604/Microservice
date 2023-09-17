package com.hotel.service.controller;

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

import com.hotel.service.entities.Hotel;
import com.hotel.service.services.HotelServiceIml;

@RestController
@RequestMapping("/hotel")
public class HotelController {
	
	@Autowired
	private HotelServiceIml hotelService;
	
	@GetMapping("/{id}")
	private ResponseEntity<Hotel> getHotel(@PathVariable("id") String id){
		return new ResponseEntity<Hotel>(hotelService.getHotel(id),HttpStatus.OK);
	}
	
	@GetMapping("/")
	private ResponseEntity<List<Hotel>> getAllHotels(){
		return new ResponseEntity<List<Hotel>>(hotelService.getAllHotels(),HttpStatus.OK);
	}
	
	@PostMapping("/")
	private ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel){
		return new ResponseEntity<Hotel>(hotelService.saveHotel(hotel),HttpStatus.OK);
	}
	
	
	

}
