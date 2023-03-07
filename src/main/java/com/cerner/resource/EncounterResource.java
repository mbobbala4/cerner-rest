package com.cerner.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cerner.dto.EncounterRequestDTO;
import com.cerner.dto.VitalsResponseDTO;

//import com.cerner.dto.PVRequestDTO;

import com.cerner.model.Encounter;
import com.cerner.service.EncounterService;

@Path("/encounter")
//@Api("/patientInfo")
//@SwaggerDefinition(tags={@Tag(name="patientInfo",description="REST EndPoint for patientInfo")})
public class EncounterResource {
	EncounterService encounterService = new EncounterService();

	// CRUD -- CREATE operation
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public VitalsResponseDTO createEncounter(EncounterRequestDTO eReqDTO) {

		VitalsResponseDTO response = encounterService.createEncounter(eReqDTO);

		return response;
	}

	// CRUD -- READ operation
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Encounter> getAllpatients() {
		List<Encounter> patientList = encounterService.getAllEncounter();
		return patientList;
	}

	// CRUD -- READ operation
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Encounter getEncounterForId(@PathParam("id") Integer id) {
		Encounter patient = encounterService.getEncounterForId(id);
		return patient;
	}

	// CRUD -- UPDATE operation
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Encounter updatepatient(Encounter patient) {
		Encounter patientResponse = encounterService.updateEncounter(patient);
		return patientResponse;
	}

	// CRUD -- DELETE operation
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Encounter deleteepatient(@PathParam("id") Integer id) {
		Encounter patientResponse = encounterService.deleteEncounter(id);
		return patientResponse;
	}

	

}
