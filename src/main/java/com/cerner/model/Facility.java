package com.cerner.model;



import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Facility")
public class Facility {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String location;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="Facility_Id",unique = true)
	private Encounter encounter;
	
	private int act_ind;
	
	public int getAct_ind() {
		return act_ind;
	}




	public void setAct_ind(int act_ind) {
		this.act_ind = act_ind;
	}


	public Facility(int id, String location, Encounter encounter) {
		super();
		this.id = id;
		this.location = location;
		this.encounter = encounter;
	}

	public Facility(int id, String location) {
		super();
		this.id = id;
		this.location = location;
	}

	public Encounter getEncounter() {
		return encounter;
	}

	public void setEncounter(Encounter encounter) {
		this.encounter = encounter;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	

}
