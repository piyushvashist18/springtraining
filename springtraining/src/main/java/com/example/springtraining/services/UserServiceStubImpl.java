package com.example.springtraining.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.springtraining.entities.UserEntity;

@Service
@Profile("stub")
public class UserServiceStubImpl implements UserService{

	@Override
	public List<UserEntity> getUsers() {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

	@Override
	public UserEntity upsertUser(UserEntity user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<UserEntity> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		
	}

}
