package com.ty.hospital.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital.dao.PersonDao;
import com.ty.hospital.dto.Encounter;
import com.ty.hospital.dto.Person;

public class PersonDaoImp implements PersonDao{

	public Person savePerson(int eid, Person person) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chethu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Encounter encounter = entityManager.find(Encounter.class, eid);
		if(encounter!=null) {
			entityTransaction.begin();
			entityManager.persist(person);
			entityTransaction.commit();
			return person;
		}
		else {	
			return null;
		}
	}

	public boolean deletePersonById(int id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chethu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Person person = entityManager.find(Person.class, id);
		if(person!=null) {
			entityTransaction.begin();
			entityManager.remove(person);
			entityTransaction.commit();

			return true;
		}
		else {	
			return false;
		}
	}

	public Person getPersonById(int id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chethu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Person person = entityManager.find(Person.class, id);
		if(person!=null) {
			return person;
		}
		else {
			return null;
		}
	}

	public List<Person> getAllPerson() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chethu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Query query = entityManager.createQuery("select c from Person c");
		List<Person> person = query.getResultList();
		if(person!=null) {
			return person;
		}
		else {
			return null;
		}
	}

	public List<Person> getPersonByGender(String gender) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chethu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Query query = entityManager.createQuery("select c from Person c where gender=?1");
		query.setParameter(1,gender);
		List<Person> person = query.getResultList();
		if(person!=null) {
			return person;
		}
		else {
			return null;
		}
	}

	public List<Person> getPersonByAge(int age) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chethu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Query query = entityManager.createQuery("select c from Person c where age=?1");
		query.setParameter(1,age);
		List<Person> person = query.getResultList();
		if(person!=null) {
			return person;
		}
		else {
			return null;
		}
	}

	public Person getPersonByPhno(long phno) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chethu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Query query = entityManager.createQuery("select c from Person c where phno=?1");
		query.setParameter(1,phno);

		List<Person> person = query.getResultList();
		if(person!=null) {
			for(Person person1 : person) {
				System.out.println("pid:"+person1.getId());
				System.out.println("pname:"+person1.getName());
				System.out.println("Age:"+person1.getAge());
				System.out.println("Gender:"+person1.getGender());
				System.out.println("Gmail:"+person1.getEmail());
				System.out.println("DOB:"+person1.getDoB());
				System.out.println("Address:"+person1.getAddress());
				System.out.println("Phno:"+person1.getPhno());
				return person1;
			}
		}
		return null;	
	}
}

