package com.ty.hospital.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital.dao.AddressDao;
import com.ty.hospital.dto.Address;
import com.ty.hospital.dto.Branch;

public class AddressDaoImp implements AddressDao{

	public Address saveAddress(int bid, Address address) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chethu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Branch branch = entityManager.find(Branch.class,bid);
		if(branch!=null) {
			entityTransaction.begin();
			entityManager.persist(address);
			entityTransaction.commit();
		}
		return address;
	}

	public boolean deleteAddressById(int aid) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chethu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Address address = entityManager.find(Address.class, aid);
		if(address!=null) {
			entityTransaction.begin();
			entityManager.remove(address);
			entityTransaction.commit();

			return true;
		}
		else {
			return false;
		}
	}

	public Address getAddressById(int aid) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chethu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Address address = entityManager.find(Address.class, aid);
		if(address!=null) {
			return address;
		}
		else {
			return null;
		}
	}

	public Address updateAddressById(int aid, Address address) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chethu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Address address1 = entityManager.find(Address.class, aid);
		if(address1!=null) {
			address1.setPin(address.getPin());
			address1.setStreet(address.getStreet());
			address1.setState(address.getState());
			address1.setCountry(address.getCountry());

			entityTransaction.begin();
			entityManager.merge(address1);
			entityTransaction.commit();

			return address1;
		}
		else {
			return null;
		}
	}

	public List<Address> getAllAddress() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chethu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Query query = entityManager.createQuery("select c from Address c");
		List<Address> address = query.getResultList();
		return address;
	}
}
