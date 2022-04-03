package com.blurdel.msscbrewery.web.controller;

import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.blurdel.msscbrewery.services.CustomerService;
import com.blurdel.msscbrewery.web.model.CustomerDto;


@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {

	private final CustomerService service;
	
	public CustomerController(CustomerService service) {
		this.service = service;
	}

	@GetMapping("/{customerId}")
	public ResponseEntity<CustomerDto> getCust(@PathVariable("customerId") UUID custId) {
		
		return new ResponseEntity<>(service.getById(custId), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity handlePost(@RequestBody CustomerDto customerDto) {
		CustomerDto savedCust = service.save(customerDto);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "/api/v1/customer" + savedCust.getId().toString());
		
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("/{customerId}")
	public ResponseEntity handleUpdate(@PathVariable("customerId") UUID custId, @RequestBody CustomerDto customerDto) {
		service.update(custId, customerDto);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Can do this here
	}
	
	@DeleteMapping("/{customerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT) // or this here
	public void handleDelete(@PathVariable("customerId") UUID custId) {
		service.delete(custId);
	}
	
}
