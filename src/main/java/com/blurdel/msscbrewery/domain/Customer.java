package com.blurdel.msscbrewery.domain;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//Emulating a JPA Entity Object

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

	private UUID id;
	private String name;
}
