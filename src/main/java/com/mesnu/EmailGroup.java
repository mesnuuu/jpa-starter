package com.mesnu;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class EmailGroup {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	
	@ManyToMany(mappedBy = "emailGroups")
	private List<Employee> members = new ArrayList<Employee>();
	
	public EmailGroup(String name) {
		
		this.name = name;
	}
	
	public void addMember(Employee employee) {
		this.members.add(employee);
	}

	@Override
	public String toString() {
		return "EmailGroup [id=" + id + ", name=" + name + ", members=" + members + "]";
	}
	
	

	
}
