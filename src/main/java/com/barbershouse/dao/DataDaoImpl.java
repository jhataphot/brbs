package com.barbershouse.dao;
import java.io.Serializable;  
import java.util.List;  
import javax.transaction.Transactional;  
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.springframework.beans.factory.annotation.Autowired;  
import com.barbershouse.pojo.User;

public class DataDaoImpl implements DataDao{
	
	 @Autowired
	 SessionFactory sessionFactory;

	 @Transactional
	 public int CreateNewUser(User user) {
		  Session session = sessionFactory.openSession();
		  Transaction tx = session.beginTransaction();
		  session.saveOrUpdate(user);
		  tx.commit();
		  Serializable id = session.getIdentifier(user);
		  session.close();
		  return (Integer) id;
	 }

	 public List<User> getUserList() {
		  Session session = sessionFactory.openSession();
		  @SuppressWarnings("unchecked")
		  List<User> employeeList = session.createQuery("from User")
		    .list();
		  session.close();
		  return employeeList;
	 }

	 public User getUserById(long id) {
		  Session session = sessionFactory.openSession();
		  User employee = (User) session.load(User.class, id);
		  return employee;
	 }

	 public int updateUser(User user) {
		  Session session = sessionFactory.openSession();
		  Transaction tx = session.beginTransaction();
		  session.saveOrUpdate(user);
		  tx.commit();
		  Serializable id = session.getIdentifier(user);
		  session.close();
		  return (Integer) id;
	 }

	 public int deleteUser(long id) {
		  Session session = sessionFactory.openSession();
		  Transaction tx = session.beginTransaction();
		  User employee = (User) session.load(User.class, id);
		  session.delete(employee);
		  tx.commit();
		  Serializable ids = session.getIdentifier(employee);
		  session.close();
		  return (Integer) ids;
	 }
}
