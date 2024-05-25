package com.ty.hospital.dao.imp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.hospital.dao.HospitalDao;
import com.ty.hospital.dto.Hospital;

public class HospitalDaoImp implements HospitalDao{

	public Hospital saveHospital(Hospital hospital) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chethu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(hospital);
		entityTransaction.commit();

		return hospital;
	}  

	public boolean deleteHospitalById(int hId) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chethu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Hospital hospital = entityManager.find(Hospital.class,hId);
		if(hospital!=null) {
			entityTransaction.begin();
			entityManager.remove(hospital);
			entityTransaction.commit();
			return true;
		}
		else {
			return false;
		}
	}

	public Hospital getHospitalById(int hId) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chethu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Hospital hospital = entityManager.find(Hospital.class,hId);
		if(hospital!=null) {
			return hospital;
		}
		else {
			return null;
		}
	}

	public Hospital updateHospitalById(int hId, Hospital hospital) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chethu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Hospital hospital1 = entityManager.find(Hospital.class, hId);
		if(hospital1!=null) {
			hospital1.setHname(hospital.getHname());
			hospital1.setWebsite(hospital.getWebsite());

			entityTransaction.begin();
			entityManager.merge(hospital1);
			entityTransaction.commit();

			return hospital1;
		}
		else {
			return null;
		}
	}

}
