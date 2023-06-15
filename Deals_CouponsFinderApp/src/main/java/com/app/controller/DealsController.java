package com.app.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Deals;
import com.app.services.DealsService;

@RestController
@RequestMapping("/Deals")
public class DealsController {

	@Autowired
	private DealsService dealsService;
	//create merchant
	@PostMapping
	public ResponseEntity<Deals> create(@RequestBody Deals d){
		return ResponseEntity.status(HttpStatus.CREATED).body(dealsService.create(d));
	}
	
	//getAll
	@GetMapping
	public ResponseEntity<List<Deals>> getDeals(){
		return ResponseEntity.ok(dealsService.getDeals());
	}
}
