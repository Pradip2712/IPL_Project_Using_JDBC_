package com.pdp.controll;

import java.util.List; 
import java.util.Set;

import com.pdp.entity.Player;
import com.pdp.service.Service;

public class Controll {

	Service s = new Service();

//	player insert into database
	public String insertPla(int pjrno, String pname, int run, int wicket, String tname) {
		String res = s.insertPlayer(pjrno, pname, run, wicket, tname);
		return res;
	}

	
//	get all teams in the data
	public Set<String> getAllTname() {
		Set<String> at = s.getAllTname();
		return at;
	}

	
//	get players team wise
	public Set<String> getPlayerName(String tname) {
		Set<String> pn = s.getPlayerNames(tname);
		return pn;
	}

	
//	get all players information
	public List<Player> getAllPlaInfo() {
		List<Player> lop = s.getAllPlaInfo();
		return lop;
	}

	
//	List of all batsman
	public List<Player> getAllBatsMan() {
		List<Player> lop=s.getAllBatsMan();
		return lop;
	}
	
//	list of all boller
	public List<Player> getAllBoller() {
		List<Player> lop=s.getAllBoller();
		return lop;
	}
	
//	list of all All-Rounders

	public List<Player> getAllRounder() {
		List<Player> loaar=s.getAllRounder();
		return loaar;
	}
	
	
	
//	update jersey no
	public String updatePlaJrno(String pname, int ujn) {
		String res = s.updatePlaJrno(pname, ujn);
		return res;
	}

	
//	update run of player
	public String updateRun(String pname, int run) {
		String res = s.updateRun(pname, run);
		return res;
	}

	
//	update wicket of player
	public String updateWicket(String pname, int wicket) {
		String res = s.updateWicket(pname, wicket);
		return res;
	}

	
//	update player team 
	public String updateTname(String pname, String tname) {
		String res = s.updateTname(pname, tname);
		return res;
	}

	
//	update all info
	public String updateInfo(String pname, int ujn, String un, int ur, int uw, String utn) {
		String res = s.updateInfo(pname, ujn, un, ur, uw, utn);
		return res;
	}

	
//	delete player into database
	public String deletePlaInfo(String pname) {
		String res = s.deletePlaInfo(pname);
		return res;
	}







	

}