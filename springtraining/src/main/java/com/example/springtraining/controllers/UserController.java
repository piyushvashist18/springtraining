package com.example.springtraining.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springtraining.entities.UserEntity;
import com.example.springtraining.exceptions.ResourceNotFoundException;
import com.example.springtraining.repositories.UserRepository;
import com.example.springtraining.services.UserService;

@RestController
public class UserController {

	private final static Logger LOGGER = LogManager.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	
	@Value("${flag}")
	private String flag;

	@GetMapping(value = "/users")
	public List<UserEntity> getUsers() {
		LOGGER.debug("falg : {} ",flag);
		return userService.getUsers();
	}

	@PostMapping(path = "/users", consumes = "application/json", produces = "application/json")
	public UserEntity addUser(@RequestBody UserEntity user) {
		return userService.upsertUser(user);
	}

	@PutMapping("/users/{id}")
	public ResponseEntity<Object> updateUser(@PathVariable(value = "id") Long id, @RequestBody UserEntity user) {
		try {
			LOGGER.debug("User id : {}",id);
			UserEntity userInfo = userService.findById(id).orElseThrow(() -> new ResourceNotFoundException());
		} catch (ResourceNotFoundException e) {
			return new ResponseEntity<>("User id does not exists.", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(userService.upsertUser(user), HttpStatus.OK);
	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable(value = "id") Long id, @RequestBody UserEntity user) {
		try {
			UserEntity userInfo = userService.findById(id).orElseThrow(() -> new ResourceNotFoundException());
		} catch (ResourceNotFoundException e) {
			return new ResponseEntity<>("User id does not exists.", HttpStatus.BAD_REQUEST);
		}
		try {
			userService.deleteUser(id);
		} catch (Exception e) {
			return new ResponseEntity<>("Exception occurred while deleting the user", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>("User deleted successfully.", HttpStatus.OK);
	}
}
