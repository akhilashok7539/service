package com.calibroz.api.jpa.entities.profiletype;

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
@Table (name = "HPH_PROFILE_TYPE")
public class ProfileType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PROFILE_TYPE_ID")
	private Long profileId;
	
	@Column(name = "PROFILE_TYPE_DESC")
	private String description;
	
	@Column(name = "CREATED_DATE")
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	@Column(name = "UPDATED_DATE")
	@UpdateTimestamp
	private LocalDateTime updatedDate;
	
}
