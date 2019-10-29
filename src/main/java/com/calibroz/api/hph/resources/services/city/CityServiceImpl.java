package com.calibroz.api.hph.resources.services.city;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calibroz.api.repository.city.CityRepository;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityRepository cityRepository;
	
	Logger logger = LoggerFactory.getLogger(CityServiceImpl.class);
	
	@Override
	public List<String> getCityBySearch(String searchString) {
		// TODO Auto-generated method stub
		List<String> cities = cityRepository.findCityBySearch(searchString);
		return cities;
	}

}
