package com.calibroz.api.hph.resources.endpoints.profiletype;

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

import com.calibroz.api.hph.resources.services.profiletype.ProfileTypeService;
import com.calibroz.api.jpa.entities.profiletype.ProfileType;

@RestController
@RequestMapping("/profile")
public class ProfileTypeEndpoint {

	
	@Autowired
	private ProfileTypeService profileTypeService;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllProfile(UriComponentsBuilder ucBuilder){
		
		List<ProfileType> profiles = profileTypeService.getAllProfile();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/profile").buildAndExpand().toUri());
		
		return new ResponseEntity<List<ProfileType>>(profiles, headers, HttpStatus.OK);
		
	}
	
}
