package com.lima.cities.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lima.cities.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {

}
