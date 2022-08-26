package com.spring.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.crud.dto.UserDto;
import com.spring.crud.model.User;
import com.spring.crud.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@RequestBody UserDto userDto) {
		User user = userService.addUser(userDto);
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getUsers(){
		 List<User> users = userService.getUsers();
		 return new ResponseEntity<>(users,HttpStatus.OK);
	}
}
