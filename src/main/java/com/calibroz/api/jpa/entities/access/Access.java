package com.calibroz.api.jpa.entities.access;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.calibroz.api.jpa.entities.registeredpatient.RegisteredPatient;

import lombok.Data;

@Data
@Entity
@Table(name = "HPH_ACCESS", uniqueConstraints = { @UniqueConstraint(columnNames = { "APP_ID" }, name = "appId_UNIQUE") })
public class Access {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "APP_ID")	//pk - uuid
	private String appId;
	
//	@OneToOne(fetch = FetchType.LAZY,
//			cascade = CascadeType.ALL,
//			mappedBy = "access")
//	private RegisteredPatient registeredPatient;
	
	@Column(name = "PROFILE_TYPE_ID")
	private Long profileId;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "STATUS")
	private boolean status;
	
	@Column(name = "CREATED_DATE", insertable = true, updatable = false)
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	@Column(name = "UPDATED_DATE")
	@UpdateTimestamp
	private LocalDateTime updatedDate;
	

}
