package com.lima.cities.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lima.cities.entity.State;

public interface StateRepository extends JpaRepository<State, Long> {

}
