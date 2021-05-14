package com.lima.cities.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lima.cities.entity.Country;
import com.lima.cities.exception.IdNotFoundException;
import com.lima.cities.service.CountryService;

@RestController
@RequestMapping("/countries")
public class CountryController {
	
	@Autowired
	private CountryService service;
	
	public CountryController(CountryService service) {
		this.service = service;
	}
	
	@GetMapping
	public Page<Country> countries(Pageable page){
		return service.listAll(page);
	}
	
	@GetMapping("/{id}")
	public Country listId(@PathVariable Long id) throws IdNotFoundException {
		return service.findById(id);
	}

}
