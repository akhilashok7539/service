package com.calibroz.api.repository.unregpatient;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.calibroz.api.jpa.entities.unregisteredpatient.UnregisteredPatient;

@Repository
public interface UnregisteredPatientRepository extends PagingAndSortingRepository<UnregisteredPatient, Long> {
	
	UnregisteredPatient findByUnregPatId(Long unregPatientId);

}
