package com.ty.hospital.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital.dao.EncounterDao;
import com.ty.hospital.dto.Branch;
import com.ty.hospital.dto.Encounter;
import com.ty.hospital.dto.Person;

public class EncounterDaoImp implements EncounterDao{

	public Encounter saveEncounter(int bid, int id, Encounter encounter) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chethu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Branch branch = entityManager.find(Branch.class, bid);
		if(branch!=null) {
			Person person = entityManager.find(Person.class, id);
			if(person!=null) {
				entityTransaction.begin();
				entityManager.persist(encounter);
				entityTransaction.commit();
			}
		}
		return encounter;
	}

	public boolean deleteEncounterById(int eid) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chethu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();		

		Encounter encounter = entityManager.find(Encounter.class, eid);
		if(encounter!=null) {
			entityTransaction.begin();
			entityManager.remove(encounter);
			entityTransaction.commit();

			return true;
		}
		else {	
			return false;
		}
	}

	public Encounter getEncounterById(int eid) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chethu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Encounter encounter = entityManager.find(Encounter.class, eid);
		if(encounter!=null) {
			return encounter;
		}
		else {
			return null;
		}
	}

	public Encounter updateEncounterById(int eid, Encounter encounter) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chethu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Encounter encounter1 = entityManager.find(Encounter.class, eid);
		
		if(encounter1!=null) {
			encounter1.setDateOfJoin(encounter.getDateOfJoin());
			encounter1.setDateOfDischarge(encounter.getDateOfDischarge());
			return encounter1;
		}
		else {
			return null;
		}
	}

	public List<Encounter> getAllEncounter() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chethu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Query query = entityManager.createQuery("select c from Encounter c");
		List<Encounter> encounter = query.getResultList();

		return encounter;
	}
}
