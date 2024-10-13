package com.pdp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pdp.entity.Player;

public class Dao {

	String path = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/iplproject";
	String uname = "root";
	String pass = "Root";

	Connection conn;

//	It is use for creating a connection with mysql database
	public Connection createConn() {
		try {
			Class.forName(path);
			conn = DriverManager.getConnection(url, uname, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	
//	insertInfo method for inserting data into table
	public String insertInfo(int pjrno, String pname, int run, int wicket, String tname) {
		String res = null;
		try {
			Connection conn = createConn();
			String query = "INSERT INTO player (jrno,name,run,wicket,tname) VALUES (?,?,?,?,?)";
			PreparedStatement ps = conn.prepareCall(query);

			ps.setInt(1, pjrno);
			ps.setString(2, pname);
			ps.setInt(3, run);
			ps.setInt(4, wicket);
			ps.setString(5, tname);

			ps.executeUpdate();
			res = "Insert data successfully...";

		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;
	}

	
	// getAllData method for Getting the all data from table
	public List<Player> getAllData() {
		List<Player> lop = new ArrayList<Player>();
		try {


			Connection conn = createConn();
			String query = "Select * from player";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet res = ps.executeQuery();

			while (res.next()) {
				int jn = res.getInt("jrno");
				String n = res.getString("name");
				int r = res.getInt("run");
				int w = res.getInt("wicket");
				String tn = res.getString("tname");

				Player p = new Player(jn, n, r, w, tn);

				lop.add(p);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lop;
	}

	
//	update the jersey no
	public String updateJrno(String pname, int ujn) {
		String res = null;
		Connection conn = createConn();
		String query = "UPDATE player set jrno=? WHERE name=?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, ujn);
			ps.setString(2, pname);

			ps.executeUpdate();

			res = "Jersey number updated successfully...";
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}

	
//	update run
	public String updateRun(String pname, int run) {
		String res = null;

		Connection conn = createConn();
		String query = "UPDATE player SET run=? WHERE name=?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, run);
			ps.setString(2, pname);

			ps.executeUpdate();
			res = "Player Runs updated successfully...";

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}

	
//	update the wickets
	public String updateWicket(String pname, int wicket) {
		String res = null;
		Connection conn = createConn();
		String query = "UPDATE player SET run=? WHERE name=?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, wicket);
			ps.setString(2, pname);

			ps.executeUpdate();
			res = "Player Wicket's Updated successfully...";

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}

	
//	update player team
	public String updateTname(String pname, String tname) {
		String res = null;
		Connection conn = createConn();
		String query = "UPDATE player SET tname=? WHERE name=?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, tname);
			ps.setString(2, pname);

			ps.executeUpdate();
			res = "Player Team name Updated successfully...";

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	
//	update all info
	public String updateInfo(String pname, int ujn, String un, int ur, int uw, String utn) {
		String res = null;
		Connection conn = createConn();
		String query = "UPDATE player SET jrno=?,name=?,run=?,wicket=?,tname=? WHERE name=?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, ujn);
			ps.setString(2, un);
			ps.setInt(3, ur);
			ps.setInt(4, uw);
			ps.setString(5, utn);
			ps.setString(6, pname);

			ps.executeUpdate();

			res = "Player Info Updated successfully...";

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}

	
	// delete method
	public String deletePlaInfo(String pname) {

		String res = null;
		Connection conn = createConn();
		String query = "DELETE FROM player WHERE name=?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, pname);
			ps.executeUpdate();

			res = "Player information deleted successfully...";

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}

}
