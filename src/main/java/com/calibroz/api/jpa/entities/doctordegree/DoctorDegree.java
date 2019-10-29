package com.calibroz.api.jpa.entities.doctordegree;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.calibroz.api.jpa.entities.college.College;

import lombok.Data;

@Entity
@Data
@Table(name = "HPH_DOCTOR_DEGREE")
public class DoctorDegree {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DOC_DEGREE_ID")
	private Long docDegId;
	
	
	@Column(name = "DOC_ID")
	private Long doctorId;
	
	
	@Column(name = "DEGREE_ID")
	private Long degreeId;
	
	
	@Column(name = "CLG_ID")
	private Long collegeId;
	
	@Column(name = "YEAR_COMPLETION")
	private Date yoc;
	
	@Column(name = "YEAR_EXPERIENCE")
	private Date yoe;
	
}
