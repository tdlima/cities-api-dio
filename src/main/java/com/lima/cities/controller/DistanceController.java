package com.lima.cities.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lima.cities.service.DistanceService;

@RestController
@RequestMapping("/distances")
public class DistanceController {

  private static Logger log = LoggerFactory.getLogger(DistanceController.class);
  @Autowired
  private DistanceService service;

  public DistanceController(DistanceService service) {
    this.service = service;
  }

  @GetMapping("/by-points")
  public ResponseEntity byPoints(@RequestParam(name = "from") Long city1,
                         @RequestParam(name = "to") Long city2) {
    log.info("byPoints");
    return ResponseEntity.ok().body(service.distanceByPointsInMiles(city1, city2));
  }

  @GetMapping("/by-cube")
  public ResponseEntity byCube(@RequestParam(name = "from") Long city1,
                       @RequestParam(name = "to") Long city2) {
    log.info("byCube");
    return ResponseEntity.ok().body(service.distanceByCubeInMeters(city1, city2));
  }

}