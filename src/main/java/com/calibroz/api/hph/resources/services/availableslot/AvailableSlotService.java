package com.calibroz.api.hph.resources.services.availableslot;

import java.util.List;

import com.calibroz.api.jpa.entities.availableslot.AvailableSlot;

public interface AvailableSlotService {

	List<AvailableSlot> getAvailableSlots();

}
