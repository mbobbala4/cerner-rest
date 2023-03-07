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
import javax.ws.rs.core.Response;

import com.cerner.dto.PatientRequestDTO;
import com.cerner.dto.PatientResponseDTO;
import com.cerner.model.Patient;
import com.cerner.service.PatientService;

@Path("/patients")
public class PatientResource {
	PatientService pService = new PatientService();

	// CRUD -- CREATE operation
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public PatientResponseDTO createPatient(PatientRequestDTO vitalReqDTO) {
		PatientResponseDTO response = pService.createPatient(vitalReqDTO);
		return response;
	}

	// CRUD -- READ operation
	/**
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getAllpatients() {
		PatientResponseDTO response = new PatientResponseDTO();
		List<Patient> patientList = pService.getAllPatients();
		
		System.out.println("patientList----"+patientList.size());
		response.setResults(patientList);
		response.setResponseMessages("All Patient retrieved succesfully");
		
		Response r = Response.status(200).entity(response).build();
        return r;
	}

	// CRUD -- READ operation
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Patient getpatientForId(@PathParam("id") Integer id) {
		Patient patient = pService.getPatientForId(id);
		return patient;
	}

	// CRUD -- UPDATE operation
	@PUT
	@Path("/update/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Patient updatePatient(Patient patient) {
		Patient patientResponse = pService.updatePatient(patient);
		return patientResponse;
	}

	// CRUD -- DELETE operation

	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Patient deletePatient(@PathParam("id") Integer id) {
		Patient patientResponse = pService.deletePatient(id);
		return patientResponse;
	}

}
