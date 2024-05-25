package com.ty.hospital.service;


import com.ty.hospital.dao.imp.HospitalDaoImp;
import com.ty.hospital.dto.Hospital;

public class HospitalService {

	public void saveHospital(Hospital hospital) {
		HospitalDaoImp  daoImp = new HospitalDaoImp();
		Hospital hospital1 = daoImp.saveHospital(hospital);
		if(hospital1!=null) {
			System.out.println("Data Saved Successfully");
		}
		else {
			System.out.println("Data Not Saved");
		}
	}

	public boolean deleteHospital(int hId) {
		HospitalDaoImp daoImp = new HospitalDaoImp();
		boolean hospital = daoImp.deleteHospitalById(hId);
		if(hospital!=false) {
			return true;
		}
		else {
			return false;
		}
	}

	public Hospital getHospitalByID(int hId) {
		HospitalDaoImp daoImp = new HospitalDaoImp();
		Hospital hospital1 = daoImp.getHospitalById(hId);
		if(hospital1!=null) {
			System.out.println("Hid:"+hospital1.gethId());
			System.out.println("Hospital name:"+hospital1.getHname());
			System.out.println("website:"+hospital1.getWebsite());
			return hospital1;
		}
		else {
			return null;
		}
	}

	public Hospital updateHospitalById(int hid,Hospital hospital) {
		HospitalDaoImp daoImp = new HospitalDaoImp();
		Hospital hospital1 = daoImp.updateHospitalById(hid, hospital);
		if(hospital1!=null) {
			return hospital1;
		}
		else {
			return null;
		}
	}
}
