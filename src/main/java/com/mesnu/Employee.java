package com.mesnu;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "EMPLOYEE_DATA")
 
public class Employee {


	@Id
	private int id;
	
	private String name;
	
	@Column(unique = true, length = 4, nullable = false, updatable = false)
	private String nic;

	@Temporal(TemporalType.DATE)
	public Date dob;

	@Enumerated(EnumType.STRING)
	private EmployeeType type;
	
//	@Column( insertable = false)
	
}
