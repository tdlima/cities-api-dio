package com.lima.cities.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lima.cities.entity.City;
import com.lima.cities.exception.IdNotFoundException;
import com.lima.cities.repository.CityRepository;

@Service
public class CityService {
	
	@Autowired
	private CityRepository repository;
	
	public CityService(CityRepository repository) {
		this.repository = repository;
	}

	public List<City> listCities() {
		return repository.findAll();
	}

	public City listId(Long id) throws IdNotFoundException {
		City cities = repository.findById(id)
				.orElseThrow(()-> new IdNotFoundException(id));
		return cities;
	}
}
