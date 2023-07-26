package com.recycob.tutorial.bikeservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recycob.tutorial.bikeservice.entities.Bike;

public interface BikeRepository extends JpaRepository<Bike, Integer> {
	
	List<Bike> findByUserId(int userId);
}
