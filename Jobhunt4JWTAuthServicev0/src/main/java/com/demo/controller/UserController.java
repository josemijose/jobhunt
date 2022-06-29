package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.User;
import com.demo.repository.UserRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
//@RequestMapping("/users")

public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable(value="id")Long userId) {
		User user=userRepository.findById(userId).get();
		return user;
	}
	
	
	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		System.err.println(user);
	return userRepository.save(user);
}


}
