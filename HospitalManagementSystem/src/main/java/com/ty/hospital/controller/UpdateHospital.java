package com.ty.hospital.controller;

import com.ty.hospital.dto.Hospital;
import com.ty.hospital.service.HospitalService;

public class UpdateHospital {
public static void main(String[] args) {
	Hospital hospital = new Hospital();
	HospitalService hospitalService = new HospitalService();
	
	hospital.setHname("Apollo");
	hospital.setWebsite("www.apollo.com");
	hospitalService.updateHospitalById(2, hospital);

}
}
