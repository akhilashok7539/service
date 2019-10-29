package com.calibroz.api.repository.availableslot;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.calibroz.api.jpa.entities.availableslot.AvailableSlot;

@Repository
public interface AvailableSlotRepository extends PagingAndSortingRepository<AvailableSlot, Long> {

}
