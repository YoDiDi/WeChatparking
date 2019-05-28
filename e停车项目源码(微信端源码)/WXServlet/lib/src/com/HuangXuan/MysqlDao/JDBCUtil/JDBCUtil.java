package com.HuangXuan.MysqlDao.JDBCUtil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	static String url = "jdbc:mysql://localhost:3306/Supermarket-management-system?serverTimezone=UTC";
	static String use = "root";
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
			return DriverManager.getConnection(url, use, password);
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