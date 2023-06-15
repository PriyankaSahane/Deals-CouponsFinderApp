package com.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.exception.ResourceNotFoundException;

import com.app.model.Deals;
import com.app.repository.DealsRepository;
import com.app.service.SequenceGeneratorService;

import jakarta.validation.Valid;

//@CrossOrigin(origins = "http://localhost:8002")
@RestController
@RequestMapping("/api")
public class DealsController {
	@Autowired
	DealsRepository dealsRepository;
	@Autowired
    private SequenceGeneratorService sequenceGeneratorService;
	
	  @GetMapping("/Deals")
	  public List < Deals > getAllDeals() {
	        return dealsRepository.findAll();
	    }

	  @GetMapping("/Deals/{deal_id}")
	  public ResponseEntity <Deals> getDealsById(@PathVariable(value = "deal_id") int id)
			    throws ResourceNotFoundException {
			    	Deals deals = dealsRepository.findById(id)
			            .orElseThrow(() -> new ResourceNotFoundException("Deal not found for this id :: " + id));
			        return ResponseEntity.ok().body(deals);
			    }

	  @PostMapping("/Deals")
	  public Deals createDeal(@Valid @RequestBody Deals deals) {
	        deals.setDeal_id((int) sequenceGeneratorService.generateSequence(Deals.SEQUENCE_NAME));
	        return dealsRepository.save(deals);
	    }
	 
	    
	    @PutMapping("/Deals/{deal_id}")
	    public ResponseEntity <Deals> updateDeal(@PathVariable(value = "deal_id") int id,
	        @Valid @RequestBody Deals dealDetails) throws ResourceNotFoundException {
	    	Deals deal = dealsRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Deal not found for this id :: " + id));

	    	deal.setTitle(dealDetails.getTitle());
	    	deal.setDeal_category(dealDetails.getDeal_category());
	    	deal.setLink(dealDetails.getLink());
	    	deal.setIcon_link(dealDetails.getIcon_link());
	        deal.setView_deal(dealDetails.getView_deal());
	        final Deals updatedDeal = dealsRepository.save(deal);
	        return ResponseEntity.ok(updatedDeal);
	    }
	    
	    @DeleteMapping("/Deals/{deal_id}")
	    public Map <String,Boolean> deleteDeal(@PathVariable(value = "deal_id") int dealId)
	    throws ResourceNotFoundException {
	        Deals deal = dealsRepository.findById(dealId)
	            .orElseThrow(() -> new ResourceNotFoundException("Coupon not found for this id :: " + dealId));

	        dealsRepository.delete(deal);
	        Map < String, Boolean > response = new HashMap < > ();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }

	 
}
