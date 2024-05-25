package com.ty.hospital.service;

import java.util.List;

import com.ty.hospital.dao.imp.AddressDaoImp;
import com.ty.hospital.dao.imp.ObservationDaoImp;
import com.ty.hospital.dto.Address;
import com.ty.hospital.dto.Observation;

public class ObservationService {
	public void saveObservation(int eid,Observation  observation) {
		ObservationDaoImp daoImp = new ObservationDaoImp();
		Observation observation1 = daoImp.saveObservation(eid, observation);
		if(observation1!=null) {
			System.out.println("Data saved Successfully");
		}
		else {
			System.out.println("Data not stored");
		}
	}

	public void deleteObservationById(int oid) {
		ObservationDaoImp daoImp = new ObservationDaoImp();
		boolean observation1 = daoImp.deleteObservationById(oid);
		if(observation1) {
			System.out.println("Data Deleted Successfully");
		}
		else {
			System.out.println("Data not deleted");
		}
	}

	public Observation getObservationById(int oid) {
		ObservationDaoImp daoImp = new ObservationDaoImp();
		Observation observation1 = daoImp.getObservationById(oid);
		if(observation1!=null) {
			return observation1;
		}
		else {
			return null;
		}
	}

	public Observation getObservationByDname(String dname) {
		ObservationDaoImp daoImp = new ObservationDaoImp();
		Observation observation1 = daoImp.getObservationByDname(dname);
		if(observation1!=null) {
			return observation1;
		}
		else {
			return null;
		}
	}

	public Observation updateObservationById(int oid,Observation observation) {
		ObservationDaoImp daoImp = new ObservationDaoImp();
		Observation observation1 = daoImp.updateObservationById(oid, observation) ;
		if(observation1!=null) {
			return observation1;
		}
		else {
			return null;
		}
	}

	public  List<Observation> getAllObservation(){
		ObservationDaoImp daoImp = new ObservationDaoImp();
		List<Observation> observation1 = daoImp.getAllObservation();
		if(observation1!=null) {
			return observation1;
		}
		else {
			return null;
		}
	}

}
