package com.calibroz.api.hph.resources.services.unregpatient;

import org.springframework.data.domain.Page;

import com.calibroz.api.jpa.entities.unregisteredpatient.UnregisteredPatient;

public interface UnregisteredPatientService {

	Page<UnregisteredPatient> getAllUnregPatient(int offset, int limit);

	UnregisteredPatient getUnregPatient(Long unregPatientId);

	UnregisteredPatientResponse addUnregisteredPatient(UnregisteredPatient unregisteredPatient);

	UnregisteredPatientResponse updateUnregisteredPatient(UnregisteredPatient unregisteredPatient);

	UnregisteredPatientResponse deleteUnregisteredPatient(Long unregPatientId);

}
