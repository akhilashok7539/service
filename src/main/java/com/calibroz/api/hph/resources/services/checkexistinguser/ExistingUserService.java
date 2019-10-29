package com.calibroz.api.hph.resources.services.checkexistinguser;

public interface ExistingUserService {

	boolean checkRegisteredPatient(Long profileId, String mobNo);

	
}
