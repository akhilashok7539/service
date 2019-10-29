package com.calibroz.api.repository.patientbooking;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.calibroz.api.jpa.entities.patientbooking.PatientBooking;

@Repository
public interface PatientBookingRepository extends PagingAndSortingRepository<PatientBooking, Long> {

}
