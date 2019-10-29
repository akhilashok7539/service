package com.calibroz.api.hph.resources.endpoints.availableslot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.calibroz.api.hph.resources.services.availableslot.AvailableSlotService;
import com.calibroz.api.jpa.entities.availableslot.AvailableSlot;

@RestController
@RequestMapping("/availableslot")
public class AvailableSlotEndpoint {

	@Autowired
	private AvailableSlotService availableSlotService;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAvailableSlots(UriComponentsBuilder ucBuilder){
		
		List<AvailableSlot> slots = availableSlotService.getAvailableSlots();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/availableslot").buildAndExpand().toUri());
		return new ResponseEntity<List<AvailableSlot>>(slots, headers, HttpStatus.OK);
	}
}
