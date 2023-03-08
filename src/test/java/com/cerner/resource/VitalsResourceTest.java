package com.cerner.resource;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import com.cerner.dto.Pv;
import com.cerner.dto.VitalRequestDTO;
import com.cerner.model.Vitals;

public final class VitalsResourceTest extends JerseyTest {

	// ~ --- [METHODS]
	// --------------------------------------------------------------------------------------------------

	@Test
	public void testGetAllVitals() {

		final Response result1 = target("/vitals").request().get();
		assertEquals(Status.OK.getStatusCode(), result1.getStatus());
		System.out.println("-----result1---" + result1.getEntity().toString());

		System.out.println(result1.readEntity(String.class));
	}

	@Test
	public void testCreateVital() {
		VitalRequestDTO vrDTO = new VitalRequestDTO();
		vrDTO.setEncounterId(1);
		vrDTO.setPatientId(1);

		List<Pv> pvList = new ArrayList<Pv>();
		Pv pvObj = new Pv();
		pvObj.setName("PulseRate");
		pvObj.setUom("BPM");
		pvObj.setValue(80);
		vrDTO.setPv(pvList);
		final Response result = target("/vitals/create").request().post(Entity.json(vrDTO));
		System.out.println("-----result---" + result);
		assertEquals(Status.CREATED.getStatusCode(), result.getStatus());
	}

	// ~
	// ----------------------------------------------------------------------------------------------------------------

	@Test
	public void testGetVitalsForId() {
		final Response result = target("/vitals/1").request().get(Response.class);
		System.out.println("-----result---" + result);
		assertEquals(Status.OK.getStatusCode(), result.getStatus());
	}

	// ~
	// ----------------------------------------------------------------------------------------------------------------

	@Test
	public void testGetVitalsForPatientId() {
		final Response result = target("/vitals/patient/1").request().get(Response.class);
		System.out.println("-----result---" + result);
		assertEquals(Status.OK.getStatusCode(), result.getStatus());
	}

	@Test
	public void testUpdateVitals() {

		VitalRequestDTO vrDTO = new VitalRequestDTO();
		vrDTO.setEncounterId(1);
		vrDTO.setPatientId(1);

		List<Pv> pvList = new ArrayList<Pv>();
		Pv pvObj = new Pv();
		pvObj.setName("PulseRate");
		pvObj.setUom("BPM");
		pvObj.setValue(80);
		vrDTO.setPv(pvList);
		final Response result = target("/vitals/create").request().post(Entity.json(vrDTO));

		System.out.println("-----result---" + result);

		Vitals v = new Vitals();
		v.setEncounter_id(1);
		v.setPatient_Id(1);
		v.setVital_name("PulseRate");
		v.setUnitsOfMesurment("BPM");
		v.setValue(80);
		v.setUpdate_count(1);

		final Response result1 = target("/vitals/update/20").request().put(Entity.json(v));
		System.out.println("-----result1---" + result1);
		assertEquals(Status.OK.getStatusCode(), result1.getStatus());
	}

	@Test
	public void testDeleteVitals() {
		// Mock
		final Response result1 = target("/vitals/delete/1").request().delete();
		System.out.println("-----result1---" + result1);
		assertEquals(Status.OK.getStatusCode(), result1.getStatus());
	}

	// ~
	// ----------------------------------------------------------------------------------------------------------------

	@Override
	protected Application configure() {

		return new ResourceConfig(VitalsResource.class);
	}
}
