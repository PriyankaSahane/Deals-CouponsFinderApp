package com.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Coupons;
//import com.app.model.Deals;
@Repository
public interface CouponsRepository extends MongoRepository <Coupons,Integer>{

	Object findByTitle(String t);

}
