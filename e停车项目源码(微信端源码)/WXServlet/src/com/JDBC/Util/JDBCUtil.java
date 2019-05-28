package com.JDBC.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	static String url = "jdbc:mysql://localhost:3306/userinformation?serverTimezone=UTC";
	static String urlG = "jdbc:mysql://localhost:3306/garageposition?serverTimezone=UTC";
	static String user = "root";
	static String password = "1234";
	static String driverName = "com.mysql.cj.jdbc.Driver";
	
	static {
		try {
			Class.forName(driverName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnetion() {
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static Connection getConnetionG() {
		try {
			return DriverManager.getConnection(urlG, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void close(Connection con, Statement sta, ResultSet rs) {
		if(con != null) {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(sta != null) {
			try {
				sta.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
