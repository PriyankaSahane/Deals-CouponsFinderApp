package com.app.repository;
import com.app.entities.Deals;
//import com.app.entities.Merchant;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DealsRepository extends MongoRepository<Deals,String> {

	Deals save(Deals d);
	List<Deals> findAll();

}