package com.calibroz.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.calibroz.api.jpa.entities.registeredpatient.RegisteredPatient;

@SpringBootApplication
public class SampleHphApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleHphApplication.class, args);
	}

}
