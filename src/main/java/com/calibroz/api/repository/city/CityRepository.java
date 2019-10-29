package com.calibroz.api.repository.city;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.calibroz.api.jpa.entities.city.City;

@Repository
public interface CityRepository extends PagingAndSortingRepository<City, Long> {

	@Query("SELECT c.cityName FROM City c WHERE c.cityName LIKE ?1%")
	List<String> findCityBySearch(String searchString);

}
