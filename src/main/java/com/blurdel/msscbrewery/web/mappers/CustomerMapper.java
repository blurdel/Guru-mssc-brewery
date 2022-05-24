package com.blurdel.msscbrewery.web.mappers;

import org.mapstruct.Mapper;

import com.blurdel.msscbrewery.domain.Customer;
import com.blurdel.msscbrewery.web.model.CustomerDto;

//Lombok and MapStruct in action ...

@Mapper
public interface CustomerMapper {

	CustomerDto customerToCustomerDto(Customer customer);
	
	Customer customerDtoToCustomer(CustomerDto dto);
}
