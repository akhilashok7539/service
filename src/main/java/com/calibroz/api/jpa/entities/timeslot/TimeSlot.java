package com.calibroz.api.jpa.entities.timeslot;

import java.sql.Time;
import java.time.DayOfWeek;
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
@Table(name = "HPH_DOC_TIMINGS")
public class TimeSlot {
	
	@Id
	@Column(name = "TIMESLOT_ID")
	private Long slotId;

	@Column(name = "DOC_ID")	
	private Long doctordId;
	
	@Column(name = "DAY")
	private DayOfWeek day;
	
	@Column(name = "TIME")
	private Time time;
	
	@Column(name = "CREATED_DATE")
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	@Column(name = "UPDATED_DATE")
	@UpdateTimestamp
	private LocalDateTime updatedDate;

	
}
