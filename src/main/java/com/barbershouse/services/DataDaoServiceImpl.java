package com.barbershouse.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.barbershouse.dao.DataDao;
import com.barbershouse.pojo.User;
public class DataDaoServiceImpl implements DataDaoService{
	
	 @Autowired
	 DataDao dataDao;

	 public int CreateNewUser(User user) {
	  return dataDao.CreateNewUser(user);
	 }

	
	 public List<User> getUserList() {
	  return dataDao.getUserList();
	 }

	 public User getUserById(long id) {
	  return dataDao.getUserById(id);
	 }

	 public int updateUser(User employee) {
	  return dataDao.updateUser(employee);
	 }


	public int deleteUser(long id) {
		return dataDao.deleteUser(id);
	}

}
