package com.app.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.repository.*;
import com.app.entities.*;
import com.app.services.*;
@Service
public class MerchantServiceImpl implements MerchantService{
    @Autowired
	private MerchantRepository rep;
	@Override
	public Merchant create(Merchant m) {
		// TODO Auto-generated method stub
		return rep.save(m);
	}

	@Override
	public List<Merchant> getMerchant() {
		// TODO Auto-generated method stub
		return rep.findAll();
	}

}
