package com.ty.hospital.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital.dao.UserDao;
import com.ty.hospital.dto.User;

public class UserDaoImp implements UserDao{

	public User saveUser(User user) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chethu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();

		return user;
	}

	public boolean deleteUserById(int uid) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chethu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		User user = entityManager.find(User.class, uid);
		if(user!=null) {
			entityTransaction.begin();
			entityManager.remove(user);
			entityTransaction.commit();
			return true;
		}
		else {
			return false;
		}
	}

	public User getUserById(int uid) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chethu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		User user = entityManager.find(User.class, uid);
		if(user!=null) {
			return user;
		}
		else {
			return null;
		}
	}

	public List<User> getAllUser() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chethu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Query query = entityManager.createQuery("select c from User c");
		List<User> users = query.getResultList();
		return users;
	}

	public User getUserByName(String name) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chethu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Query query = entityManager.createQuery("select c from User c where name=?1");
		query.setParameter(1, name);
		List<User> users = query.getResultList();
		for(User user : users) {
			System.out.println("Uid:"+user.getUid());
			System.out.println("Name:"+user.getName());
			System.out.println("Role:"+user.getRole());
			System.out.println("Email:"+user.getEmail());
			System.out.println("Phno:"+user.getPhno());
			System.out.println("Password:"+user.getPassword());
			return user;
		}
		return null;
	}

	public User getUserByRole(String role) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chethu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Query query = entityManager.createQuery("select c from User c where role=?1");
		query.setParameter(1, role);
		List<User> users = query.getResultList();
		for(User user : users) {
			System.out.println("Uid:"+user.getUid());
			System.out.println("Name:"+user.getName());
			System.out.println("Role:"+user.getRole());
			System.out.println("Email:"+user.getEmail());
			System.out.println("Phno:"+user.getPhno());
			System.out.println("Password:"+user.getPassword());
			return user;
		}		
		return null;
	}

}
