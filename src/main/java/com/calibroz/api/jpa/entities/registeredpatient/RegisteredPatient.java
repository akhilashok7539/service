package com.calibroz.api.jpa.entities.registeredpatient;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.calibroz.api.jpa.entities.access.Access;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import net.bytebuddy.implementation.bind.annotation.Default;

@Entity
@Data
@Table(name = "HPH_REG_PATIENT", uniqueConstraints = { @UniqueConstraint(columnNames = { "APP_ID" }, name = "appId_UNIQUE") } )
public class RegisteredPatient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PATIENT_ID")
	private Long patientId;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "MOB_NO")
	@NotNull
	private String mobNo;
	
//	@OneToOne(fetch = FetchType.LAZY, optional = false)
//	@JoinColumn(name = "APP_ID", nullable = false)
//	private Access access;
	
	@Column(name = "APP_ID", insertable = true, updatable = false)
	private String appId;
	
	@Column(name = "EMAIL_ID")
	private String email;	
	
	@Column(name = "DATE_OF_BIRTH")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dob;
	
	@Column(name = "GENDER")
	private String gender;	
	
	@Column(name = "CREATED_DATE", updatable = false)
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	@Column(name = "UPDATED_DATE")
	@UpdateTimestamp
	private LocalDateTime updatedDate;
	
	
}
