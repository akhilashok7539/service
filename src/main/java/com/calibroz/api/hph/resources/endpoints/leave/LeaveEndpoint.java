package com.calibroz.api.hph.resources.endpoints.leave;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.calibroz.api.hph.resources.services.leave.LeaveResponse;
import com.calibroz.api.hph.resources.services.leave.LeaveService;
import com.calibroz.api.jpa.entities.leave.Leave;
import com.calibroz.api.jpa.entities.registeredpatient.RegisteredPatient;

@RestController
@RequestMapping("/leave")
public class LeaveEndpoint {

	@Autowired
	private LeaveService leaveService;
	
	//post - create a leave
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LeaveResponse> addLeave(@RequestBody Leave leave, UriComponentsBuilder ucBuilder){
		
		LeaveResponse status = leaveService.addLeave(leave);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/leave").buildAndExpand(leave).toUri());
		return new ResponseEntity<LeaveResponse>(status, headers, HttpStatus.OK);
		
	}
	
	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<LeaveResponse> updateLeave(@RequestBody Leave leave, UriComponentsBuilder ucBuilder){
		
		LeaveResponse status = leaveService.updateLeave(leave);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/leave").buildAndExpand(leave).toUri());
		return new ResponseEntity<LeaveResponse>(status, headers, HttpStatus.OK);
	}
	
	
	//delete method - confirm about the primary key of the table.
//	@RequestMapping(value = "/{leaveId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<?> deleteLeave(@PathVariable("leaveId") Long leaveId) {
//		
//		Leave leave = leaveService.getRegPatient(leaveId);
//		
//		if(leave == null) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//		
//		leaveService.deleteLeave(leaveId);
//		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//	}
}
