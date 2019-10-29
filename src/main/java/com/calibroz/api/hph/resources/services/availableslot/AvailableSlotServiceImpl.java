package com.calibroz.api.hph.resources.services.availableslot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calibroz.api.jpa.entities.availableslot.AvailableSlot;
import com.calibroz.api.repository.availableslot.AvailableSlotRepository;

@Service
public class AvailableSlotServiceImpl implements AvailableSlotService {

	@Autowired
	private AvailableSlotRepository availableSlotRepository;

	@Override
	public List<AvailableSlot> getAvailableSlots() {
		// TODO Auto-generated method stub
		List<AvailableSlot> slots = (List<AvailableSlot>) availableSlotRepository.findAll();
		return slots;
	}
}
