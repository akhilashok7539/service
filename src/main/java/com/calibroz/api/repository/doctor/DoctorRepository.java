package com.calibroz.api.repository.doctor;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.calibroz.api.jpa.entities.doctor.Doctor;

public interface DoctorRepository extends PagingAndSortingRepository<Doctor, Long> {

	@Query("SELECT d.doctorName FROM Doctor d WHERE d.doctorName LIKE ?1%")
	List<String> findDoctorBySearch(String searchString);

	List<Doctor> findAllByCityId(Long cityId);

}
