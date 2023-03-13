package com.cerner.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.cerner.model.Patient;
import com.cerner.util.SessionUtil;

//Just to avoid DB calls in this example, Assume below data is interacting with DB
public class PatientDAO {

	public List<Patient> getAllPatients() {
		Session session = SessionUtil.getSession();

		Transaction transaction = session.beginTransaction();

		Query query = session.createQuery("from Patient p");

		List<Patient> pList = query.list();

		transaction.commit();
		session.close();
		return pList;
	}

	public Patient getPatientForId(int id) {
		Session session = SessionUtil.getSession();

		Transaction transaction = session.beginTransaction();

		Patient patient = session.get(Patient.class, id);
		transaction.commit();
		session.close();

		return patient;
	}

	public Patient createPatient(Patient patient) {
		Session session = SessionUtil.getSession();
		Transaction transaction = session.beginTransaction();

		session.save(patient);

		transaction.commit();
		session.close();

		return patient;
	}

	public Patient updatePatient(Patient patient) {
		Session session = SessionUtil.getSession();
		Transaction transaction = session.beginTransaction();

		session.update(patient);

		transaction.commit();
		session.close();

		return patient;
	}

	public Patient deletePatient(int id) {
		Session session = SessionUtil.getSession();
		Transaction transaction = session.beginTransaction();

		Patient patient = session.get(Patient.class, id);
		patient.setAct_ind(0);
		session.update(patient);

		transaction.commit();
		session.close();

		return patient;
	}

}
