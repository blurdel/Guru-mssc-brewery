package com.blurdel.msscbrewery.services.v2;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.blurdel.msscbrewery.web.model.v2.BeerDtoV2;

import lombok.extern.slf4j.Slf4j;

@Slf4j // lombok logger
@Service
public class BeerServiceImplV2 implements BeerServiceV2 {

	@Override
	public BeerDtoV2 getById(UUID beerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BeerDtoV2 save(BeerDtoV2 beerDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(UUID beerId, BeerDtoV2 beerDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID beerId) {
		// TODO Auto-generated method stub
		
	}

}
