package com.cerner.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.cerner.dao.EncounterDAO;
import com.cerner.dao.PatientDAO;
import com.cerner.dao.VitalsDAO;
import com.cerner.dto.Pv;
import com.cerner.dto.VitalRequestDTO;
import com.cerner.dto.VitalsResponseDTO;
import com.cerner.model.Encounter;
import com.cerner.model.Patient;
import com.cerner.model.Vitals;
import com.cerner.resource.UserResource;

public class VitalsService {
	final static Logger logger = Logger.getLogger(VitalsService.class);
	VitalsDAO vitalDao = new VitalsDAO();
	PatientDAO pDao = new PatientDAO();
	EncounterDAO eDao = new EncounterDAO();

	public VitalsDAO getVitalDao() {
		return vitalDao;
	}

	public void setVitalDao(VitalsDAO vitalDao) {
		this.vitalDao = vitalDao;
	}

	public PatientDAO getpDao() {
		return pDao;
	}

	public void setpDao(PatientDAO pDao) {
		this.pDao = pDao;
	}

	public EncounterDAO geteDao() {
		return eDao;
	}

	public void seteDao(EncounterDAO eDao) {
		this.eDao = eDao;
	}

	public List<Vitals> getAllVitals() {
		logger.info("getAllVitals start");
		List<Vitals> vitalList = vitalDao.getAllVitals();
		logger.info("getAllVitals end");
		return vitalList;
	}

	public Vitals getVitalForId(Integer id) {
		logger.info("getVitalForId start");
		Vitals v = vitalDao.getVitalForId(id);
		logger.info("getVitalForId end");
		return v;
	}

	public VitalsResponseDTO createVital(VitalRequestDTO vitalReqDTO) {
		logger.info("createVital  vitalReqDTO : Start ");

	

		VitalsResponseDTO pvRes = new VitalsResponseDTO();

		Patient p = pDao.getPatientForId(vitalReqDTO.getPatientId());

		List<Encounter> eList = eDao.getEncounterForPatientIdAndEId(vitalReqDTO.getPatientId(),
				vitalReqDTO.getEncounterId());

		if (p != null && p.getName() != null) {
			if (eList != null && eList.size() > 0) {
				List<Pv> lstPv = vitalReqDTO.getPv();
				Vitals v = new Vitals();
				int encounter_Id = vitalReqDTO.getEncounterId(); // vitalDao.getEncounter(vitalReqDTO.getPatientId());
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
		logger.info("createVital  vitalReqDTO : End ");
		return pvRes;
	}

	public int updateVital(int id, Vitals v) {
		logger.info("updateVital for id :" + id + " Vitals v :" + v + " Start ");

		int res = vitalDao.updateVital(id, v);
		logger.info("updateVital for id :" + id + " Vitals v :" + v + " End ");
		return res;

	}

	public List<Vitals> getVitalsForPatientId(Integer patient_id) {
		logger.info("getVitalsForPatientId for patient_id :" + patient_id + " Start ");

		List<Vitals> vitalList = vitalDao.getVitalsForPatientId(patient_id);
		logger.info("getVitalsForPatientId for patient_id :" + patient_id + " End ");
		return vitalList;
	}

	public int deleteVital(Integer id) {
		logger.info("deleteVital for id :" + id + " Start ");
		int res = vitalDao.deleteVital(id);
		logger.info("deleteVital for id :" + id + " End ");
		return res;
	}

	public Vitals recentData() {
		logger.info("recentData : Start ");
		Vitals patientResponse = vitalDao.recentData();
		logger.info("recentData : End ");
		return patientResponse;
	}

}
