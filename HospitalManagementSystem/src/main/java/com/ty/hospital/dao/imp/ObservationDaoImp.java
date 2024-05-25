package com.ty.hospital.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital.dao.ObservationDao;
import com.ty.hospital.dto.Encounter;
import com.ty.hospital.dto.Observation;

public class ObservationDaoImp implements ObservationDao{

	public Observation saveObservation(int eid, Observation observation) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chethu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Encounter encounter = entityManager.find(Encounter.class, eid);
		if(encounter!=null) {
			entityTransaction.begin();
			entityManager.persist(observation);
			entityTransaction.commit();
			return observation;
		}
		else {
			return null;
		}
	}

	public boolean deleteObservationById(int oid) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chethu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Observation observation = entityManager.find(Observation.class, oid);
		if(observation!=null) {
			entityTransaction.begin();
			entityManager.remove(observation);
			entityTransaction.commit();

			return true;
		}
		else {
			return false;
		}
	}

	public Observation getObservationById(int oid) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chethu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Observation observation = entityManager.find(Observation.class, oid);
		if(observation!=null) {
			return observation;
		}
		else {
			return null;
		}
	}

	public Observation updateObservationById(int oid, Observation observation) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chethu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Observation observation1 = entityManager.find(Observation.class, oid);
		if(observation1!=null) {
			observation1.setDname(observation.getDname());
			observation1.setR_observation(observation.getR_observation());
			entityTransaction.begin();
			entityManager.merge(observation1);
			entityTransaction.commit();

			return observation;
		}
		else {
			return null;
		}
	}

	public List<Observation> getAllObservation() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chethu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Query query = entityManager.createQuery("select c from Observation c");
		List<Observation> observation = query.getResultList();
		return observation;
	}

	public Observation getObservationByDname(String dname) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chethu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Query query = entityManager.createQuery("select c from Observation c where dname=?1");
		query.setParameter(1, dname);
		List<Observation> observation =  query.getResultList();
		for(Observation observation2 : observation) {
			System.out.println("oid:"+observation2.getOid());
			System.out.println("Dname:"+observation2.getDname());
			System.out.println("R_Observation:"+observation2.getR_observation());
			return observation2;
		}
		return null;
	}

}
