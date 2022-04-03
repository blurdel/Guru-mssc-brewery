package com.blurdel.msscbrewery.services;

import java.util.UUID;

import com.blurdel.msscbrewery.web.model.CustomerDto;


public interface CustomerService {
	
	CustomerDto getById(UUID custId);

	CustomerDto save(CustomerDto customerDto);
	
	void update(UUID custId, CustomerDto customerDto);
	
	void delete(UUID custId);
	
}
