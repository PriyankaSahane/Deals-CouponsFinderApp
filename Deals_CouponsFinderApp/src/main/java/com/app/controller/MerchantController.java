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

import com.app.entities.Merchant;
import com.app.services.MerchantService;

@RestController
@RequestMapping("/Merchant")
public class MerchantController {
	
	@Autowired
	private MerchantService merchantService;
	//create merchant
	@PostMapping
	public ResponseEntity<Merchant> create(@RequestBody Merchant m){
		return ResponseEntity.status(HttpStatus.CREATED).body(merchantService.create(m));
	}
	
	//getAll
	@GetMapping
	public ResponseEntity<List<Merchant>> getMerchant(){
		return ResponseEntity.ok(merchantService.getMerchant());
	}

}
