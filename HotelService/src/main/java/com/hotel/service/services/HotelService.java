package com.hotel.service.services;

import java.util.List;

import com.hotel.service.entities.Hotel;

public interface HotelService {

	
	Hotel getHotel(String id);
	
	List<Hotel> getAllHotels();
	
	Hotel saveHotel(Hotel hotel);
}
