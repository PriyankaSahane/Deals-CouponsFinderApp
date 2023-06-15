package com.app.impl;

import com.app.repository.*;
import com.app.entities.*;
import com.app.services.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DealsServiceImpl implements DealsService {
	@Autowired
	private DealsRepository rep;
	@Override
	public Deals create(Deals d) {
		// TODO Auto-generated method stub
		return rep.save(d);
	}

	@Override
	public List<Deals> getDeals() {
		// TODO Auto-generated method stub
		return rep.findAll();
	}
}
