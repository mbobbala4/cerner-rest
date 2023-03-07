package com.cerner.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "Vitals")
public class Vitals {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int id;

	@Column(name = "Vital_Name")
	private String vital_name;

	@Column(name = "Vital_Value")
	private int value;

	@Column(name = "UnitsOfMeasurement")
	private String unitsOfMesurment;

	@Column(name = "Patient_Id")
	private int patient_Id;

	@Column(name = "Encounter_Id")
	private int encounter_id;

	@Column(name = "Updation_Date")
	private LocalDate updation_date;

	@Version
	@Column(name = "Update_Count")
	private int update_count;

	private int act_ind;

	public int getAct_ind() {
		return act_ind;
	}

	public void setAct_ind(int act_ind) {
		this.act_ind = act_ind;
	}

	public Vitals() {

	}

	/*
	 * public Vitals(int vital_id, String vital_name, int value, String
	 * unitsOfMesurment, int encounter_id, LocalDate updation_date, int
	 * update_count) { super(); this.vital_id = vital_id; this.vital_name =
	 * vital_name; this.value = value; this.unitsOfMesurment = unitsOfMesurment;
	 * this.encounter_id = encounter_id; this.updation_date = updation_date;
	 * this.update_count = update_count; }
	 */

	public int getPatient_Id() {
		return patient_Id;
	}

	public void setPatient_Id(int patient_Id) {
		this.patient_Id = patient_Id;
	}

	public int id() {
		return id;
	}

	public void setId(int vital_id) {
		this.id = vital_id;
	}

	public String getVital_name() {
		return vital_name;
	}

	public void setVital_name(String vital_name) {
		this.vital_name = vital_name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getUnitsOfMesurment() {
		return unitsOfMesurment;
	}

	public void setUnitsOfMesurment(String unitsOfMesurment) {
		this.unitsOfMesurment = unitsOfMesurment;
	}

	public int getEncounter_id() {
		return encounter_id;
	}

	public void setEncounter_id(int encounter_id) {
		this.encounter_id = encounter_id;
	}

	public LocalDate getUpdation_date() {
		return updation_date;
	}

	public void setUpdation_date(LocalDate updation_date) {
		this.updation_date = updation_date;
	}

	public int getUpdate_count() {
		return update_count;
	}

	public void setUpdate_count(int update_count) {
		this.update_count = update_count;
	}

}
