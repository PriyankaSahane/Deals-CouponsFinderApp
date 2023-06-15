package com.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Deals;
@Repository
public interface DealsRepository extends MongoRepository<Deals,Integer>{
	
}
