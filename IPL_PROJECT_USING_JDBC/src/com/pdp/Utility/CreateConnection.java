package com.pdp.Utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class CreateConnection {

//	It is use for creating a connection with mysql database
	public static Connection createConnection() {
		String path = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/iplproject";
		String uname = "root";
		String pass = "Root";

		Connection conn = null;

		try {
			Class.forName(path);
			conn = DriverManager.getConnection(url, uname, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
