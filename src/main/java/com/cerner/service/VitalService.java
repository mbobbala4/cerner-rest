package com.cerner.service;

import java.util.List;

import com.cerner.dao.EncounterDAO;
import com.cerner.dao.PatientDAO;
import com.cerner.dao.VitalsDAO;
import com.cerner.dto.Pv;
import com.cerner.dto.VitalRequestDTO;
import com.cerner.dto.VitalsResponseDTO;
import com.cerner.model.Encounter;
import com.cerner.model.Patient;
import com.cerner.model.Vitals;

public class VitalService {
	VitalsDAO vitalDao = new VitalsDAO();
	PatientDAO pDao = new PatientDAO();
	EncounterDAO eDao = new EncounterDAO();

	public List<Vitals> getAllVitals() {
		List<Vitals> vitalList = vitalDao.getAllVitals();
		return vitalList;
	}

	public Vitals getVitalForId(Integer id) {
		Vitals v = vitalDao.getVitalForId(id);
		return v;
	}

	public VitalsResponseDTO createVital(VitalRequestDTO vitalReqDTO) {

		// paitientId -- encounterid select * from encounter where patientId=
		// ?vitalReqDTO.getPatientId()
		// check for patientId
		
        VitalsResponseDTO pvRes = new VitalsResponseDTO();
		
		

		Patient p = pDao.getPatientForId(vitalReqDTO.getPatientId());

		List<Encounter> eList = eDao.getEncounterForPatientIdAndEId(vitalReqDTO.getPatientId(),
				vitalReqDTO.getEncounterId());

		if (p != null && p.getName() != null) {
			if (eList != null && eList.size() > 0) {
				List<Pv> lstPv = vitalReqDTO.getPv();
				Vitals v = new Vitals();
				int encounter_Id = vitalDao.getEncounter(vitalReqDTO.getPatientId());
				for (Pv pv : lstPv) {

					v.setPatient_Id(vitalReqDTO.getPatientId());
					v.setEncounter_id(encounter_Id);
					v.setValue(pv.getValue());
					v.setVital_name(pv.getName());
					v.setUnitsOfMesurment(pv.getUom());

					vitalDao.createVital(v);

				}
			} else {
				
				
				pvRes.setResponseMessages("Provided PatientId & EncounterId combination  doesn't exists in the system");
				
				return pvRes;
			   }
		} else {
			
			pvRes.setResponseMessages("Provided Patient Id doesn't exists in the system");
			
			return pvRes;
			
			}

		
		pvRes.setResponseMessages("All vitals created succesfully");
		
		return pvRes ;
	}
	
	  public int updateVital(int id, Vitals v){
		  
		  
		  int res =vitalDao.updateVital(id,v);
		  
		  return res;
		  
	  }

	  
	  public List<Vitals> getVitalsForPatientId(Integer patient_id) {
		  
		  List<Vitals> vitalList = vitalDao.getVitalsForPatientId(patient_id);
		  return vitalList;
	  }


	public int deleteVital(Integer id) {
		int res = vitalDao.deleteVital(id);
		return res;
	}

	public Vitals recentData() {
		Vitals patientResponse = vitalDao.recentData();
		return patientResponse;
	}

}
