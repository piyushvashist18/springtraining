package com.example.springtraining.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.springtraining.entities.UserEntity;
import com.example.springtraining.repositories.UserRepository;

@Service
@Profile("!stub")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public List<UserEntity> getUsers(){
		return userRepo.findAll();
	}
	
	@Override
	public UserEntity upsertUser(UserEntity user) {
		return userRepo.save(user);
	}

	@Override
	public Optional<UserEntity> findById(Long id) {
		
		return userRepo.findById(id);
	}

	@Override
	public void deleteUser(Long id) {
		userRepo.deleteById(id);
		
	}
}
