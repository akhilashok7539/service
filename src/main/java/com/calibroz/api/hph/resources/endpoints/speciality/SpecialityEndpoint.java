package com.calibroz.api.hph.resources.endpoints.speciality;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.calibroz.api.hph.resources.services.speciality.SpecialityService;
import com.calibroz.api.jpa.entities.speciality.Speciality;

@RestController
@RequestMapping("/spec")
public class SpecialityEndpoint {

	@Autowired
	private SpecialityService specialityService;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getSpecBySearch(@RequestParam("searchString") String searchString, UriComponentsBuilder ucBuilder){
		
		List<Speciality> specialities = specialityService.getSpecBySearch(searchString);
		
		List<String> specNames = new ArrayList<String>();
		
		for(Speciality speciality:specialities) {
			specNames.add(speciality.getDescription());
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/spec").buildAndExpand().toUri());
		
		return new ResponseEntity<List<Speciality>>(specialities, headers, HttpStatus.OK);
	}
}
