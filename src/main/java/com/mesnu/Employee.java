package com.mesnu;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "EMPLOYEE_DATA")
 
public class Employee {

	@Id
	private int id;
	private String name;


}
