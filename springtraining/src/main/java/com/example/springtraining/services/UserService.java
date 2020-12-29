package com.example.springtraining.services;

import java.util.List;
import java.util.Optional;

import com.example.springtraining.entities.UserEntity;

public interface UserService {

	public List<UserEntity> getUsers();
	
	public UserEntity upsertUser(UserEntity user);
	
	public Optional<UserEntity> findById(Long id);
	
	public void deleteUser(Long id);
}
