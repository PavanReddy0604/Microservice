package com.user.service.controller;

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

import com.user.service.entities.User;
import com.user.service.services.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserServiceImpl userService;
	
	@PostMapping("/")
	public ResponseEntity<User> createUser(@RequestBody User user){
		
		User savedUser = userService.saveUser(user);
		return new ResponseEntity<User>(savedUser,HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") String id){
		User user = userService.getUser(id);
		return new ResponseEntity<User>(user,HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<User>> getAllUser(){
		List<User> user = userService.getAllUsers();
		return new ResponseEntity<List<User>>(user,HttpStatus.CREATED);
	}

}
