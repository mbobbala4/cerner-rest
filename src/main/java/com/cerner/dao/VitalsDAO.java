package com.cerner.dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cerner.model.Encounter;
import com.cerner.model.Vitals;
import com.cerner.util.SessionUtil;


public class VitalsDAO {

	public List<Vitals> getAllVitals() {
		Session session = SessionUtil.getSession();
		Transaction transaction = session.beginTransaction();

		Query<Vitals> query = session.createQuery("from Vitals v where v.act_ind =1");

		List<Vitals> list = query.list();

		transaction.commit();
		session.close();

		
		return list;
	}

	public Vitals getVitalForId(Integer id) {
		Session session = SessionUtil.getSession();

		Query<Vitals> query = session.createQuery("from Vitals v where v.act_ind =1 and v.id =:id");
		query.setParameter("id", id);

		List<Vitals> list = query. getResultList();

		
		if(list!= null && list.size()>0) {
			
			return list.get(0);
		}

		session.close();

		return null;
	}

	public String createVital(Vitals vital) {

		Session session = SessionUtil.getSession();
		Transaction transaction = session.beginTransaction();

		vital.setUpdation_date(LocalDate.now());
		vital.setAct_ind(1);

		session.save(vital);

		transaction.commit();
		session.close();

		return "Vitals Data saved ";
	}

	public int updateVital(int id, Vitals v) {
		int rowCount = 0;
		if (id <= 0)
			return 0;
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();

		Query queryGet = session.createQuery("from Vitals where  id = :id");
		queryGet.setParameter("id", id);

		List<Vitals> vs = queryGet.list();

		if (vs != null && vs.size() > 0 && vs.get(0) != null) {
			if (vs.get(0).getAct_ind() == 1) {
				int updateCount = vs.get(0).getUpdate_count();

				String hql = "update Vitals v set vital_name = :name ,"
						+ " update_count = :updatecount ,v.unitsOfMesurment =:unitsOfMesurment"
						+ ",value =:value , updation_date = current_date "
						+ "where id =:id";
				Query query = session.createQuery(hql);
				query.setParameter("id", id);
				query.setParameter("name", v.getVital_name());
				query.setParameter("updatecount", updateCount + 1);
				query.setParameter("unitsOfMesurment", v.getUnitsOfMesurment());
				query.setParameter("value",v.getValue());

				rowCount = query.executeUpdate();
				System.out.println("Rows affected: " + rowCount);
				tx.commit();
				session.close();
			}else {
				return -1;
			}
		}
		return rowCount;

	}

	public int deleteVital(Integer id) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "update Vitals set act_ind = 0 where act_ind = 1  and id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);

		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
	}

	public Vitals recentData() {
		Session session = SessionUtil.getSession();
		Transaction transaction = session.beginTransaction();

		Vitals patient = null;

		// session.delete(patient);
		Query query = session.createQuery("from Vitals v ORDER BY v.vital_Id desc");

		List<Vitals> patientList1 = query.list();
		int i = 1;
		for (int j = 0; j < i; j++) {
			patient = patientList1.get(j);
		}

		transaction.commit();
		session.close();

		return patient;
	}

	public int getEncounter(int id) {

		Session session = SessionUtil.getSession();

		Encounter encounter = session.get(Encounter.class, id);

		int encounter_Id = encounter.getId();

		session.close();

		return encounter_Id;
	}

	public List<Vitals> getVitalsForPatientId(Integer patient_id) {
		Session session = SessionUtil.getSession();
		Transaction transaction = session.beginTransaction();

		Query<Vitals> query = session.createQuery("from Vitals v where v.act_ind=1 and patient_Id=:patient_id");
		query.setParameter("patient_id", patient_id);

		List<Vitals> list = query.getResultList();

		transaction.commit();
		session.close();

		return list;
	}



}
