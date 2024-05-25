package com.ty.hospital.dao;

import java.util.List;

import com.ty.hospital.dto.MedOrder;

public interface MedOrderDao {
	public MedOrder saveMedOrder(int eid,MedOrder medOrder);
	public boolean deleteMedOrderById(int mid);
	public MedOrder getMedOrderById(int mid);
	public MedOrder updateMedOrderById(int mid,MedOrder medOrder);
	public List<MedOrder> getAllMedOrder();
	public MedOrder getMedOrderByDname(String dname);
	public MedOrder getMedOrderByOrderDate(String orderDate);
}
