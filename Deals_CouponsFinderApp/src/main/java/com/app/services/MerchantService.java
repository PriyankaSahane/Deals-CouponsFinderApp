package com.app.services;
import com.app.entities.*;

import java.util.List;

//import org.springframework.stereotype.Service;
public interface MerchantService {

	// create
	Merchant create(Merchant merchant);
	
	//get all rating
	List<Merchant> getMerchant();
}
