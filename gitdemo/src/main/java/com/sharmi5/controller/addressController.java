package com.sharmi5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.sharmi5.entities.address;
import com.sharmi5.service.addressService;



import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class addressController {
	
	@Autowired
	addressService addSrv;
	
	@RequestMapping("/addresses")
	public List<address> getAddress() {
		return addSrv.getAddress();
	}
	@PostMapping("/addresses")
	public address createAddress(@RequestBody address payload) {
		//TODO: process POST request
		
		return addSrv.createAddress(payload);
	}
	
}
