package com.calibroz.api.repository.speciality;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.calibroz.api.jpa.entities.speciality.Speciality;

@Repository
public interface SpecialityRepository extends PagingAndSortingRepository<Speciality, Long> {
	
	@Query("SELECT s FROM Speciality s WHERE s.description LIKE ?1%")
	List<Speciality> findSpecBySearch(String searchString);

}
