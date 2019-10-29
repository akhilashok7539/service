package com.calibroz.api.hph.resources.services.speciality;

import java.util.List;

import com.calibroz.api.jpa.entities.speciality.Speciality;

public interface SpecialityService {

	List<Speciality> getSpecBySearch(String searchString);

}
