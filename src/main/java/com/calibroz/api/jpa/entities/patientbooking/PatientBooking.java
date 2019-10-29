package com.calibroz.api.jpa.entities.patientbooking;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "HPH_PAT_DOC_XREF")
public class PatientBooking {

	@Id
	@Column(name = "PAT_BOOK_ID")
	private Long bookingId;
	
	@Column(name = "DOC_ID")
	private Long doctordId;
	
	@Column(name = "PAT_ID")
	private Long patientId;
	
//	@Column(name = "Type")			//What is this?
//	private String type;
	
	@Column(name = "APPOINTMENT_STATUS")
	private boolean appointment;
	
	@Column(name = "DATE")
	private Date date;
	
	@Column(name = "TIME")
	private Time time;
	
	@Column(name = "CREATED_DATE")
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	@Column(name = "UPDATED_DATE")
	@UpdateTimestamp
	private LocalDateTime updatedDate;

}
