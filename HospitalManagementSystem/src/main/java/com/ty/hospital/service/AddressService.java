package com.ty.hospital.service;

import java.util.List;

import com.ty.hospital.dao.imp.AddressDaoImp;
import com.ty.hospital.dao.imp.EncounterDaoImp;
import com.ty.hospital.dto.Address;
import com.ty.hospital.dto.Encounter;

public class AddressService {

	public void saveAddress(int bid,Address address) {
		AddressDaoImp addressDaoImp = new AddressDaoImp();
		Address address1 = addressDaoImp.saveAddress(bid, address);
		if(address1!=null) {
			System.out.println("Data saved Successfully");
		}
		else {
			System.out.println("Data not Stored");
		}
	}

	public void deleteAddressById(int aid) {
		AddressDaoImp addressDaoImp = new AddressDaoImp();
		boolean address = addressDaoImp.deleteAddressById(aid);
		if(address) {
			System.out.println("Data deleted successfully");
		}
		else {
			System.out.println("Data note deleted");
		}
	}

	public Address getAddressById(int aid) {
		AddressDaoImp addressDaoImp = new AddressDaoImp();
		Address address = addressDaoImp.getAddressById(aid);
		if(address!=null) {
			return address;
		}
		else {
			return null;
		}
	}

	public Address updateAddressById(int aid,Address address) {
		AddressDaoImp addressDaoImp = new AddressDaoImp();
		Address address1 = addressDaoImp.updateAddressById(aid, address);
		if(address1!=null) {
			return address1;	
		}
		else {
			return null;		
		}
	}

	public  List<Address> getAllAddress(){
		AddressDaoImp addressDaoImp = new AddressDaoImp();
		List<Address> address1 = addressDaoImp.getAllAddress();
		if(address1!=null) {
			return address1;
		}
		else {
			return null;
		}
	}
}
