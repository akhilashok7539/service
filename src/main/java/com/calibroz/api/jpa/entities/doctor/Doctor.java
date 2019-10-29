package com.calibroz.api.jpa.entities.doctor;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table (name = "HPH_DOCTOR")
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DOCTOR_ID")
	private Long doctorId;
	
	@Column(name = "NAME")
	private String doctorName;
	
	@Column(name = "MOB")
	private String mob;
	
	@Column(name = "CITY_ID")
	private Long cityId;
	
	@Column(name = "GENDER")
	private String gender;
	
//	private String completionStatus;	//boolean?? percentage??
//	private Long appId;	//fk
	
	@Column(name = "CREATED_DATE")
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	@Column(name = "UPDATED_DATE")
	@UpdateTimestamp
	private LocalDateTime updatedDate;



}
