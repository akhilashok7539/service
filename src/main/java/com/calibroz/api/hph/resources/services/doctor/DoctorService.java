package com.calibroz.api.hph.resources.services.doctor;

import java.util.List;

import com.calibroz.api.jpa.entities.doctor.Doctor;

public interface DoctorService {

	List<String> getDoctorBySearch(String searchString);

	List<Doctor> getDoctorByCity(Long cityId);

}
