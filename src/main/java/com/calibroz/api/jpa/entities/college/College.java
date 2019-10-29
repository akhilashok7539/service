package com.calibroz.api.jpa.entities.college;

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

@Entity
@Data
@Table(name = "HPH_COLLEGE")
public class College {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CLG_ID")
	private Long collegeId;
	
	@Column(name = "CLG_NAME")
	private String collegeName;
	
	@Column(name = "UPDATED_BY_USER")		// need of this column?
	private Long userId;
	
	@Column(name = "CREATED_DATE", updatable = false)
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	@Column(name = "UPDATED_DATE")
	@UpdateTimestamp
	private LocalDateTime updatedDate;

}
