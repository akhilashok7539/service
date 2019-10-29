package com.calibroz.api.hph.resources.endpoints.unregpatient;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

import com.calibroz.api.hph.resources.services.regpatient.RegisteredPatientResponse;
import com.calibroz.api.hph.resources.services.unregpatient.UnregisteredPatientResponse;
import com.calibroz.api.hph.resources.services.unregpatient.UnregisteredPatientService;
import com.calibroz.api.jpa.entities.registeredpatient.RegisteredPatient;
import com.calibroz.api.jpa.entities.unregisteredpatient.UnregisteredPatient;


@RestController
@RequestMapping("/unregpatients")
public class UnregPatientEndpoint {
	
	@Autowired
	private UnregisteredPatientService unregisteredPatientService;
	
	//getall
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<UnregisteredPatient>> getAllUnregisteredPatients(@RequestParam(defaultValue = "0", name = "Offset") int offset,
			@RequestParam(name = "limit", defaultValue = "10") int limit,
			UriComponentsBuilder ucBuilder){
		Page<UnregisteredPatient> page = null;
		page = unregisteredPatientService.getAllUnregPatient(offset, limit);
		
		System.out.println(UUID.randomUUID());
		System.out.println(UUID.randomUUID().toString());
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/unregpatients").buildAndExpand().toUri());
		return new ResponseEntity<Page<UnregisteredPatient>>(page, headers, HttpStatus.OK);
	}
	
	//get one
	@RequestMapping(value = "/{unregPatientId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UnregisteredPatient> getUnregPatient(@PathVariable("unregPatientId") Long unregPatientId,
			UriComponentsBuilder ucBuilder) {
		UnregisteredPatient unregisteredPatient = unregisteredPatientService.getUnregPatient(unregPatientId);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/unregpatients").buildAndExpand(unregPatientId).toUri());
		return new ResponseEntity<UnregisteredPatient>(unregisteredPatient, headers, HttpStatus.OK);
	}

	//post method
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addUnregisteredPatient(@RequestBody UnregisteredPatient unregisteredPatient, UriComponentsBuilder ucBuilder) {
		
		//check if existing and add only if not existing. Code yet to be added.
		
		
		
		UnregisteredPatientResponse status = unregisteredPatientService.addUnregisteredPatient(unregisteredPatient);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/unregpatients").buildAndExpand(unregisteredPatient).toUri());
		return new ResponseEntity<>(status, headers, HttpStatus.OK);
	}
	
	//put
	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UnregisteredPatientResponse> updatUnregisteredPatient(@RequestBody UnregisteredPatient unregisteredPatient, UriComponentsBuilder ucBuilder) {
		
		UnregisteredPatientResponse status = unregisteredPatientService.updateUnregisteredPatient(unregisteredPatient);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/unregpatients").buildAndExpand(unregisteredPatient).toUri());
		return new ResponseEntity<>(status, headers, HttpStatus.OK);
	}
	
	//delete
	@RequestMapping(value = "/{unregPatientId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteUnregisteredPatient(@PathVariable("unregPatientId") Long unregPatientId) {
		
		UnregisteredPatient currPatient = unregisteredPatientService.getUnregPatient(unregPatientId);
		
		if(currPatient == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		unregisteredPatientService.deleteUnregisteredPatient(unregPatientId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
