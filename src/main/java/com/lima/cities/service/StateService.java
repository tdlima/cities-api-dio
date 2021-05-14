package com.lima.cities.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lima.cities.entity.State;
import com.lima.cities.exception.IdNotFoundException;
import com.lima.cities.repository.StateRepository;

@Service
public class StateService {
	
	@Autowired
	private StateRepository repository;
	
	public StateService(StateRepository repository) {
		this.repository = repository;
	}

	public List<State> findAll() {
		return repository.findAll();
	}

	public State listId(Long id) throws IdNotFoundException {
		State state = repository.findById(id)
				.orElseThrow(()-> new IdNotFoundException(id));
		return state;
	}
	
	
}
