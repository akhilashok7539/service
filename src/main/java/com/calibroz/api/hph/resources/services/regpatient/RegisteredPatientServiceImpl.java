package com.calibroz.api.hph.resources.services.regpatient;

import java.util.Calendar;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.calibroz.api.jpa.DTO.regpatient.PatientDTO;
import com.calibroz.api.jpa.entities.registeredpatient.RegisteredPatient;
import com.calibroz.api.repository.regpatient.RegisteredPatientRepository;

@Service
public class RegisteredPatientServiceImpl implements RegisteredPatientService {
	
	@Autowired
	private RegisteredPatientRepository registeredPatientRepository;
	
	Logger logger = LoggerFactory.getLogger(RegisteredPatientServiceImpl.class);

	@Override
	public Page<RegisteredPatient> getAllRegPatient(int offset, int limit) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(offset, limit);
		logger.info("offset = "+offset+" and limit = "+limit);
		Page<RegisteredPatient> pageObj = registeredPatientRepository.findAll(pageable);
		
		if(pageObj ==null)
			logger.warn("No details found");
		
		return pageObj;
	}

	@Override
	public RegisteredPatient getRegPatient(Long regPatientId) {
		// TODO Auto-generated method stub
		
		RegisteredPatient registeredPatient = registeredPatientRepository.findByPatientId(regPatientId);
		
		if(registeredPatient == null)
			logger.warn("No details found");
		
		return registeredPatient;
	}

	@Override
	public RegisteredPatientResponse addRegisteredPatient(PatientDTO patient,String appId) {
		// TODO Auto-generated method stub
		
		RegisteredPatient registeredPatient = new RegisteredPatient();
		try {
			//creating new registered patient instance and populating with new received(patient) data.

		registeredPatient.setAppId(appId);
		registeredPatient.setFirstName(patient.getFirstName());
		registeredPatient.setLastName(patient.getLastName());
		registeredPatient.setMobNo(patient.getMobNo());
//		registeredPatient.setEmail(patient.getEmail());
//		registeredPatient.setDob(Calendar.getInstance().getTime());
//		registeredPatient.setGender(patient.getGender());
		}catch(Exception e) {
			logger.error("Error in creating new patient: "+e);
		}
		String status = null;
		RegisteredPatientResponse response = new RegisteredPatientResponse();
		RegisteredPatient r = registeredPatientRepository.save(registeredPatient);
		
		status = r != null ? "Patient added successfully" : "Not added successfully";
		response.setRegisteredPatient(r);
		response.setStatus(status);
		return response;

	}

	@Override
	public RegisteredPatientResponse updateRegisteredPatient(PatientDTO patient, Long patientId) {
		// TODO Auto-generated method stub
		
		//fetch registred patient against id
		logger.info("Fetching registered patient details against id: "+patientId);
		RegisteredPatient registeredPatient = registeredPatientRepository.findByPatientId(patientId);
		try {
		registeredPatient.setDob(patient.getDob());
		registeredPatient.setEmail(patient.getEmail());
		registeredPatient.setGender(patient.getGender());
		registeredPatient.setFirstName(patient.getFirstName());
		registeredPatient.setLastName(patient.getLastName());
		}catch(Exception e) {
			logger.warn("Warning in updating patient: "+e);
		}
		
		RegisteredPatientResponse response = new RegisteredPatientResponse();
		RegisteredPatient r = registeredPatientRepository.save(registeredPatient);
		String status = r != null ? "Patient updated successfully" : "Not updated successfully";
		response.setRegisteredPatient(r);
		response.setStatus(status);
	
		return response;
	}

	@Override
	public RegisteredPatientResponse updateMob(PatientDTO patient, Long patientId) {
		
		logger.info("Fetching registered patient details against appId: "+patientId);
		RegisteredPatient registeredPatient = registeredPatientRepository.findByPatientId(patientId);
		try {
		registeredPatient.setMobNo(patient.getMobNo());
		}catch(Exception e) {
			logger.warn("Warning in updating patient: "+e);
		}
		
		RegisteredPatientResponse response = new RegisteredPatientResponse();
		RegisteredPatient r = registeredPatientRepository.save(registeredPatient);
		String status = r != null ? "Mobile number updated successfully" : "Not updated successfully";
		response.setRegisteredPatient(r);
		response.setStatus(status);
	
		return response;
	}

//	@Override
//	public RegisteredPatientResponse deleteRegisteredPatient(Long regPatientId) {
//		// TODO Auto-generated method stub
//		
//		String status = "Patient deleted successfully";
//		RegisteredPatientResponse response = new RegisteredPatientResponse();
//		registeredPatientRepository.deleteById(regPatientId);
//		response.setStatus(status);
//		return response;
//	}

}
