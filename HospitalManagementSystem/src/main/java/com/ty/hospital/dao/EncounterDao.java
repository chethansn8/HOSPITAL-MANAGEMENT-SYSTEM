package com.ty.hospital.dao;

import java.util.List;

import com.ty.hospital.dto.Encounter;

public interface EncounterDao {
	public Encounter saveEncounter(int bid,int id,Encounter encounter);
	public boolean deleteEncounterById(int eid);
	public Encounter getEncounterById(int eid);
	public Encounter updateEncounterById(int eid,Encounter encounter);
	public List<Encounter> getAllEncounter();
}
