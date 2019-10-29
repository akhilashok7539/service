package com.calibroz.api.hph.resources.services.access;

import com.calibroz.api.hph.resources.services.regpatient.RegisteredPatientResponse;
import com.calibroz.api.jpa.DTO.regpatient.PatientDTO;
import com.calibroz.api.jpa.entities.access.Access;

public interface AccessService {

//	AccessResponse addnewAccess(Access access);
	
	AccessResponse addNewAccess(String password, Long profileId);



}
