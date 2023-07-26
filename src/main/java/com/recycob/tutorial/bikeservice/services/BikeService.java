package com.recycob.tutorial.bikeservice.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.recycob.tutorial.bikeservice.entities.Bike;
import com.recycob.tutorial.bikeservice.repositories.BikeRepository;

@Service
public class BikeService {
	
	BikeRepository bikeRepository;
	
	public BikeService(BikeRepository carRepository) {
		this.bikeRepository = carRepository;
	}

	public List<Bike> getAll() {
		return bikeRepository.findAll();
	}
	
	public Bike getUserById(int id) {
		return bikeRepository.findById(id).orElse(null);
	}
	
	public Bike save(Bike bike) {
		Bike newBike = bikeRepository.save(bike);
		
		return newBike;
	}
	
	public List<Bike> getByUserId(int userId) {
		return bikeRepository.findByUserId(userId);		
	}
}