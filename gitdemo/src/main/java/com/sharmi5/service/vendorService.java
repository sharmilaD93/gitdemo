package com.sharmi5.service;

//import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sharmi5.entities.Vendor;

@Component
public class vendorService {
	
	
	    @Autowired
	    IVendorPersistence vendor;
		public List<Vendor> readAllVendors() {
			
			return vendor.findAll();
		}
		
//		
//		public Vendor changeVendor(Vendor vendor) {
//			return vendor;
//		}
//		
		public Vendor createVendor(Vendor vendorObj) {
			
			return vendor.save(vendorObj);
			//validation,pre checks,DB calls,post validation
		}
		
		public List<Vendor> searchByCompanyName(String companyName) {
			return vendor.findByCompanyName(companyName);
		}
		
		public List<Vendor> lookupVendorByGST(String GSTNo){
			return vendor.lookupVendorByGST(GSTNo);
		}

		public Optional<Vendor> getSingleVendor(Long id) {
			// TODO Auto-generated method stub
			return vendor.findById(id);
		}

		public Vendor changeVendor(Vendor payload) {
			// TODO Auto-generated method stub
			Optional<Vendor> myvendor = vendor.findById(payload.getId());
			if(!myvendor.isPresent()) {
				return new Vendor((long)0, "","","","","","",null);
			}
			return vendor.save(payload);
		}
		
		public String deleteVendor(Long id) {
			vendor.deleteById(id);
			return "Deleted Successfully";
		}
		

}

