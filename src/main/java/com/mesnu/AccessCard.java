package com.mesnu;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class AccessCard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private Date issueDate;
	
	private boolean isActive;
	
	private String firmwareVersion;
	
	@OneToOne(mappedBy = "card")
	private Employee owner;

	public AccessCard(Date issueDate, boolean isActive, String firmwareVersion) {
		
		this.issueDate = issueDate;
		this.isActive = isActive;
		this.firmwareVersion = firmwareVersion;
	}

	@Override
	public String toString() {
		return "AccessCard [issueDate=" + issueDate + ", isActive=" + isActive + ", owner=" + owner + "]";
	}


	
	

}
