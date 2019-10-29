package com.calibroz.api.jpa.entities.availableslot;

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
@Table(name = "HPH_DOC_DATE_TIMINGS")
public class AvailableSlot {
	
	@Id
	@Column(name = "AVL_SLOT_ID")
	private Long availableSlotId;
	
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
