package com.cerner.service;

import java.util.List;

import com.cerner.dao.UserDAO;
import com.cerner.model.User;

public class UserService {
	UserDAO userDao = new UserDAO();

	public List<User> getAllUsers() {
		List<User> userList = userDao.getAllUsers();
		return userList;
	}

	public User getUserForId(int id) {
		User user = userDao.getUserForId(id);
		return user;
	}
	
	public boolean getUserByUserNameandPassword(String userName ,String password) {
		boolean  validUser = userDao.getUserByUserNameandPassword(userName,password);
		return validUser;
	}

	public User createUser(User user) {
		User userResponse = userDao.createUser(user);
		return userResponse;
	}

	public User updateUser(User user) {
		User userResponse = userDao.updateUser(user);
		return userResponse;
	}

	public User deleteUser(int id) {
		User userResponse = userDao.deleteUser(id);
		return userResponse;
	}

}
