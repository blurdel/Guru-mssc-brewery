package com.blurdel.msscbrewery.web.controller.v2;

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

import com.blurdel.msscbrewery.services.v2.BeerServiceV2;
import com.blurdel.msscbrewery.web.model.v2.BeerDtoV2;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j // lombok easy way to get a logger
@RequiredArgsConstructor
@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerV2 {

    private final BeerServiceV2 beerService;

//    public BeerControllerV2(BeerServiceV2 beerService) {
//        this.beerService = beerService;
//    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDtoV2> getBeer(@PathVariable("beerId") UUID beerId){

        return new ResponseEntity<>(beerService.getById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(@Valid @RequestBody BeerDtoV2 beerDto) {
    	
    	log.debug("In handlePost ...");
    	
    	BeerDtoV2 savedDto = beerService.save(beerDto);
    	
    	HttpHeaders headers = new HttpHeaders();
    	headers.add("Location", "/api/v1/beer/" + savedDto.getId().toString());
    	
    	return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
    
    @PutMapping("/{beerId}")
    public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId, @Valid @RequestBody BeerDtoV2 beerDto) {
    	beerService.update(beerId, beerDto);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Can do this here
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // or this here
    public void handleDelete(@PathVariable("beerId") UUID beerId) {
    	beerService.delete(beerId);
    }
    
    
    // Exception handler moved to MvcExceptionHandler
    
}
