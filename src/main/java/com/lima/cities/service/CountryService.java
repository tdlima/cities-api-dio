package com.lima.cities.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lima.cities.entity.Country;
import com.lima.cities.exception.IdNotFoundException;
import com.lima.cities.repository.CountryRepository;

@Service
public class CountryService {
	
	@Autowired
	private CountryRepository repository;
	
	public CountryService(CountryRepository repository) {
		this.repository = repository;
	}

	public Page<Country> listAll(Pageable page) {
		return repository.findAll(page);
	}

	public Country findById(Long id) throws IdNotFoundException {
		Country countries = repository.findById(id)
				.orElseThrow(()-> new IdNotFoundException(id));
		return countries;
	}

}
