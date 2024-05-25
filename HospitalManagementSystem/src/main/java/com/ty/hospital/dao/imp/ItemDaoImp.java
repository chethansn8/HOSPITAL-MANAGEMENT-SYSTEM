package com.ty.hospital.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital.dao.ItemDao;
import com.ty.hospital.dto.Item;
import com.ty.hospital.dto.MedOrder;

public class ItemDaoImp implements ItemDao{

	public Item saveItem(int mid,Item item) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chethu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		MedOrder medOrder = entityManager.find(MedOrder.class, mid);
		if(medOrder!=null) {
			entityTransaction.begin();
			entityManager.persist(item);
			entityTransaction.commit();

			return item;
		}
		else {
			return null;
		}
	}

	public boolean deleteItemById(int iId) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chethu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Item item = entityManager.find(Item.class, iId);
		if(item!=null) {
			entityTransaction.begin();
			entityManager.remove(item);
			entityTransaction.commit();
			return true;
		}
		else {	
			return false;
		}
	}

	public Item getItemById(int iId) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chethu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Item item = entityManager.find(Item.class, iId);
		if(item!=null) {
			return item;
		}
		else {
			return null;
		}
	}

	public List<Item> getAllItem() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chethu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Query query = entityManager.createQuery("select c from Item c");
		List<Item> item = query.getResultList();
		return item;
	}

	public Item getItemByMedOrder(int mid) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chethu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		MedOrder medOrder = entityManager.find(MedOrder.class, mid);
		if(medOrder!=null) {
			Query query = entityManager.createQuery("select c from Item c where mid=?1");
			query.setParameter(1, mid);
			List<Item> items = query.getResultList();
			for(Item item :items) {
				System.out.println("iId:"+item.getiId());
				System.out.println("Item Name:"+item.getItemName());
				System.out.println("Quantity:"+item.getQuantity());
				System.out.println("Cost:"+item.getCost());
				return item;
			}
		}
		return null;
	}
}
