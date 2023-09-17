package com.user.service.services;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.service.entities.Hotel;
import com.user.service.entities.Rating;
import com.user.service.entities.User;
import com.user.service.exception.UserNotFoundException;
import com.user.service.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public User saveUser(User user) {
		String userId = UUID.randomUUID().toString();
		user.setUserId(userId);
		return userRepo.save(user);
	}

	@Override
	public List<User> getAllUsers() {

		 List<User> userList = userRepo.findAll();
		 	 
		 for(User u:userList) {
			 Rating[] list = 
					 restTemplate.getForObject("http://RATING-SERVICE/rating/user/"+u.getUserId(),Rating[].class);
			List<Rating> tempList = Arrays.stream(list).toList();
			
			 u.setRatings(tempList);
		 
			 
			 List<Rating> collect = tempList.stream().map(rating ->{
				 ResponseEntity<Hotel> hotelEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotel/" + rating.getHotelId(),Hotel.class);
				 Hotel hotel=hotelEntity.getBody();
			 rating.setHotel(hotel);
			 return rating;
			 }).collect(Collectors.toList());	
		 }
			 
		 
		 return  userList;
	}

	@Override
	public User getUser(String userId) {
		User user = userRepo.findById(userId).orElseThrow(()->new UserNotFoundException("User is not found with id "+userId));
		Rating[] list = 
				 restTemplate.getForObject("http://RATING-SERVICE/rating/user/"+userId,Rating[].class);
		List<Rating> ratingList = Arrays.stream(list).toList();
				
		List<Rating> ratesList = ratingList.stream().map(rating -> {
		    ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotel/" + rating.getHotelId(), Hotel.class);
		    Hotel hotel = forEntity.getBody();
		    rating.setHotel(hotel);
		    return rating;// Return the Hotel object from the map function
		}).collect(Collectors.toList());

//		list.stream().map(rating -> {
//			ResponseEntity<Hotel> hotelResponse = restTemplate.getForEntity("http://localhost:8082/hotel/"+rating.getHotelId(),Hotel.class);
//			Hotel hotel=hotelResponse.getBody();
//			rating.setHotel(hotel);
//		}).collect(Collectors.toList());
		user.setRatings(ratingList);
		
		return user;
	}

}
