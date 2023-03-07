package com.cerner.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.cerner.model.Encounter;
import com.cerner.model.User;
import com.cerner.util.SessionUtil;

//Just to avoid DB calls in this example, Assume below data is interacting with DB
public class EncounterDAO {

	public List<Encounter> getEncounters() {
		Session session = SessionUtil.getSession();

		Transaction transaction = session.beginTransaction();

		Query query = session.createQuery("from Encounter e");

		List<Encounter> eList = query.list();

		transaction.commit();
		session.close();

//		List<User> userList = new ArrayList<User>(usersMap.values());
		return eList;
	}

	public List<Encounter> getEncounterForPatientIdAndEId(int pid, int eid) {
		Session session = SessionUtil.getSession();

		Transaction transaction = session.beginTransaction();

		String hql = "FROM Encounter E WHERE E.id =" + eid + " and E.patient_id =" + pid;
		Query query = session.createQuery(hql);
		List<Encounter> results = query.list();

		transaction.commit();
		session.close();

		return results;
	}

	public Encounter createEncounter(Encounter e) {
		Session session = SessionUtil.getSession();

		Transaction transaction = session.beginTransaction();
		e.setAct_ind(1);
		session.save(e);

		transaction.commit();
		session.close();

		return e;
	}

	public Encounter updateEncounter(Encounter encounter) {
		Session session = SessionUtil.getSession();

		Transaction transaction = session.beginTransaction();

		session.update(encounter);

		transaction.commit();
		session.close();

		return encounter;
	}

	public Encounter deleteEncounter(int id) {
		Session session = SessionUtil.getSession();
		Transaction transaction = session.beginTransaction();

		Encounter e = session.get(Encounter.class, id);
		e.setAct_ind(0);
		session.delete(e);

		transaction.commit();
		session.close();

		return e;
	}

	public List<Encounter> getAllEncounter() {
		// TODO Auto-generated method stub
		return null;
	}

	public Encounter getEncounterForId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
