package com.calibroz.api.hph.resources.services.unregpatient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.calibroz.api.jpa.entities.unregisteredpatient.UnregisteredPatient;
import com.calibroz.api.repository.unregpatient.UnregisteredPatientRepository;

@Service
public class UnregisteredPatientServiceImpl implements UnregisteredPatientService {

	
	@Autowired
	private UnregisteredPatientRepository unregisteredPatientRepository;
	
	@Override
	public Page<UnregisteredPatient> getAllUnregPatient(int offset, int limit) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(offset, limit);
		Page<UnregisteredPatient> pageObj = unregisteredPatientRepository.findAll(pageable);
		return pageObj;
	}

	@Override
	public UnregisteredPatient getUnregPatient(Long unregPatientId) {
		// TODO Auto-generated method stub
		UnregisteredPatient unregisteredPatient = unregisteredPatientRepository.findByUnregPatId(unregPatientId);
		return unregisteredPatient;
	}

	@Override
	public UnregisteredPatientResponse addUnregisteredPatient(UnregisteredPatient unregisteredPatient) {
		// TODO Auto-generated method stub
		String status = null;
		UnregisteredPatientResponse response = new UnregisteredPatientResponse();
		UnregisteredPatient ur = unregisteredPatientRepository.save(unregisteredPatient);
		status = "Patient added successfully";
		status = ur != null ? status : "Not added successfully";
		response.setUnregisteredPatient(ur);
		response.setStatus(status);

		return response;
	}

	@Override
	public UnregisteredPatientResponse updateUnregisteredPatient(UnregisteredPatient unregisteredPatient) {
		// TODO Auto-generated method stub
		String status = "Patient added successfully";
		UnregisteredPatientResponse response = new UnregisteredPatientResponse();
		UnregisteredPatient ur = unregisteredPatientRepository.save(unregisteredPatient);
		status = ur != null ? status : "Not added successfully";
		response.setUnregisteredPatient(ur);
		response.setStatus(status);

		return response;
	}

	@Override
	public UnregisteredPatientResponse deleteUnregisteredPatient(Long unregPatientId) {
		// TODO Auto-generated method stub
		
		String status = "Patient deleted successfully";
		UnregisteredPatientResponse response = new UnregisteredPatientResponse();
		unregisteredPatientRepository.deleteById(unregPatientId);
		response.setStatus(status);
		return response;
		
	}

}
