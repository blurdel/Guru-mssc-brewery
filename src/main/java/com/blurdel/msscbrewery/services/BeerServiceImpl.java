package com.blurdel.msscbrewery.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.blurdel.msscbrewery.web.model.BeerDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j // lombok logger
@Service
public class BeerServiceImpl implements BeerService {
	
    @Override
    public BeerDto getById(UUID beerId) {
        return BeerDto.builder().id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle("Pale Ale")
                .build();
    }

	@Override
	public BeerDto save(BeerDto beerDto) {
		return BeerDto.builder()
				.id(UUID.randomUUID())
				.beerName(beerDto.getBeerName())
				.build();
	}

	@Override
	public void update(UUID beerId, BeerDto beerDto) {
		log.debug("updating a beer ..."); // lombok logger
	}

	@Override
	public void delete(UUID beerId) {
		log.debug("deleting a beer ...");
	}
	
}
