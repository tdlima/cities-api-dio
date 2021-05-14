package com.lima.cities.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lima.cities.entity.State;
import com.lima.cities.exception.IdNotFoundException;
import com.lima.cities.service.StateService;

@RestController
@RequestMapping("/states")
public class StateController {
	
	@Autowired
	private StateService service;
	
	public StateController(StateService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<State> staties(){
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public State listId(@PathVariable Long id) throws IdNotFoundException {
		return service.listId(id);
	}
}
