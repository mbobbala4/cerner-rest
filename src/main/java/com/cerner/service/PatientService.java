package com.cerner.service;

import java.util.List;

import com.cerner.dao.EncounterDAO;
import com.cerner.dao.PatientDAO;
import com.cerner.dto.PatientRequestDTO;
import com.cerner.dto.PatientResponseDTO;
import com.cerner.model.Patient;

public class PatientService {

	PatientDAO pDao = new PatientDAO();
	EncounterDAO eDao = new EncounterDAO();

	public List<Patient> getAllPatients() {
		List<Patient> patientList = pDao.getAllPatients();
		return patientList;
	}

	public Patient getPatientForId(Integer id) {
		Patient patient = pDao.getPatientForId(id);
		return patient;
	}

	public PatientResponseDTO createPatient(PatientRequestDTO patientReqDTO) {

		PatientResponseDTO pvRes = new PatientResponseDTO();

		Patient p = new Patient();

		p.setAct_ind(1);
		p.setAddress(patientReqDTO.getAddress());
		p.setAge(patientReqDTO.getAge());
		p.setDateOfBirth(patientReqDTO.getDateOfBirth());
		p.setGender(patientReqDTO.getGender());
		p.setName(patientReqDTO.getName());

		return pvRes;
	}

	public Patient updatePatient(Patient Patient) {
		Patient patientResponse = pDao.updatePatient(Patient);
		return patientResponse;
	}

	public Patient deletePatient(Integer id) {
		Patient patientResponse = pDao.deletePatient(id);
		return patientResponse;
	}

}
