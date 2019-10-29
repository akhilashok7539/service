package com.calibroz.api.hph.resources.endpoints.access;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.calibroz.api.hph.resources.services.access.AccessService;

@RestController
@RequestMapping("/access")
public class AccessEndpoint {

	@Autowired
	private AccessService accessService;
	
	
	
}
