package com.example.springtraining.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springtraining.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

	List<UserEntity> findByName(String name);
	
}
