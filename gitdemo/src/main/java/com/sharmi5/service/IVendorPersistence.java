package com.sharmi5.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sharmi5.entities.Vendor;

public interface IVendorPersistence extends JpaRepository<Vendor, Long>{

	List<Vendor> findByCompanyName(String companyName);
	@Query(nativeQuery=true,
			value="select * from public.vendor where lower(GST_NO) like?1%")
	List<Vendor> lookupVendorByGST(String GSTNo);
	
}
