package com.ty.hospital.service;

import java.util.List;

import com.ty.hospital.dao.EncounterDao;
import com.ty.hospital.dao.imp.BranchDaoImp;
import com.ty.hospital.dao.imp.EncounterDaoImp;
import com.ty.hospital.dto.Branch;
import com.ty.hospital.dto.Encounter;

public class EncounterService {

	public void saveEncounter(int bid,int id,Encounter encounter) {
		EncounterDaoImp daoImp = new EncounterDaoImp();
		Encounter encounter1 = daoImp.saveEncounter(bid, id, encounter);
		if(encounter1 !=null) {
			System.out.println("Data saved Successfully");
		}
		else {
			System.out.println("Data not Saved");
		}
	}

	public void deleteEncounterById(int eid) {
		EncounterDaoImp daoImp = new EncounterDaoImp();
		boolean encounter = daoImp.deleteEncounterById(eid);
		if(encounter) {
			System.out.println("Deleted successfully");
		}
		else {
			System.out.println("Data not deleted");
		}
	}

	public Encounter getEncounterById(int eid) {
		EncounterDaoImp daoImp = new EncounterDaoImp();
		Encounter encounter = daoImp.getEncounterById(eid);
		if(encounter!=null) {
			return encounter;
		}
		else {
			return null;
		}
	}

	public Encounter updateEncounterById(int eid,Encounter encounter) {
		EncounterDaoImp daoImp = new EncounterDaoImp();
		Encounter encounter1 = daoImp.updateEncounterById(eid, encounter);
		if(encounter1!=null) {
			return encounter1;	
		}
		else {
			return null;	
		}
	}

	public  List<Encounter> getAllEncounter(){
		EncounterDaoImp daoImp = new EncounterDaoImp();
		List<Encounter> encounters =  daoImp.getAllEncounter();
		if(encounters!=null) {
			return encounters;
		}
		else {
			return null;
		}
	}
}
