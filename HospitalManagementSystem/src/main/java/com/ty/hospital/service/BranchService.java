package com.ty.hospital.service;

import java.util.List;

import com.ty.hospital.dao.BranchDao;
import com.ty.hospital.dao.imp.BranchDaoImp;
import com.ty.hospital.dto.Branch;

public class BranchService {

	public void saveBranch(int hId,Branch branch) {
		BranchDaoImp branchDaoImp = new BranchDaoImp();
		Branch branch1 = branchDaoImp.saveBranch(hId, branch);
		if(branch1!=null) {
			System.out.println("Data Saved Successfully");
		}
		else {
			System.out.println("Data not Saved");
		}
	}

	public void deleteBranchByID(int bid) {
		BranchDaoImp branchDaoImp = new BranchDaoImp();
		boolean branch = branchDaoImp.deleteBranchById(bid);
		if(branch) {
			System.out.println("Deleted Successfully");
		}
		else {
			System.out.println("Data not Deleted");
		}
	}

	public Branch getBranchById(int bid) {
		BranchDaoImp branchDaoImp = new BranchDaoImp();
		Branch branch1 = branchDaoImp.getBranchById(bid);
		if(branch1!=null) {
			return branch1;
		}
		else {
			return null;
		}
	}

	public Branch updateBranchById(int bid,Branch branch) {
		BranchDaoImp branchDaoImp = new BranchDaoImp();
		Branch branch1 = branchDaoImp.updateBranchById(bid, branch);
		if(branch1!=null) {
			return branch1;
		}
		else {
			return null;		}
	}	

	public  List<Branch> getAllBranch(){
		BranchDaoImp branchDaoImp = new BranchDaoImp();
		List<Branch> branch1 = branchDaoImp.getAllBranch();
		if(branch1!=null) {
			return branch1;
		}
		else {
			return null;
		}
	}

}
