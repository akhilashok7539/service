package com.calibroz.api.jpa.DTO.regpatient;

import java.sql.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class PatientDTO {


	private Long profileId;
	private String appId;
	private String firstName;
	private String lastName;
	private String mobNo;
	private String password;	
	private String gender;
	private String email;
	private Date dob;
}
