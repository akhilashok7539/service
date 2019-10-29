package com.calibroz.api.hph.resources.services.regpatient;

import org.springframework.data.domain.Page;

import com.calibroz.api.jpa.DTO.regpatient.PatientDTO;
import com.calibroz.api.jpa.entities.registeredpatient.RegisteredPatient;

public interface RegisteredPatientService {

	public Page<RegisteredPatient> getAllRegPatient(int offset, int limit);

	public RegisteredPatient getRegPatient(Long regPatientId);

	public RegisteredPatientResponse addRegisteredPatient(PatientDTO patient,String appId);

	public RegisteredPatientResponse updateRegisteredPatient(PatientDTO patient, Long patientId);

	public RegisteredPatientResponse updateMob(PatientDTO patient, Long patientId);

//	public RegisteredPatientResponse deleteRegisteredPatient(Long regPatientId);
	
	

}
