package com.calibroz.api.repository.timeslot;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.calibroz.api.jpa.entities.timeslot.TimeSlot;

@Repository
public interface TimeSlotRepository extends PagingAndSortingRepository<TimeSlot, Long> {

}
