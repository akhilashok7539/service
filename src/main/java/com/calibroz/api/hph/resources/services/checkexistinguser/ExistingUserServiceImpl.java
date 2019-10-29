package com.calibroz.api.hph.resources.services.checkexistinguser;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calibroz.api.jpa.entities.registeredpatient.RegisteredPatient;
import com.calibroz.api.repository.profiletype.ProfileTypeRepository;
import com.calibroz.api.repository.regpatient.RegisteredPatientRepository;

@Service
public class ExistingUserServiceImpl implements ExistingUserService {

	@Autowired
	private RegisteredPatientRepository regPatientRepository;
	
    Logger logger = LoggerFactory.getLogger(ExistingUserServiceImpl.class);

	
	@Override
	public boolean checkRegisteredPatient(Long profileId, String mobNo) {
		// TODO Auto-generated method stub
		
		String check = regPatientRepository.checkIfExisting(mobNo,profileId);
		
		if(check!=null)
			logger.warn("User already existing with same mobile number");
		else
			logger.info("No user with same mobile number found");

		return check!=null ? true:false;
	}

}
