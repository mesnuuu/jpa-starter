package com.mesnu;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	
	@OneToOne
	private AccessCard card;

	@OneToMany(mappedBy = "employee" , cascade = CascadeType.REMOVE)
	private List<PayStub> payStub = new ArrayList<>();
	
	@ManyToMany(fetch = FetchType.EAGER)
	
	@JoinTable(name = "Email_Group_Subcriptions",
	
			joinColumns = @JoinColumn(name= "EMPLOYEE_ID"),
			
				inverseJoinColumns =  @JoinColumn(name= "SUBSCRIPTION_EMAIL_ID")
	)
	private List<EmailGroup> emailGroups = new ArrayList<EmailGroup>();

	public Employee(int id, String name, String nic, Date dob, EmployeeType type, AccessCard card) {
		
		this.id = id;
		this.name = name;
		this.nic = nic;
		this.dob = dob;
		this.type = type;
		this.card = card;
	}
  
	public void addPayStub(PayStub payStub) {
		this.payStub.add(payStub);
	}
	
	public void addEmailSubscription(EmailGroup emailGroup) {
		this.emailGroups.add(emailGroup);
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", nic=" + nic + ", dob=" + dob + ", type=" + type + "]";
	}		
	
	
	
}




//@Column( insertable = false)