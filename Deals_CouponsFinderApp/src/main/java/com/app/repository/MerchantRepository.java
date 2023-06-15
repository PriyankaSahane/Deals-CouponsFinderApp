package com.app.repository;

import com.app.entities.Merchant;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface MerchantRepository extends MongoRepository<Merchant,String>{

}