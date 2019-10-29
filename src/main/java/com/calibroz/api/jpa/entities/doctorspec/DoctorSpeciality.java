package com.calibroz.api.jpa.entities.doctorspec;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.calibroz.api.jpa.compositekeys.DoctorSpecialityId;

import lombok.Data;

@Data
@Entity
@IdClass(DoctorSpecialityId.class)
public class DoctorSpeciality {

	@Id
	@Column(name = "DOCTOR_ID")
	private Long doctorId;
	
	@Id
	@Column(name = "SPEC_ID")
    private Long specId;
	
	@Column(name = "CREATED_DATE", updatable = false)
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	@Column(name = "UPDATED_DATE")
	@UpdateTimestamp
	private LocalDateTime updatedDate; 
}
