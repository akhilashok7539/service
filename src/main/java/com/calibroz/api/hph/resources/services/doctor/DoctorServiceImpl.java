package com.calibroz.api.hph.resources.services.doctor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calibroz.api.jpa.entities.doctor.Doctor;
import com.calibroz.api.repository.doctor.DoctorRepository;


@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;

	@Override
	public List<String> getDoctorBySearch(String searchString) {
		// TODO Auto-generated method stub
		List<String> doctors = doctorRepository.findDoctorBySearch(searchString);
		return doctors;
	}

	@Override
	public List<Doctor> getDoctorByCity(Long cityId) {
		// TODO Auto-generated method stub
		List<Doctor> doctors = doctorRepository.findAllByCityId(cityId);
		return doctors;
	}
}
