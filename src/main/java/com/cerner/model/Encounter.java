package com.cerner.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="encounter")
public class Encounter {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int patient_id;
	
	
	private int facility_id;

	private int act_ind;
	
	public int getAct_ind() {
		return act_ind;
	}




	public void setAct_ind(int act_ind) {
		this.act_ind = act_ind;
	}

	
	public Encounter() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int encounter_Id) {
		id = encounter_Id;
	}


	public int getPatient_Id() {
		return patient_id;
	}


	public void setPatient_Id(int patient_Id) {
		this.patient_id = patient_Id;
	}


	public int getFacility_Id() {
		return facility_id;
	}


	public void setFacility_Id(int facility_Id) {
		this.facility_id = facility_Id;
	}
	
	
	
	




	

	

	
	
	

}
