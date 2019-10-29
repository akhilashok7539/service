package com.calibroz.api.hph.resources.services.access;

import com.calibroz.api.jpa.entities.access.Access;

import lombok.Data;

@Data
public class AccessResponse {

	private String status;
	private Access access;
	
}
