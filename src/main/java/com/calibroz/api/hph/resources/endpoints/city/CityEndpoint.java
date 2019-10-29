package com.calibroz.api.hph.resources.endpoints.city;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.calibroz.api.hph.resources.services.city.CityService;
import com.calibroz.api.jpa.entities.city.City;

@RestController
@RequestMapping ("/city")
public class CityEndpoint {
	
	@Autowired
	private CityService cityService;
	
	Logger logger = LoggerFactory.getLogger(CityEndpoint.class);

	//getcity - filterby letters
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getCityBySearch(@RequestParam("searchString") String searchString, UriComponentsBuilder ucBuilder){
		
		logger.info("Searching city filtered by search string");
		List<String> cities = cityService.getCityBySearch(searchString);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/city").buildAndExpand().toUri());
		
		return new ResponseEntity<List<String>>(cities, headers, HttpStatus.OK);
		
	}
	
}
