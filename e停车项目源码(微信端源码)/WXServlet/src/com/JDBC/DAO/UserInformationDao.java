package com.JDBC.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

import com.JDBC.DoMain.UserInformation;
import com.JDBC.Impl.IUserInformation;
import com.JDBC.Util.JDBCUtil;

public class UserInformationDao implements IUserInformation{

	@Override
	public void save(UserInformation userInformation) {
		Connection con= null;
		PreparedStatement pSta = null;
		try {
			con = JDBCUtil.getConnetion();
			String sql = "insert into userinformation(VIP,userName,ID,money,carID,enterTime,outTime,nickname) values (?,?,?,?,?,?,?,?)";
			pSta = con.prepareStatement(sql);
			pSta.setInt(1, userInformation.isVIP());
			pSta.setString(2,userInformation.getUserName());
			pSta.setInt(3, userInformation.getID());
			pSta.setDouble(4, userInformation.getMoney());
			pSta.setString(5, userInformation.getCarID());
			pSta.setDate(6, userInformation.getEnterTime());
			pSta.setDate(7, userInformation.getOutTime());
			pSta.setString(8, userInformation.getNickname());
			pSta.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(con, pSta, null);
		}
	}
		
	

	@Override
	public void dalate() {
		Connection con = null;
		PreparedStatement pSta = null;
		try {
			con = JDBCUtil.getConnetion();
			String sql = "delete from userinformation where nickname=null";
			pSta = con.prepareStatement(sql);
			pSta.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(con, pSta, null);
		}
		
	}

	@Override
	public void upDateVip(UserInformation userInformation) {
		Connection con = null;
		PreparedStatement pSta = null;
		try {
			con = JDBCUtil.getConnetion();
			String sql = "Update userinformation set VIP=? where nickname=?";
			pSta = con.prepareStatement(sql);
			/*pSta.setString(1, userInformation.getCarID());
			pSta.setString(2, userInformation.getUserName());
			pSta.setString(4, userInformation.getNickname());*/
			pSta.setInt(1, userInformation.isVIP());
			pSta.setString(2, userInformation.getNickname());
			pSta.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, pSta, null);
		}
		
	}
	
	@Override
	public void upDateInf(UserInformation userInformation) {
		Connection con = null;
		PreparedStatement pSta = null;
		try {
			con = JDBCUtil.getConnetion();
			String sql = "Update userinformation set carID=?,userName=? where nickname=?";
			pSta = con.prepareStatement(sql);
			pSta.setString(1, userInformation.getCarID());
			pSta.setString(2, userInformation.getUserName());
			pSta.setString(3, userInformation.getNickname());
			//pSta.setInt(3, userInformation.isVIP());
			pSta.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, pSta, null);
		}
		
	}

	@Override
	public UserInformation get(String name) {
		
		Connection con = null;
		PreparedStatement pSta = null;
		ResultSet rs = null;
		UserInformation userInformation = new UserInformation();
		try {
			con = JDBCUtil.getConnetion();
			String sql = "select * from userinformation where nickname=?";
			pSta = con.prepareStatement(sql);
			pSta.setString(1, name);
			rs = pSta.executeQuery();
			if(rs.next()) {
				userInformation.setCarID(rs.getString("carID"));
				userInformation.setUserName(rs.getString("username"));
				userInformation.setNickname(rs.getString("nickname"));
				userInformation.setVIP(rs.getInt("VIP"));
			}
			return userInformation;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, pSta, rs);
		}
		return null;
	}

	@Override
	public List<UserInformation> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
