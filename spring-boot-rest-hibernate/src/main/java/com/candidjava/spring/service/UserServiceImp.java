package com.candidjava.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.candidjava.Application;
import com.candidjava.spring.bean.User;
import com.candidjava.spring.dao.UserDao;
import com.candidjava.spring.dao.UserDaoImp;

@Service
public class UserServiceImp implements UserService {
	
	
	@Autowired
	UserDao userDao;


	public List<User> getUser() {
		// TODO Auto-generated method stub
		return userDao.getUser();
	}

	public User findById(int id) {
		// TODO Auto-generated method stub
		return userDao.findById(id);
	}
	
	@Transactional(isolation=Isolation.DEFAULT)
	public void createUser(User user) {
		// TODO Auto-generated method stub
		userDao.addUser(user);
	}
	private void createUser1(User user) {
		userDao.addUser(user);
	}

	public void deleteUserById(int id) {
		// TODO Auto-generated method stub
		userDao.delete(id);
	}
	@Override
	public User updatePartially(User user, int id) {
		userDao.updateCountry(user,id);
		return userDao.findById(id);
	}

	@Override
	public User update(User user,int id) {
		// TODO Auto-generated method stub
		return userDao.update(user, id);
	}
	
	@Transactional
	public void createUserList(List<User> userList) throws Exception {
		addFirstUser(userList.get(0));
		addSecondUser(userList.get(1));
		addThirdUser(userList.get(2));
	}

	public void addFirstUser(User user) {
		userDao.addUser(user);
	}
	
	public void addSecondUser(User user) {
		userDao.addUser(user);
	}
	public void addThirdUser(User user) {
		userDao.addUser(user);
	}
}
