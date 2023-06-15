package com.app.services;

import java.util.List;

import com.app.entities.Deals;

public interface DealsService {

	// create
		Deals create(Deals deal);
		
		//get all rating
		List<Deals> getDeals();
}
