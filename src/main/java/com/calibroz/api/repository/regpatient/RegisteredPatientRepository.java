package com.calibroz.api.repository.regpatient;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.calibroz.api.jpa.entities.registeredpatient.RegisteredPatient;

@Repository
public interface RegisteredPatientRepository extends PagingAndSortingRepository<RegisteredPatient, Long>{

	RegisteredPatient findByPatientId(Long regPatientId);

	@Query("SELECT p.mobNo, a.profileId from RegisteredPatient p INNER JOIN Access a ON p.appId = a.appId  WHERE p.mobNo =?1 AND a.profileId =?2")
	public String checkIfExisting(String mobNo, Long profileId);

	RegisteredPatient findByAppId(String appId);

}
