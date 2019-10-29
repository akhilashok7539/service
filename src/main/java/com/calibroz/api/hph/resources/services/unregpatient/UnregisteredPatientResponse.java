package com.calibroz.api.hph.resources.services.unregpatient;


import com.calibroz.api.jpa.entities.unregisteredpatient.UnregisteredPatient;

import lombok.Data;
@Data
public class UnregisteredPatientResponse {


		private String status;
		private UnregisteredPatient unregisteredPatient;


}
