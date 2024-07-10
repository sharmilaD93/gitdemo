package com.sharmi5.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sharmi5.entities.address;

public interface IAddressPersistence extends JpaRepository<address, Long>{

}
