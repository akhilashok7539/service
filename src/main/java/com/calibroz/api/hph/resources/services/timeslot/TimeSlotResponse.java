package com.calibroz.api.hph.resources.services.timeslot;

import com.calibroz.api.jpa.entities.timeslot.TimeSlot;

import lombok.Data;

@Data
public class TimeSlotResponse {

	private String status;
	private TimeSlot timeslot;
}
