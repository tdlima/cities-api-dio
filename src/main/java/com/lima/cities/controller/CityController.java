package com.lima.cities.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lima.cities.entity.City;
import com.lima.cities.exception.IdNotFoundException;
import com.lima.cities.service.CityService;

@RestController
@RequestMapping("/cities")
public class CityController {
	
	@Autowired
	private CityService service;
	
	public CityController(CityService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<City> cities(){
		return service.listCities();
	}
	
	@GetMapping("/{id}")
	public City listId(@PathVariable Long id) throws IdNotFoundException {
		return service.listId(id);
	}
}
