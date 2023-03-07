package com.cerner.service;

	import java.util.List;

import com.cerner.dao.EncounterDAO;
import com.cerner.dao.FacilityDAO;
import com.cerner.dao.PatientDAO;
import com.cerner.dto.EncounterRequestDTO;
import com.cerner.dto.VitalsResponseDTO;
import com.cerner.model.Encounter;
import com.cerner.model.Facility;
import com.cerner.model.Patient;

	public class EncounterService {
		EncounterDAO eDao = new EncounterDAO();
		PatientDAO pDao = new PatientDAO();
		FacilityDAO fDao = new FacilityDAO();

		public List<Encounter> getAllEncounter() {
			List<Encounter> eList = eDao.getAllEncounter();
			return eList;
		}

		public Encounter getEncounterForId(Integer id) {
			Encounter e = eDao.getEncounterForId(id);
			return e;
		}

		public VitalsResponseDTO createEncounter(EncounterRequestDTO encounterReqDTO) {

			// paitientId -- encounterid select * from encounter where patientId=
			// ?EncounterReqDTO.getPatientId()
			// check for patientId
			
	        VitalsResponseDTO pvRes = new VitalsResponseDTO();
			
			

			Patient p = pDao.getPatientForId(encounterReqDTO.getPatientId());
			
			Facility f = fDao.getFacilityForId(encounterReqDTO.getFacilityId());


			

			if (p != null && p.getName() != null) {
				if (f != null && f.getLocation() !="") {
					
					Encounter e = new Encounter();
					e.setAct_ind(1);
					e.setFacility_Id(encounterReqDTO.getFacilityId());
					e.setPatient_Id(encounterReqDTO.getPatientId());
				    eDao.createEncounter(e);

					}
				 else {
					
					pvRes.setResponseMessages("Provided facilityId   doesn't exists in the system");
					
					return pvRes;
				   }
			} else {
				
				pvRes.setResponseMessages("Provided Patient Id doesn't exists in the system");
				
				return pvRes;
				
				}

			
		
			pvRes.setResponseMessages("All Encounter created succesfully");
			
			return pvRes ;
		}

		public Encounter updateEncounter(Encounter Encounter) {
			Encounter patientResponse = eDao.updateEncounter(Encounter);
			return patientResponse;
		}

		public Encounter deleteEncounter(Integer id) {
			Encounter patientResponse = eDao.deleteEncounter(id);
			return patientResponse;
		}

	

	}



