package com.barbershouse.dao;

import java.util.List;

import com.barbershouse.pojo.User;

public interface DataDao {
	
	 public int CreateNewUser(User user);

	 public List<User> getUserList();

	 public User getUserById(long id);

	 public int updateUser(User user);

	 public int deleteUser(long id);
}
