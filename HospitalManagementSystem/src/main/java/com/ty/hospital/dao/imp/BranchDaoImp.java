package com.ty.hospital.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital.dao.BranchDao;
import com.ty.hospital.dto.Branch;
import com.ty.hospital.dto.Hospital;

public class BranchDaoImp implements BranchDao {

	public Branch saveBranch(int hId, Branch branch) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chethu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Hospital hospital = entityManager.find(Hospital.class, hId);
		if(hospital!=null) {
			entityTransaction.begin();
			entityManager.persist(branch);
			entityTransaction.commit();

			return branch;
		}
		else {
			return null;
		}
	}

	public boolean deleteBranchById(int bid) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chethu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Branch branch = entityManager.find(Branch.class, bid);
		if(branch!=null) {
			entityTransaction.begin();
			entityManager.remove(branch);
			entityTransaction.commit();

			return true;
		}
		else {
			return false;
		}
	}

	public Branch getBranchById(int bid) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chethu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Branch branch = entityManager.find(Branch.class, bid);

		if(branch!=null) {
			return branch;
		}
		else {
			return null;
		}
	}

	public Branch updateBranchById(int bid, Branch branch) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chethu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Branch branch1 = entityManager.find(Branch.class, bid);

		if(branch1!=null) {
			branch1.setAddress(branch.getAddress());
			branch1.setBname(branch.getBname());
			branch1.setPhno(branch.getPhno());
			branch1.setEmail(branch.getEmail());

			entityTransaction.begin();
			entityManager.merge(branch1);
			entityTransaction.commit();

			return branch1;
		}
		else {
			return null;
		}
	}

	public List<Branch> getAllBranch() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chethu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Query query = entityManager.createQuery("select c from Branch c");
		List<Branch> branch = query.getResultList();
		return branch;
	}

}
