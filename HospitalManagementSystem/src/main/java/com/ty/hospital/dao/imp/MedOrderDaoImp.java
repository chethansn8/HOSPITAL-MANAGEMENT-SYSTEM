package com.ty.hospital.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital.dao.MedOrderDao;
import com.ty.hospital.dto.Encounter;
import com.ty.hospital.dto.MedOrder;

public class MedOrderDaoImp implements MedOrderDao{

	public MedOrder saveMedOrder(int eid, MedOrder medOrder) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chethu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Encounter encounter = entityManager.find(Encounter.class, eid);
		if(encounter!=null) {
			entityTransaction.begin();
			entityManager.persist(medOrder);
			entityTransaction.commit();
			return medOrder;	
		}
		else {
			return null;
		}
	}

	public boolean deleteMedOrderById(int mid) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chethu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		MedOrder medOrder = entityManager.find(MedOrder.class, mid);
		if(medOrder!=null) {
			entityTransaction.begin();
			entityManager.remove(medOrder);
			entityTransaction.commit();
			return true;
		}
		else {
			return false;
		}
	}

	public MedOrder getMedOrderById(int mid) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chethu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		MedOrder medOrder = entityManager.find(MedOrder.class, mid);
		if(medOrder!=null) {
			return medOrder;
		}
		else {
			return null;
		}
	}

	public MedOrder updateMedOrderById(int mid, MedOrder medOrder) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chethu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		MedOrder medOrder1 = entityManager.find(MedOrder.class, mid);
		if(medOrder1!=null) {
			medOrder1.setOrderDate(medOrder.getOrderDate());
			medOrder1.setDname(medOrder.getDname());
			medOrder1.setTotal(medOrder.getTotal());
			entityTransaction.begin();
			entityManager.merge(medOrder1);
			entityTransaction.commit();
			return medOrder1;
		}
		else {
			return null;
		}
	}

	public List<MedOrder> getAllMedOrder() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chethu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();	

		Query query = entityManager.createQuery("select c from MedOrder c");
		List<MedOrder> medOrder =query.getResultList();
		return medOrder;
	}

	public MedOrder getMedOrderByDname(String dname) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chethu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Query query = entityManager.createQuery("select c from MedOrder c where dname=?1");
		query.setParameter(1, dname);
		List<MedOrder> medOrders = query.getResultList();
		for(MedOrder medOrder : medOrders) {
			System.out.println("mid:"+medOrder.getMid());
			System.out.println("Dname:"+medOrder.getDname());
			System.out.println("Order Date:"+medOrder.getOrderDate());
			System.out.println("Total:"+medOrder.getTotal());
			return medOrder;
		}	
		return null;
	}

	public MedOrder getMedOrderByOrderDate(String orderDate) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chethu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Query query = entityManager.createQuery("select c from MedOrder c where orderDate=?1");
		query.setParameter(1, orderDate);
		List<MedOrder> medOrders = query.getResultList();
		for(MedOrder medOrder : medOrders) {
			System.out.println("mid:"+medOrder.getMid());
			System.out.println("Dname:"+medOrder.getDname());
			System.out.println("Order Date:"+medOrder.getOrderDate());
			System.out.println("Total:"+medOrder.getTotal());
			return medOrder;
		}
		return null; 
	}

}
