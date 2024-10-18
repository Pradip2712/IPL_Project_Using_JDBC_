package com.pdp.service;

import java.util.ArrayList; 
import java.util.HashSet; 
import java.util.List;
import java.util.Set;

import com.pdp.dao.Dao;
import com.pdp.entity.Player;

public class Service {

	Dao d = new Dao();
	List<Player> lop = null;

//	check the player is present or not 
	public String insertPlayer(int pjrno, String pname, int run, int wicket, String tname) {
		int count = 0;
		String res = null;
		lop = d.getAllData();
		for (Player player : lop) {

			if (player.getName().equalsIgnoreCase(pname)) {
				count++;
			}
		}
		if (count == 0) {
			res = d.insertInfo(pjrno, pname, run, wicket, tname);
		} else {
			res = "Player Already Exist in table : ";
		}

		return res;
	}

//	get all data and sort them to send caller method only team names
	public Set<String> getAllTname() {
		lop = d.getAllData();
		Set<String> tn = new HashSet<String>();
		for (Player player : lop) {

			tn.add(player.getTname().toUpperCase());

		}

		return tn;
	}

	
//	get all and sort team wise and send to caller method 
	public Set<String> getPlayerNames(String tname) {
		lop = d.getAllData();
		Set<String> lopn = new HashSet<String>();
		for (Player player : lop) {
			if (player.getTname().equalsIgnoreCase(tname)) {
				lopn.add(player.getName());
			}
		}

		return lopn;
	}

	
	// get all information and send to caller method
	public List<Player> getAllPlaInfo() {
		lop = d.getAllData();
		return lop;
	}
	
	
//	short all bat'sMan in the table
	List<Player> loab=null;
	public List<Player> getAllBatsMan() {
		lop = d.getAllData();
		loab=new ArrayList<Player>();
		for (Player player : lop) {
			if(player.getRun() > 10000 && player.getWicket() < 50)
			{
				loab.add(player);
			}
		}
		
		
		return loab;
	}
	
	
//	short all boller in the database
	List<Player> loaboller=null;
	public List<Player> getAllBoller() {
		lop=d.getAllData();
		loaboller=new ArrayList<Player>();
		for (Player player : lop) {
			if(player.getRun() < 5000 && player.getWicket() > 100)
			{
				loaboller.add(player);
			}
		}
		return loaboller;
	}
	
//	sort all All-Rounders 
	List<Player> loaar=null;
	public List<Player> getAllRounder() {
		lop=d.getAllData();
		loaar=new ArrayList<Player>();
		for (Player player : lop) {
			if(player.getRun() > 5000 && player.getWicket() > 50 )
			{
				loaar.add(player);
			}
		}
		return loaar;
	}
	

	
//	check the player is exist or not in database
//	update jersey no
	public String updatePlaJrno(String pname, int ujn) {
		int count = 0;
		String res = null;
		lop = d.getAllData();
		for (Player player : lop) {
			if (player.getName().equalsIgnoreCase(pname)) {
				res = d.updateJrno(pname, ujn);
				count++;
			}
		}
		if (count == 0) {
			res = "Player not found in database : ";
		}

		return res;
	}

	
//	check the player is exist or not in the database
//	update run
	public String updateRun(String pname, int run) {
		int count = 0;
		String res = null;
		lop = d.getAllData();
		for (Player player : lop) {
			if (player.getName().equalsIgnoreCase(pname)) {
				res = d.updateRun(pname, run);
				count++;
			}
		}
		if (count == 0) {
			res = "Player not found in database : ";
		}

		return res;
	}

	
//	check the player is exist or not in the database
//	update wickets
	public String updateWicket(String pname, int wicket) {
		int count = 0;
		String res = null;
		lop = d.getAllData();
		for (Player player : lop) {
			if (player.getName().equalsIgnoreCase(pname)) {
				res = d.updateWicket(pname, wicket);
				count++;
			}
		}
		if (count == 0) {
			res = "Player not found in database : ";
		}
		return res;
	}

	
//	check the player is exist or not in the database
//	update player team name 
	public String updateTname(String pname, String tname) {
		int count = 0;
		String res = null;
		lop = d.getAllData();
		for (Player player : lop) {
			if (player.getName().equalsIgnoreCase(pname)) {
				res = d.updateTname(pname, tname);
				count++;
			}
		}

		if (count == 0) {
			res = "Player not found in database : ";
		}
		return res;
	}

	
//	update all data
	public String updateInfo(String pname, int ujn, String un, int ur, int uw, String utn) {
		String res = null;
		int count = 0;
		lop = d.getAllData();
		for (Player player : lop) {
			if (player.getName().equalsIgnoreCase(pname)) {
				res = d.updateInfo(pname, ujn, un, ur, uw, utn);
				count++;
			}
		}
		if (count == 0) {
			res = "Player not found in database : ";
		}
		return res;
	}

//	check the player is present or not 
//	 if player is present to delete this player
	public String deletePlaInfo(String pname) {
		int count = 0;
		String res = null;
		lop = d.getAllData();
		for (Player player : lop) {

			if (player.getName().equalsIgnoreCase(pname)) {
				res = d.deletePlaInfo(pname);
				count++;
			}
		}
		if (count == 0) {
			res = "Player not found in database..\nPlease enter valid player name : ";
		}
		return res;
	}

	




}
