package com.ty.hospital.controller;

import com.ty.hospital.dto.Hospital;
import com.ty.hospital.service.HospitalService;

public class TestGetHopitalById {
	public static void main(String[] args) {
		
		HospitalService   service = new HospitalService();
		Hospital hospital1 =  service.getHospitalByID(2);
         System.out.println(hospital1);
		
	}
}
