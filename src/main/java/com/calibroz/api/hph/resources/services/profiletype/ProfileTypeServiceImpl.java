package com.calibroz.api.hph.resources.services.profiletype;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calibroz.api.jpa.entities.profiletype.ProfileType;
import com.calibroz.api.repository.profiletype.ProfileTypeRepository;

@Service
public class ProfileTypeServiceImpl implements ProfileTypeService {

	@Autowired
	private ProfileTypeRepository profileTypeRepository;

	@Override
	public List<ProfileType> getAllProfile() {
		// TODO Auto-generated method stub
		
		List<ProfileType> profiles = (List<ProfileType>) profileTypeRepository.findAll();
		
		return profiles;
	}
	
	
}
