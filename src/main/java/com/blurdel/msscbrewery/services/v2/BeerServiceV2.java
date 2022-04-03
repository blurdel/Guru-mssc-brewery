package com.blurdel.msscbrewery.services.v2;

import java.util.UUID;

import com.blurdel.msscbrewery.web.model.v2.BeerDtoV2;


public interface BeerServiceV2 {

	BeerDtoV2 getById(UUID beerId);

	BeerDtoV2 save(BeerDtoV2 beerDto);

	void update(UUID beerId, BeerDtoV2 beerDto);

	void delete(UUID beerId);
	
}
