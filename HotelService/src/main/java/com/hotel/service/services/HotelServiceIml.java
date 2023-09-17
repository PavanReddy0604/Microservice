package com.hotel.service.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.service.entities.Hotel;
import com.hotel.service.exception.HotelNotFoundException;
import com.hotel.service.repository.HotelRepository;

@Service
public class HotelServiceIml implements HotelService {

	@Autowired
	private HotelRepository hotelRepo;
	@Override
	public Hotel getHotel(String id) {
		// TODO Auto-generated method stub
		return hotelRepo.findById(id).orElseThrow(()->new HotelNotFoundException("hotel not found with id "+id));
	}

	@Override
	public List<Hotel> getAllHotels() {
		List<Hotel> hotels = hotelRepo.findAll();
		return hotels;
	}

	@Override
	public Hotel saveHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		String hotelId=UUID.randomUUID().toString();
		hotel.setHotelId(hotelId);
		return hotelRepo.save(hotel);
	}

}
