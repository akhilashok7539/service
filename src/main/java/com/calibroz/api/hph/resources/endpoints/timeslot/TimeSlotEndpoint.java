package com.calibroz.api.hph.resources.endpoints.timeslot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.calibroz.api.hph.resources.services.timeslot.TimeSlotResponse;
import com.calibroz.api.hph.resources.services.timeslot.TimeSlotService;
import com.calibroz.api.jpa.entities.timeslot.TimeSlot;

@RestController
@RequestMapping("/timing")
public class TimeSlotEndpoint {

	
	@Autowired
	private TimeSlotService timeSlotService;
	
	//add new time slot - post
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TimeSlotResponse> addTimeSlot(@RequestBody TimeSlot timeSlot, UriComponentsBuilder ucBuilder){
		
		TimeSlotResponse status = timeSlotService.addTimeSlot(timeSlot);
		
		HttpHeaders headers = new HttpHeaders();		
		headers.setLocation(ucBuilder.path("/timing").buildAndExpand(timeSlot).toUri());		
		return new ResponseEntity<TimeSlotResponse>(status, headers, HttpStatus.OK);
	}
	
		public ResponseEntity<?> getAllTimeSlot(UriComponentsBuilder ucBuilder){
		
		List<TimeSlot> timeSlots = timeSlotService.getAllTimeSlot();
		
		HttpHeaders headers = new HttpHeaders();		
		headers.setLocation(ucBuilder.path("/timing").buildAndExpand().toUri());		
		return new ResponseEntity<List<TimeSlot>>(timeSlots, headers, HttpStatus.OK);
	}
	
}
