package com.blurdel.msscbrewery.web.controller;

import java.util.UUID;

import javax.validation.Valid;

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

import com.blurdel.msscbrewery.services.BeerService;
import com.blurdel.msscbrewery.web.model.BeerDto;


@Deprecated
@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId){

        return new ResponseEntity<>(beerService.getById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(@Valid @RequestBody BeerDto beerDto) {
    	BeerDto savedDto = beerService.save(beerDto);
    	
    	HttpHeaders headers = new HttpHeaders();
    	headers.add("Location", "/api/v1/beer/" + savedDto.getId().toString());
    	
    	return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
    
    @PutMapping("/{beerId}")
    public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId, @Valid @RequestBody BeerDto beerDto) {
    	beerService.update(beerId, beerDto);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Can do this here
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // or this here
    public void handleDelete(@PathVariable("beerId") UUID beerId) {
    	beerService.delete(beerId);
    }
    
}
