package com.ty.hospital.controller;

import com.ty.hospital.dto.Address;
import com.ty.hospital.dto.Branch;
import com.ty.hospital.service.AddressService;

public class TestSaveAddress {
public static void main(String[] args) {
	Address address = new Address();
	AddressService service = new AddressService();
	
	address.setStreet("RR NAGAR");
	address.setPin(560091);
	address.setState("Karnataka");
	address.setCountry("India");
	
	
	Branch branch = new Branch();
	branch.setBname("RR Nagar");
	branch.setEmail("apollo@rrnagar.com");
	branch.setPhno(7411408920l);
	
	address.setBranch(branch);
	service.saveAddress(1, address);
}
}
