package com.calibroz.api.hph.resources.endpoints.regpatient;

import java.util.Calendar;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.calibroz.api.hph.resources.services.access.AccessResponse;
import com.calibroz.api.hph.resources.services.access.AccessService;
import com.calibroz.api.hph.resources.services.checkexistinguser.ExistingUserService;
import com.calibroz.api.hph.resources.services.regpatient.RegisteredPatientResponse;
import com.calibroz.api.hph.resources.services.regpatient.RegisteredPatientService;
import com.calibroz.api.jpa.DTO.regpatient.PatientDTO;
import com.calibroz.api.jpa.entities.access.Access;
import com.calibroz.api.jpa.entities.registeredpatient.RegisteredPatient;

@RestController
@RequestMapping("/regpatients")
public class RegPatientEndpoint {

	@Autowired
	private RegisteredPatientService registeredPatientService;

	@Autowired
	private ExistingUserService existingUserService;

	@Autowired
	private AccessService accessService;

	Logger logger = LoggerFactory.getLogger(RegPatientEndpoint.class);

	// getall
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<RegisteredPatient>> getAllRegisteredPatients(
			@RequestParam(defaultValue = "0", name = "Offset") int offset,
			@RequestParam(name = "limit", defaultValue = "10") int limit, UriComponentsBuilder ucBuilder) {

		logger.info("Fetching Registered Patient Details");

		Page<RegisteredPatient> page = null;
		page = registeredPatientService.getAllRegPatient(offset, limit);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/regpatients").buildAndExpand().toUri());
		return new ResponseEntity<Page<RegisteredPatient>>(page, headers, HttpStatus.OK);
	}

	// get-one
	@RequestMapping(value = "/{regPatientId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RegisteredPatient> getRegPatient(@PathVariable("regPatientId") Long regPatientId,
			UriComponentsBuilder ucBuilder) {
		logger.info("Fetching Registered Patient Details against ID");
		RegisteredPatient registeredPatient = registeredPatientService.getRegPatient(regPatientId);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/regpatients").buildAndExpand(regPatientId).toUri());
		return new ResponseEntity<RegisteredPatient>(registeredPatient, headers, HttpStatus.OK);
	}

	// post
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addRegisteredPatient(@RequestBody PatientDTO patient, UriComponentsBuilder ucBuilder) {

		logger.info("Creating Registered Patient");

		logger.info("Checking if user exists");
		boolean isExisting = existingUserService.checkRegisteredPatient(patient.getProfileId(), patient.getMobNo());

		if (!isExisting) {
			logger.info("Creating new access");
			AccessResponse response = accessService.addNewAccess(patient.getPassword(), patient.getProfileId());

			String appId = response.getAccess().getAppId();

			logger.info("Creating new registered patient");
			RegisteredPatientResponse status = registeredPatientService.addRegisteredPatient(patient, appId);

			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/regpatients").buildAndExpand(patient).toUri());
			return new ResponseEntity<RegisteredPatientResponse>(status, headers, HttpStatus.OK);
		} else {
			String status = "User already existing";
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/regpatients").buildAndExpand(patient).toUri());
			return new ResponseEntity<String>(status, headers, HttpStatus.OK);
		}
	}

	
	// put
	@RequestMapping(value = "/{patientId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RegisteredPatientResponse> updateRegisteredPatient(@PathVariable("patientId") Long patientId,
			@RequestBody PatientDTO patient, UriComponentsBuilder ucBuilder) {

		logger.info("Updating patient details against patient ID: " + patientId);
		RegisteredPatientResponse status = registeredPatientService.updateRegisteredPatient(patient, patientId);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/regpatients").buildAndExpand(patient).toUri());
		return new ResponseEntity<>(status, headers, HttpStatus.OK);
	}

	// delete
	//
	// @RequestMapping(value = "/{regPatientId}", method = RequestMethod.DELETE,
	// produces = MediaType.APPLICATION_JSON_VALUE)
	// public ResponseEntity<?>
	// deleteRegisteredPatient(@PathVariable("regPatientId") Long regPatientId) {
	//
	// RegisteredPatient currPatient =
	// registeredPatientService.getRegPatient(regPatientId);
	//
	// if (currPatient == null) {
	// return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	// }
	//
	// registeredPatientService.deleteRegisteredPatient(regPatientId);
	// return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	// }

	// changing mobile number
	@RequestMapping(value = "/changemob/{patientId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> changeMob(@PathVariable("patientId") Long patientId, @RequestBody PatientDTO patient,
			UriComponentsBuilder ucBuilder) {

		// check if existing mob number in same profile type

		logger.info("Checking if user exists");
		boolean isExisting = existingUserService.checkRegisteredPatient(patient.getProfileId(), patient.getMobNo());

		if (!isExisting) {
			
			//should we use update function here as well? 
			logger.info("Updating new Mob");
			RegisteredPatientResponse status = registeredPatientService.updateMob(patient, patientId); 
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/regpatients").buildAndExpand(patient).toUri());
			return new ResponseEntity<RegisteredPatientResponse>(status, headers, HttpStatus.OK);
		} else {
			String status = "User with same number already existing";
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/regpatients").buildAndExpand(patient).toUri());
			return new ResponseEntity<String>(status, headers, HttpStatus.OK);
		}

	}

}
