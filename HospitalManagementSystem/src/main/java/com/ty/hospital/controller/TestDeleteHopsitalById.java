package com.ty.hospital.controller;

import com.ty.hospital.dto.Hospital;
import com.ty.hospital.service.HospitalService;

public class TestDeleteHopsitalById {
	public static void main(String[] args) {
		HospitalService hospitalService = new HospitalService();
		boolean h1 = hospitalService.deleteHospital(1);

		System.out.println(h1);
	}
}
