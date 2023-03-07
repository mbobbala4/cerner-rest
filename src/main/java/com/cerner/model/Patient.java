package com.cerner.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Patient")
public class Patient {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int age;
	private String dateOfBirth;
	private String address;
	private String gender;
	private int act_ind;
	
	public int getAct_ind() {
		return act_ind;
	}




	public void setAct_ind(int act_ind) {
		this.act_ind = act_ind;
	}
/*	@OneToMany(fetch = FetchType.EAGER )
	@JoinColumn(name="patientId")
	private Set<Vitals> vitals;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="patient_Id")
	private Set<Encounter> encounter;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="pId")
	private Set<Facility> facility; */
	
	
/*	public Patient(int id, String name, int age, String dateOfBirth, int address, String gender, Set<Vitals> vitals,
			Set<Encounter> encounter, Set<Facility> facility) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.gender = gender;
		this.vitals = vitals;
		this.encounter = encounter;
		this.facility = facility;
	}

*/


/*	public Set<Encounter> getEncounter() {
		return encounter;
	}




	public void setEncounter(Set<Encounter> encounter) {
		this.encounter = encounter;
	}




	public Set<Facility> getFacility() {
		return facility;
	}




	public void setFacility(Set<Facility> facility) {
		this.facility = facility;
	}
	public Set<Vitals> getVitals() {
		return vitals;
	}
	public void setVitals(Set<Vitals> vitals) {
		this.vitals = vitals;
	}
	*/



	public Patient() {
		super();
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}


}
