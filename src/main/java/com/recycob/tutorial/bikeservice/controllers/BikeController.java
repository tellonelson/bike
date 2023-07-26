package com.recycob.tutorial.bikeservice.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recycob.tutorial.bikeservice.entities.Bike;
import com.recycob.tutorial.bikeservice.services.BikeService;

@RestController
@RequestMapping("/bikes")
public class BikeController {
	
	BikeService bikeService;

	public BikeController(BikeService bikeService) {
		this.bikeService = bikeService;
	}

	
	@GetMapping
	public ResponseEntity<List<Bike>> getAll() {
		
		List<Bike> bikes = bikeService.getAll();
		if(bikes.isEmpty())
			return ResponseEntity.noContent().build();
		
		return ResponseEntity.ok(bikes);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Bike> getById(@PathVariable("id") int id) {
		
		Bike car = bikeService.getUserById(id);
		if(car == null)
			return ResponseEntity.noContent().build();
		
		return ResponseEntity.ok(car);
		
	}


	@PostMapping()
	public ResponseEntity<Bike> save(@RequestBody Bike bike) {
		
		Bike newBike = bikeService.save(bike);
		
		return ResponseEntity.ok(newBike);
		
	}

	@GetMapping("/byuser/{userId}")
	public ResponseEntity<List<Bike>> getByUserId(@PathVariable("userId") int userId) {
		
		List<Bike> bikes = bikeService.getByUserId(userId);
		if(bikes.isEmpty())
			return ResponseEntity.noContent().build();
		
		return ResponseEntity.ok(bikes);
		
	}

}