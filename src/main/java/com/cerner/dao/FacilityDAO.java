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
import com.cerner.model.Facility;
import com.cerner.model.Patient;
import com.cerner.model.User;
import com.cerner.util.SessionUtil;

//Just to avoid DB calls in this example, Assume below data is interacting with DB
public class FacilityDAO {

	public List<Facility> getFacilities() {
		Session session = SessionUtil.getSession();

		Transaction transaction = session.beginTransaction();

		Query query = session.createQuery("from Facility f ");

		List<Facility> eList = query.list();

		transaction.commit();
		session.close();

//		List<User> userList = new ArrayList<User>(usersMap.values());
		return eList;
	}

	public Facility createFacility(Facility f) {
		Session session = SessionUtil.getSession();

		Transaction transaction = session.beginTransaction();
		f.setAct_ind(1);
		session.save(f);

		transaction.commit();
		session.close();

		return f;
	}

	public Facility updateFacility(Facility fac) {
		Session session = SessionUtil.getSession();

		Transaction transaction = session.beginTransaction();

		session.update(fac);

		transaction.commit();
		session.close();

		return fac;
	}

	public Facility deleteUser(int id) {
		Session session = SessionUtil.getSession();

		Transaction transaction = session.beginTransaction();

		Facility f = session.get(Facility.class, id);
		f.setAct_ind(0);
		session.delete(f);

		transaction.commit();
		session.close();

		return f;
	}

	public Facility getFacilityForId(Integer id) {
		Session session = SessionUtil.getSession();

		Transaction transaction = session.beginTransaction();

		Facility fac = session.get(Facility.class, id);
		transaction.commit();
		session.close();

		return fac;
	}

}
