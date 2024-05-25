package com.ty.hospital.service;

import java.util.List;

import com.ty.hospital.dao.imp.ItemDaoImp;
import com.ty.hospital.dto.Item;

public class ItemService {
 public void saveItem(int mid,Item item) {
	 ItemDaoImp daoImp = new ItemDaoImp();
	 Item item1 = daoImp.saveItem(mid,item);
	 if(item1!=null) {
		 System.out.println("Data Saved Successfully");
	 }
	 else {
		 System.out.println("Data not saved");
	 }
 }
 
 public void deleteItemById(int iId,Item item) {
	 ItemDaoImp daoImp = new ItemDaoImp();
	 boolean item1 = daoImp.deleteItemById(iId);
	 if(item1) {
		 System.out.println("Deleted successfully");
	 }
	 else {
		 System.out.println("Data not deleted");
	 }
 }
 
 public Item getItemById(int iId) {
	 ItemDaoImp daoImp = new ItemDaoImp();
	 Item item1 = daoImp.getItemById(iId);
	 if(item1!=null) {
		 return item1;
	 }
	 else {
		 return null;
	 }
 }
 
 public Item getItemByMedOrder(int mid) {
	 ItemDaoImp daoImp = new ItemDaoImp();
	 Item item1 = daoImp.getItemByMedOrder(mid);
	 if(item1!=null) {
		 return item1;
	 }
	 else {
		 return null;
	 }
 }
 
 public List<Item> getAllItems(){
	 ItemDaoImp daoImp = new ItemDaoImp();
	 List<Item> item1 = daoImp.getAllItem();
	 if(item1!=null) {
		 return item1;
	 }
	 else {
		 return null;
	 }
 }
 
 
}
