package com.calibroz.api.jpa.entities.unregisteredpatient;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.calibroz.api.jpa.entities.registeredpatient.RegisteredPatient;

import lombok.Data;

@Entity
@Data
@Table(name = "HPH_UNREG_PATIENT")
public class UnregisteredPatient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="UNREG_PAT_ID") 
	private Long unregPatId;
	
	@Column(name = "PATIENT_ID")
	private Long patientId;
	
//	@OneToOne()
//	@JoinColumn(name="PATIENT_ID",  referencedColumnName="PATIENT_ID", updatable=false)   
//	private RegisteredPatient registeredPatient;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "MOB_NO")
	private String mobNo;
	
	@Column(name = "EMAIL_ID")
	private String email;
	
	@Column(name = "CREATED_DATE", insertable = true, updatable = false)
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	@Column(name = "UPDATED_DATE")
	@UpdateTimestamp
	private LocalDateTime updatedDate;

}
