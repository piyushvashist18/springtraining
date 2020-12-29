package com.example.springtraining.controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class Confiuration {

	@Bean
	ObjectMapper objectMapper() {
		return new ObjectMapper();
	}
}
