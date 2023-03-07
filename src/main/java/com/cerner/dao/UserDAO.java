package com.cerner.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.cerner.model.User;
import com.cerner.util.SessionUtil;

//Just to avoid DB calls in this example, Assume below data is interacting with DB
public class UserDAO {

	public List<User> getAllUsers() {

		Session session = SessionUtil.getSession();

		Transaction transaction = session.beginTransaction();

		Query query = session.createQuery("from User u");

		List<User> userList = query.list();

		transaction.commit();
		session.close();

//		List<User> userList = new ArrayList<User>(usersMap.values());
		return userList;
	}
	
	
	

	public User getUserForId(int id) {
		Session session = SessionUtil.getSession();

		Transaction transaction = session.beginTransaction();

		User user = session.get(User.class, id);
		transaction.commit();
		session.close();

		return user;
	}

	public User createUser(User user) {
		Session session = SessionUtil.getSession();

		Transaction transaction = session.beginTransaction();
		user.setAct_ind(1);
		session.save(user);

		transaction.commit();
		session.close();

		return user;
	}

	public User updateUser(User user) {
		Session session = SessionUtil.getSession();

		Transaction transaction = session.beginTransaction();

		session.update(user);

		transaction.commit();
		session.close();

		return user;
	}

	public User deleteUser(int id) {
		Session session = SessionUtil.getSession();

		Transaction transaction = session.beginTransaction();

		User user = session.get(User.class, id);
		user.setAct_ind(0);

		session.update(user);

		transaction.commit();
		session.close();

		return user;
	}

	public boolean getUserByUserNameandPassword(String userName, String password) {
		// TODO Auto-generated method stub
		
		Session session = SessionUtil.getSession();

		Transaction transaction = session.beginTransaction();

		Query query = session.createQuery("from User u where  act_ind=1 and name =:userName and password =:password");

		 query.setParameter("userName",userName);
	      query.setParameter("password",password);
	      
		List<User> userList = query.list();
		
		if(userList!=null && userList.size()>0) {
			return true;
		}

		transaction.commit();
		session.close();


		return false;
	}

}
