package com.blurdel.msscbrewery.services;

import java.util.UUID;
import org.springframework.stereotype.Service;

import com.blurdel.msscbrewery.web.model.CustomerDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j  // lombok logger
@Service
public class CustomerServiceImpl implements CustomerService {

	@Override
	public CustomerDto getById(UUID uuid) {
		return CustomerDto.builder().id(UUID.randomUUID())
				.name("Joe Buck")
				.build();
	}

	@Override
	public CustomerDto save(CustomerDto customerDto) {
		return CustomerDto.builder()
				.id(UUID.randomUUID())
				.name(customerDto.getName())
				.build();
	}

	@Override
	public void update(UUID custId, CustomerDto customerDto) {
		log.debug("updating a customer ...");
	}

	@Override
	public void delete(UUID custId) {
		log.debug("updating a customer ...");
	}

}
