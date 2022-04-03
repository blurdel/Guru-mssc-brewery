package com.blurdel.msscbrewery.services;

import java.util.UUID;

import com.blurdel.msscbrewery.web.model.BeerDto;


public interface BeerService {
	
    BeerDto getById(UUID beerId);

	BeerDto save(BeerDto beerDto);

	void update(UUID beerId, BeerDto beerDto);

	void delete(UUID beerId);
	
}
