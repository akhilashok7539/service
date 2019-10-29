package com.calibroz.api.hph.resources.services.speciality;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calibroz.api.jpa.entities.speciality.Speciality;
import com.calibroz.api.repository.speciality.SpecialityRepository;

@Service
public class SpecialityServiceImpl implements SpecialityService {

	@Autowired
	private SpecialityRepository specialityRepository;

	@Override
	public List<Speciality> getSpecBySearch(String searchString) {
		// TODO Auto-generated method stub
		
		List<Speciality> specialities = specialityRepository.findSpecBySearch(searchString);
		return specialities;
	}
	
}
