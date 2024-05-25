package com.ty.hospital.dao;

import com.ty.hospital.dto.Hospital;

public interface HospitalDao {
	public Hospital saveHospital(Hospital hospital);
	public boolean deleteHospitalById(int hId);
	public Hospital getHospitalById(int hId );
	public Hospital updateHospitalById(int hId,Hospital hospital);
}
