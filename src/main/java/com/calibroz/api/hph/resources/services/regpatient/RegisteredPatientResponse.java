package com.calibroz.api.hph.resources.services.regpatient;

import com.calibroz.api.jpa.entities.registeredpatient.RegisteredPatient;

import lombok.Data;

@Data
public class RegisteredPatientResponse {

	private String status;
	private RegisteredPatient registeredPatient;
}
