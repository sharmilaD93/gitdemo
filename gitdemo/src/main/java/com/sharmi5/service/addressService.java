package com.sharmi5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sharmi5.entities.*;

@Component
public class addressService {
	
	@Autowired
	IAddressPersistence address;
	
	@RequestMapping("/addresses")
	public List<address> getAddress() {
		return address.findAll();
	}
	
	@PostMapping("/addresses")
	public address createAddress(address payload) {
		return address.save(payload);
	}

}
