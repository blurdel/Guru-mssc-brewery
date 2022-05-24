package com.blurdel.msscbrewery.web.mappers;

import org.mapstruct.Mapper;

import com.blurdel.msscbrewery.domain.Beer;
import com.blurdel.msscbrewery.web.model.BeerDto;

// Lombok and MapStruct in action ...

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

	BeerDto beerToBeerDto(Beer beer);
	
	Beer beerDtoToBeer(BeerDto dto);
}
