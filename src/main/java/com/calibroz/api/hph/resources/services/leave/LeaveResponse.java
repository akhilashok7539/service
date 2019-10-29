package com.calibroz.api.hph.resources.services.leave;

import com.calibroz.api.jpa.entities.leave.Leave;

import lombok.Data;

@Data
public class LeaveResponse {

	private String status;
	private Leave leave;
}
