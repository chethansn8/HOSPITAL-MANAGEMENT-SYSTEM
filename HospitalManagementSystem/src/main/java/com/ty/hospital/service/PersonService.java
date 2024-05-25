package com.ty.hospital.service;

import java.util.List;

import com.ty.hospital.dao.imp.PersonDaoImp;
import com.ty.hospital.dto.Person;

public class PersonService {
	public void savePerson(int eid,Person person) {
		PersonDaoImp daoImp = new PersonDaoImp();
		Person person1 = daoImp.savePerson(eid, person);
		if(person1!=null) {
			System.out.println("Data saved Successfully");
		}
		else {
			System.out.println("Data not saved");
		}
	}

	public void deletePersonById(int id) {
		PersonDaoImp daoImp = new PersonDaoImp();
		boolean person1 = daoImp.deletePersonById(id);
		if(person1) {
			System.out.println("Deleted Successfully");
		}
		else {
			System.out.println("Data not deleted");
		}
	}

	public Person getPersonById(int id) {
		PersonDaoImp daoImp = new PersonDaoImp();
		Person person1 = daoImp.getPersonById(id);
		if(person1!=null) {
			return person1;
		}
		else {
			return null;
		}
	}

	public List<Person> getPersonByGender(String gender) {
		PersonDaoImp daoImp = new PersonDaoImp();
		List<Person> person1 = daoImp.getPersonByGender(gender);
		if(person1!=null) {
			return person1;
		}
		else {
			return null;
		}
	}

	public List<Person> getPersonByAge(int age) {
		PersonDaoImp daoImp = new PersonDaoImp();
		List<Person> person1 = daoImp.getPersonByAge(age);
		if(person1!=null) {
			return person1;
		}
		else {
			return null;
		}
	}

	public Person getPersonByPhno(long phno) {
		PersonDaoImp daoImp = new PersonDaoImp();
		Person person1 = daoImp.getPersonByPhno(phno);
		if(person1!=null) {
			return person1;
		}
		else {
			return null;
		}
	}

	public List<Person> getAllPerson() {
		PersonDaoImp daoImp = new PersonDaoImp();
		List<Person> person1 = daoImp.getAllPerson();
		if(person1!=null) {
			return person1;
		}
		else {
			return null;
		}
	}
}
