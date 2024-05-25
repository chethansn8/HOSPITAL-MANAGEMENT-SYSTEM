package com.ty.hospital.dao;

import java.util.List;

import com.ty.hospital.dto.Item;

public interface ItemDao {
	public Item saveItem(int mid,Item item);
	public boolean deleteItemById(int iId);
	public Item getItemById(int iId);
//	public Item updateItemById(int iId,Item item);
	public List<Item> getAllItem();
	public Item getItemByMedOrder(int mid);
} 
