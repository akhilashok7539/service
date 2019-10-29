package com.calibroz.api.hph.resources.endpoints.doctor;

import java.util.List;

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

import com.calibroz.api.hph.resources.services.doctor.DoctorService;
import com.calibroz.api.jpa.entities.doctor.Doctor;

@RestController
@RequestMapping("/doctor")
public class DoctorEndpoint {

	@Autowired
	private DoctorService doctorService;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getDoctorBySearch(@RequestParam("searchString") String searchString, UriComponentsBuilder ucBuilder){
		
		List<String> doctors = doctorService.getDoctorBySearch(searchString);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/doctor").buildAndExpand().toUri());
		
		return new ResponseEntity<List<String>>(doctors, headers, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{cityId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Doctor>> getDoctorByCity(@PathVariable("cityId") Long cityId, UriComponentsBuilder ucBuilder){
		
		List<Doctor> doctors = doctorService.getDoctorByCity(cityId);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/doctor").buildAndExpand().toUri());
		
		return new ResponseEntity<List<Doctor>>(doctors, headers, HttpStatus.OK);
	}
}
