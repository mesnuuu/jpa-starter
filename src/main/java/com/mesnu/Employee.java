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
import javax.persistence.Transient;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
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
	
	@Transient
	private String debugString;


	public Employee(int id, String name, String nic, Date dob, EmployeeType type) {
		super();
		this.id = id;
		this.name = name;
		this.nic = nic;
		this.dob = dob;
		this.type = type;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", nic=" + nic + ", dob=" + dob + ", type=" + type + "]";
	}	
	
	
	
}




//@Column( insertable = false)