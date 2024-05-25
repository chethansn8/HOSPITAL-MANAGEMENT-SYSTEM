package com.ty.hospital.controller;

import com.ty.hospital.dto.Address;
import com.ty.hospital.dto.Branch;
import com.ty.hospital.service.BranchService;

public class TestSaveBranch {
	public static void main(String[] args) {
		Branch branch = new Branch();
		BranchService branchService = new BranchService();
		branch.setBname("RR Nagar");
		branch.setEmail("apollo@rrnagar.com");
		branch.setPhno(7411408920l);
        
        
        Address address = new Address();
    	address.setStreet("RR NAGAR");
    	address.setPin(560091);
    	address.setState("Karnataka");
    	address.setCountry("India");
    	
    	

    	
    	address.setBranch(branch);
    	branchService.saveBranch(2, branch);
	}
}
