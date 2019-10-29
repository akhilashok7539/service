package com.calibroz.api.jpa.entities.leave;

import java.sql.Date;
import java.sql.Time;
import java.time.DayOfWeek;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.calibroz.api.jpa.entities.timeslot.TimeSlot;

import lombok.Data;

@Data
@Entity
@Table(name = "HPH_DOC_LEAVE")
public class Leave {

	@Id
	@Column(name = "LEAVE_ID")
	private Long leaveId;
	
	@Column(name = "DOC_ID")
	private Long doctordId;
	
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
