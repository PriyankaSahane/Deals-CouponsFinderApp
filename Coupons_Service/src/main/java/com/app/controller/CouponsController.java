package com.app.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.exception.*;
import com.app.model.Coupons;
import com.app.repository.CouponsRepository;
import com.app.service.SequenceGeneratorService;
//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CouponsController {
	@Autowired
    private CouponsRepository couponsRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @GetMapping("/Coupon")
    public List <Coupons> getAllCoupons() {
        return couponsRepository.findAll();
    }
    
    @GetMapping("/Coupon/{coupon_id}")
    public ResponseEntity <Coupons> getCouponsById(@PathVariable(value = "coupon_id") int id)
    throws ResourceNotFoundException {
    	Coupons coupon = couponsRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Coupon not found for this id :: " + id));
        return ResponseEntity.ok().body(coupon);
    }
    @PostMapping("/Coupon")
    public Coupons createCoupon(@Valid @RequestBody Coupons coupon) {
        coupon.setCoupon_id((int) sequenceGeneratorService.generateSequence(Coupons.SEQUENCE_NAME));
        return couponsRepository.save(coupon);
    }
    
    @PutMapping("/Coupon/{coupon_id}")
    public ResponseEntity <Coupons> updateCoupon(@PathVariable(value = "coupon_id") int id,
        @Valid @RequestBody Coupons couponDetails) throws ResourceNotFoundException {
    	Coupons coupon = couponsRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Coupon not found for this id :: " + id));

    	coupon.setTitle(couponDetails.getTitle());
    	coupon.setCoupon_category(couponDetails.getCoupon_category());
    	coupon.setLink(couponDetails.getLink());
    	coupon.setIcon_link(couponDetails.getIcon_link());
        coupon.setView_details(couponDetails.getView_details());
        final Coupons updatedCoupon = couponsRepository.save(coupon);
        return ResponseEntity.ok(updatedCoupon);
    }
    
    @DeleteMapping("/Coupon/{coupon_id}")
    public Map <String,Boolean> deleteCoupon(@PathVariable(value = "coupon_id") int couponId)
    throws ResourceNotFoundException {
        Coupons coupon = couponsRepository.findById(couponId)
            .orElseThrow(() -> new ResourceNotFoundException("Coupon not found for this id :: " + couponId));

        couponsRepository.delete(coupon);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
