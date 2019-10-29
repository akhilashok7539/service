package com.calibroz.api.jpa.entities.speciality;

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
@Table(name = "HPH_SPEC")
public class Speciality {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SPEC_ID")
	private Long specId;
	
	@Column(name = "SPEC_DESC")
	private String description;
	
	@Column(name = "CREATED_DATE")
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	@Column(name = "UPDATED_DATE")
	@UpdateTimestamp
	private LocalDateTime updatedDate;

	
}
