package com.cerner.resource;

import java.util.ArrayList;
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


import org.apache.log4j.Logger;

import com.cerner.dto.VitalRequestDTO;
import com.cerner.dto.VitalsResponseDTO;

//import com.cerner.dto.PVRequestDTO;

import com.cerner.model.Vitals;
import com.cerner.service.VitalsService;

@Path("/vitals")
//@Api("/patientInfo")
//@SwaggerDefinition(tags={@Tag(name="patientInfo",description="REST EndPoint for patientInfo")})

@Produces({ "application/json" })
public class VitalsResource {
	VitalsService vitalService = new VitalsService();
	 //private static Logger logger = LoggerFactory.getLogger(VitalsResource.class);
	
	final static Logger logger = Logger.getLogger(VitalsResource.class);

	// CRUD -- CREATE operation
	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ "application/json", "application/xml" })
	public Response createVital(VitalRequestDTO vitalReqDTO) {
		logger.info("Create Vital Request DTO : Start " +vitalReqDTO);
		VitalsResponseDTO response = vitalService.createVital(vitalReqDTO);
		logger.info("Create Vital  end " );
		return Response.status(201).entity(response).build();
	}

	// CRUD -- READ operation
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getAllVitals() {
		logger.info("getAllVitals : Start ");

		VitalsResponseDTO response = new VitalsResponseDTO();
		List<Vitals> vList = vitalService.getAllVitals();
		if (vList != null && vList.size() > 0) {
			response.setResults(vList);
			response.setResponseMessages("All Vitals retrieved Successfully");
		} else {
			response.setResponseMessages("No Results Found Vitals");
		}
		
		logger.info("getAllVitals : End ");
		return Response.status(200).entity(response).build();
	}

	// CRUD -- READ operation
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVitalsForId(@PathParam("id") Integer id) {
		
		logger.info("getVitalsForId Integer id :" + id + " Start ");

		VitalsResponseDTO response = new VitalsResponseDTO();
		Vitals v = vitalService.getVitalForId(id);
		List<Vitals> vList = new ArrayList<>();
		vList.add(v);
		if (v != null && vList.size() > 0) {
			response.setResults(vList);
			response.setResponseMessages("All Vitals retrieved Successfully");
		} else {
			response.setResponseMessages("No Results Found Vitals for vital id :" + id);
		}
		
		logger.info("getVitalsForId Integer id :" + id + " End ");
		return Response.status(200).entity(response).build();

	}

	@PUT
	@Path("/update/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateVitals(@PathParam("id") int id, Vitals v) {
		
		logger.info("updateVitals for id :" + id + " Vitals v :" + v + " Start ");
		VitalsResponseDTO response = new VitalsResponseDTO();
		int count = vitalService.updateVital(id, v);
		if (count <= 0) {
			response.setResponseMessages("Update failed . Vitals for vital id : " + id
					+ " doesn't exists or might have been deleted already.");
			;
			
			return Response.status(Response.Status.BAD_REQUEST).entity(response).build();

		}
		
		Vitals vUpdated = vitalService.getVitalForId(id);

		List<Vitals> vList = new ArrayList<>();
		vList.add(vUpdated);

		response.setResponseMessages("Vitals Updated Successfully for vital id : " + id);
		response.setResults(vList);
		logger.info("updateVitals for id :" + id + " Vitals v :" + v + " End ");
		return Response.ok().entity(response).build();
	}

	// CRUD -- DELETE operation
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteVitals(@PathParam("id") Integer id) {
		logger.info("deleteVitals for id :" + id + " Start ");
		int count = vitalService.deleteVital(id);
		VitalsResponseDTO response = new VitalsResponseDTO();
		if (count == 0) {
			response.setResponseMessages(
					"Vitals for vital id : " + id + " doesn't exists or might have been deleted already.");
			;
			return Response.status(Response.Status.BAD_REQUEST).entity(response).build();
		}

		response.setResponseMessages("Vitals deleted Successfully for vital id : " + id);
		logger.info("deleteVitals for id :" + id + " End ");
		return Response.ok().entity(response).build();

	}

	// CRUD -- READ operation
	@GET
	@Path("/patient/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVitalsForPatientId(@PathParam("id") int patientId) {
		logger.info("getVitalsForPatientId  patientid :" + patientId + " Start ");

		VitalsResponseDTO response = new VitalsResponseDTO();
		List<Vitals> vList = vitalService.getVitalsForPatientId(patientId);
		response.setResults(vList);
		response.setResponseMessages("All Vitals retrieved Successfully for patient id :"+patientId);
		logger.info("getVitalsForPatientId  patientid :" + patientId + " End ");
		return Response.status(200).entity(response).build();
	}

}
