package com.mesnu;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
public class PayStub {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private Date payPeriodStart;
	private Date payPeriodEnd;
	private float salary;
	
	@ManyToOne
	private Employee employee;
	

	public PayStub(Date payPeriodStart, Date payPeriodEnd, float salary, Employee employee) {
		super();
		this.payPeriodStart = payPeriodStart;
		this.payPeriodEnd = payPeriodEnd;
		this.salary = salary;
		this.employee = employee;
	}
	
	

}
