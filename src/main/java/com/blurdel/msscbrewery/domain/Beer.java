package com.blurdel.msscbrewery.domain;

import java.sql.Timestamp;
import java.util.UUID;

import com.blurdel.msscbrewery.web.model.v2.BeerStyleEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// Emulating a JPA Entity Object

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Beer {
	
	private UUID id;
	private String beerName;
	private BeerStyleEnum beerStyle;
	private Long upc;
	
	private Timestamp createdDate;
	private Timestamp lastUpdatedDate;
}
