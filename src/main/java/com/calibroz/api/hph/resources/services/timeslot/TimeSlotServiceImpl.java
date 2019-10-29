package com.calibroz.api.hph.resources.services.timeslot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calibroz.api.jpa.entities.timeslot.TimeSlot;
import com.calibroz.api.repository.timeslot.TimeSlotRepository;

@Service
public class TimeSlotServiceImpl implements TimeSlotService {

	@Autowired
	private TimeSlotRepository timeSlotRepository;

	@Override
	public TimeSlotResponse addTimeSlot(TimeSlot timeSlot) {

		String status = null;
		TimeSlotResponse response = new TimeSlotResponse();
		
		TimeSlot t = timeSlotRepository.save(timeSlot); 
		status = "Time Slot added";
		status = t!=null ? status:"Time Slot not added";
		
		response.setTimeslot(t);
		response.setStatus(status);
		
		return response;
	}

	@Override
	public List<TimeSlot> getAllTimeSlot() {
		// TODO Auto-generated method stub
		List<TimeSlot> timeSlots = (List<TimeSlot>) timeSlotRepository.findAll();
		return timeSlots;
	}
}
