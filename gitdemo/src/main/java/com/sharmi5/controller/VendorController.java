package com.sharmi5.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod; 
import org.springframework.web.bind.annotation.RestController;

import com.sharmi5.entities.Vendor;
import com.sharmi5.service.vendorService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController

@Component
public class VendorController {
	@Autowired
	vendorService vendorService; 
	
	//ES_GET_ENTITYSET
	@RequestMapping("/vendor")
	public List<Vendor> getVendors(){
		return vendorService.readAllVendors();		
	}

	
	
	//ES_CREATE_ENTITY
	@PostMapping("/vendor")
	public Vendor createVendor(@RequestBody Vendor myPostBody) {
		System.out.println(myPostBody);
		return vendorService.createVendor(myPostBody);
	}
	
//Test using localhost:8080/vendor/search?company=ibm
	@RequestMapping("/vendor/search")
	public List<Vendor> searchByCompany(@RequestParam String company){
		return vendorService.searchByCompanyName(company);
	}

//Test using localhost:8080/vendor/lookp/67	
	@RequestMapping("/vendor/lookup/{gstNo}")
	public List<Vendor> searchVendorByGST(@PathVariable("gstNo") String GSTNo){
		return vendorService.lookupVendorByGST(GSTNo);
	}
	
	
	//ES_GET_ENTITY
	@RequestMapping("/vendor/{vendorCode}")
	public Vendor getVendorById(@PathVariable("vendorCode") Long code) {
		Optional<Vendor> searchResult = vendorService.getSingleVendor(code);
		if(!searchResult.isPresent()) {
			return new Vendor((long)0, "","","","","","",null);
		}
	
		return searchResult.get();
}
	
//	@RequestMapping("/vendor/{vendorCode}")
//	public Vendor getVendorById(@PathVariable("vendorCode") Long code) {
//		return vendorService.getSingleVendor(code);
//	}
	@RequestMapping(method=RequestMethod.PUT, value="/vendor")
	public Vendor updateVendor(@RequestBody Vendor vendor) {
		return vendorService.changeVendor(vendor);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/vendor/{id}")
	public String removeVendor(@PathVariable("id") Long Id) {
		return vendorService.deleteVendor(Id);
	}
	
		
	}

