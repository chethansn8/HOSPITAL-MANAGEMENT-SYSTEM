package com.ty.hospital.service;

import java.util.List;

import com.ty.hospital.dao.imp.MedOrderDaoImp;
import com.ty.hospital.dto.MedOrder;

public class MedOrderService {
	public void saveMedOrder(int eid,MedOrder medOrder) {
		MedOrderDaoImp daoImp = new MedOrderDaoImp();
		MedOrder medOrder1 = daoImp.saveMedOrder(eid, medOrder);
		if(medOrder1!=null) {
			System.out.println("Data saved Successfully");
		}
		else {
			System.out.println("Data not Saved");
		}
	}

	public void deleteMedOrderById(int mid) {
		MedOrderDaoImp daoImp = new MedOrderDaoImp();
		boolean medOrder1 = daoImp.deleteMedOrderById(mid);
		if(medOrder1) {
			System.out.println("Deleted Successfully");
		}
		else {
			System.out.println("Data not deleted");
		}
	}

	public MedOrder getMedOrderById(int mid) {
		MedOrderDaoImp daoImp = new MedOrderDaoImp();
		MedOrder medOrder1 = daoImp.getMedOrderById(mid);
		if(medOrder1!=null) {
			return medOrder1;
		}
		else {
			return null;
		}
	}

	public MedOrder getMedOrderByDname(String dname) {
		MedOrderDaoImp daoImp = new MedOrderDaoImp();
		MedOrder medOrder1 = daoImp.getMedOrderByDname(dname);
		if(medOrder1!=null) {
			return medOrder1;
		}
		else {
			return null;
		}
	}

	public MedOrder updateMedOrderById(int mid,MedOrder medOrder) {
		MedOrderDaoImp daoImp = new MedOrderDaoImp();
		MedOrder medOrder1 = daoImp.updateMedOrderById(mid, medOrder);
		if(medOrder1!=null) {
			return medOrder1;
		}
		else {
			return null;
		}
	}

	public MedOrder getMedOrderByOrderDate(String orderDate) {
		MedOrderDaoImp daoImp = new MedOrderDaoImp();
		MedOrder medOrder1 = daoImp.getMedOrderByOrderDate(orderDate);
		if(medOrder1!=null) {
			return medOrder1;
		}
		else {
			return null;
		}
	}

	public List<MedOrder> getAllMedOrder(){
		MedOrderDaoImp daoImp = new MedOrderDaoImp();
		List<MedOrder> medOrders = daoImp.getAllMedOrder();
		if(medOrders!=null) {
			return medOrders;
		}
		else {
			return null;
		}
	}
}
