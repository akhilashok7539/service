package com.calibroz.api.hph.resources.services.timeslot;

import java.util.List;

import com.calibroz.api.jpa.entities.timeslot.TimeSlot;

public interface TimeSlotService {

	TimeSlotResponse addTimeSlot(TimeSlot timeSlot);

	List<TimeSlot> getAllTimeSlot();

}
