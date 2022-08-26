package com.spring.crud.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.crud.dto.UserDto;
import com.spring.crud.model.User;
import com.spring.crud.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
//	private List<String> defaultRoles = Arrays.asList("MANAGER","USER");
	
	public User addUser(UserDto userDto) {
		User user = new User();
		user.setUsername(userDto.getUsername());
		user.setPassword(userDto.getPassword());
		user.setRole("MANAGER,USER");
		return userRepository.save(user);
	}
	
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	public User getUserbyId(int id) {
		return userRepository.findById(id).orElse(null);
	}
	
}
