package com.ty.hospital.service;

import java.util.List;

import com.ty.hospital.dao.imp.UserDaoImp;
import com.ty.hospital.dto.User;

public class UserService {
	public void saveUser(User user) {
		UserDaoImp daoImp = new UserDaoImp();
		User user1 = daoImp.saveUser(user);
		if(user1!=null) {
			System.out.println("User Saved Successfully");
		}
		else {
			System.out.println("Data not saved");
		}
	}

	public void deleteUserById(int uid) {
		UserDaoImp daoImp = new UserDaoImp();
		boolean user1 = daoImp.deleteUserById(uid);
		if(user1) {
			System.out.println("Deleted Successfully");
		}
		else {
			System.out.println("Data not deleted");
		}
	}

	public User getUserById(int uid) {
		UserDaoImp daoImp = new UserDaoImp();
		User user1 = daoImp.getUserById(uid);
		if(user1!=null) {
			return user1;
		}
		else {
			return null;
		}
	}

	public User getUserByName(String name) {
		UserDaoImp daoImp = new UserDaoImp();
		User user1 = daoImp.getUserByName(name);
		if(user1!=null) {
			return user1;
		}
		else {
			return null;
		}
	}

	public User getUserByRole(String role) {
		UserDaoImp daoImp = new UserDaoImp();
		User user1 = daoImp.getUserByRole(role);
		if(user1!=null) {
			return user1;
		}
		else {
			return null;
		}
	}

	public List<User> getAllUser(){
		UserDaoImp daoImp = new UserDaoImp();
		List<User> user1 = daoImp.getAllUser();
		if(user1!=null) {
			return user1;
		}
		else {
			return null;
		}
	}

}
