package com.mesnu;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

	public AccessCard(Date issueDate, boolean isActive, String firmwareVersion) {
		super();
		this.issueDate = issueDate;
		this.isActive = isActive;
		this.firmwareVersion = firmwareVersion;
	}
	
	

}
