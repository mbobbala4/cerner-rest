package com.cerner.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.cerner.dao.EncounterDAO;
import com.cerner.dao.PatientDAO;
import com.cerner.dao.VitalsDAO;
import com.cerner.dto.Pv;
import com.cerner.dto.VitalRequestDTO;
import com.cerner.dto.VitalsResponseDTO;
import com.cerner.model.Encounter;
import com.cerner.model.Patient;
import com.cerner.model.Vitals;

public class VitalsServiceTest {

	private VitalsService service;
	private VitalsDAO dao; // we will be mocking this class
	PatientDAO pDao;
	EncounterDAO eDao;

	@Before
	public void setup() {
		dao = mock(VitalsDAO.class); // here is the actual mocking call
		pDao = mock(PatientDAO.class);
		eDao = mock(EncounterDAO.class);
		service = new VitalsService();
		service.setVitalDao(dao);
		service.setpDao(pDao);
		service.seteDao(eDao);
	}

	@Test
	public void testGetAllVitals() {
		List<Vitals> all = new ArrayList<Vitals>();
		Vitals v = new Vitals();
		v.setEncounter_id(1);
		v.setPatient_Id(1);
		v.setVital_name("PulseRate");
		v.setUnitsOfMesurment("BPM");
		v.setValue(80);
		v.setUpdate_count(1);

		Vitals v1 = new Vitals();
		v1.setEncounter_id(1);
		v1.setPatient_Id(1);
		v1.setVital_name("PulseRate");
		v1.setUnitsOfMesurment("BPM");
		v1.setValue(80);
		v1.setUpdate_count(1);

		all.add(v);
		all.add(v1);

		// MOCK ALERT: return mocked result set on find
		when(dao.getAllVitals()).thenReturn(all);

		// call the main method you want to test
		List result = service.getAllVitals();

		// MOCK ALERT: verify the method was called
		verify(dao).getAllVitals();
	}

	@Test
	public void testGetVitalForId() {

		Vitals v = new Vitals();
		v.setEncounter_id(1);
		v.setPatient_Id(1);
		v.setVital_name("PulseRate");
		v.setUnitsOfMesurment("BPM");
		v.setValue(80);
		v.setUpdate_count(1);
		v.setId(1);

		// MOCK ALERT: return mocked result set on find
		when(dao.getVitalForId(1)).thenReturn(v);

		// call the main method you want to test
		Vitals result = service.getVitalForId(1);

		// MOCK ALERT: verify the method was called
		verify(dao).getVitalForId(1);

	}

	@Test
	public void createVital() {
		// public VitalsResponseDTO createVital(VitalRequestDTO vitalReqDTO) {
		VitalRequestDTO vrDTO = new VitalRequestDTO();
		vrDTO.setEncounterId(1);
		vrDTO.setPatientId(1);

		List<Pv> pvList = new ArrayList<Pv>();
		Pv pvObj = new Pv();
		pvObj.setName("PulseRate");
		pvObj.setUom("BPM");
		pvObj.setValue(80);
		vrDTO.setPv(pvList);

		Patient p = new Patient();// pDao.getPatientForId(vitalReqDTO.getPatientId());
		p.setId(1);
		p.setName("Manoj");
		p.setAct_ind(1);
		p.setAddress("Kurnool");
		p.setAge(26);
		p.setDateOfBirth("06/06/1996");
		p.setGender("M");
		List<Encounter> eList = new ArrayList<Encounter>(); // eDao.getEncounterForPatientIdAndEId(vitalReqDTO.getPatientId(),
		// vitalReqDTO.getEncounterId());
		Encounter e = new Encounter();
		e.setId(1);
		e.setAct_ind(1);
		e.setFacility_Id(1);
		e.setPatient_Id(1);
		// MOCK ALERT: return mocked result set on find
		when(pDao.getPatientForId(1)).thenReturn(p);

		// MOCK ALERT: return mocked result set on find
		when(eDao.getEncounterForPatientIdAndEId(1, 1)).thenReturn(eList);

		Vitals v = new Vitals();
		v.setEncounter_id(1);
		v.setPatient_Id(1);
		v.setVital_name("PulseRate");
		v.setUnitsOfMesurment("BPM");
		v.setValue(80);
		v.setUpdate_count(1);

		VitalsResponseDTO pvRes = new VitalsResponseDTO();

		pvRes.setResponseMessages("All vitals created succesfully");

		
		
		// MOCK ALERT: return mocked result set on find
		when(dao.createVital(v)).thenReturn("Vitals Data Saved");
		
		// call the main method you want to test
				VitalsResponseDTO result = service.createVital(vrDTO);

		// MOCK ALERT: verify the method was called
		//verify(dao).createVital(v);

	}
}
