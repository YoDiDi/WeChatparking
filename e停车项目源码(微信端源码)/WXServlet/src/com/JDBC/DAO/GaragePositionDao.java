package com.JDBC.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.JDBC.DoMain.GaragePosition;
import com.JDBC.Impl.IGaragePosition;
import com.JDBC.Util.JDBCUtil;

public class GaragePositionDao implements IGaragePosition{

	@Override
	public GaragePosition get(String county, String area, int num) {
		Connection con = null;
		PreparedStatement pSta = null;
		
		try {
			con = JDBCUtil.getConnetionG();
			String sql = "select count(1) from garagePosition where county=? && isEmpty=0";
			pSta = con.prepareStatement(sql);
			//pSta.setInt(1, );
			//pSta.setString(2, );
			pSta.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, pSta, null);
		}
		
		return null;
	}

	public int getIsEmpty(String county,String area, int num) {
		Connection con = null;
		PreparedStatement pSta = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConnetionG();
			String sql = "select isEmpty from garagePosition where county=? && area=? && num=?";
			pSta = con.prepareStatement(sql);
			pSta.setString(1, county);
			pSta.setString(2, area);
			pSta.setInt(3, num);
			rs = pSta.executeQuery();
			while(rs.next())
			return rs.getInt("isEmpty");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, pSta, null);
		}
		
		return 0;
	}
	
	public GaragePosition getPosition(String county,String area, int num){
		GaragePosition garagePosition = new GaragePosition();
		Connection con = null;
		PreparedStatement pSta = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConnetionG();
			String sql = "select * from garagePosition where county=? && area=? && num=?";
			pSta = con.prepareStatement(sql);
			pSta.setString(1, county);
			pSta.setString(2, area);
			pSta.setInt(3, num);
			rs = pSta.executeQuery();
			while(rs.next()) {
				garagePosition.setLatitude(rs.getDouble("latitude"));
				garagePosition.setLongitude(rs.getDouble("longitude"));
				return garagePosition;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, pSta, null);
		
		}
		return null;
		
	}
	
	public void updataNickname(String nickname,String county,String area, int num) {
		Connection con = null;
		PreparedStatement pSta = null;
		try {
			con = JDBCUtil.getConnetionG();
			String sql = "Update garagePosition set nickname=? where county=? && area=? && num=?";
			pSta = con.prepareStatement(sql);
			pSta.setString(1, nickname);
			pSta.setString(2, county);
			pSta.setString(3, area);
			pSta.setInt(4, num);
			pSta.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, pSta, null);
		}
	}
	
	public String getPosition(String nickname) {
		GaragePosition garagePosition = new GaragePosition();
		Connection con = null;
		PreparedStatement pSta = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConnetionG();
			String sql = "select * from garagePosition where nickname=?";
			pSta = con.prepareStatement(sql);
			pSta.setString(1, nickname);
			rs = pSta.executeQuery();
			while(rs.next()) {
				return rs.getString("county") + "|" + rs.getString("area") + "|" + rs.getInt("num");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, pSta, null);
		
		}
		return null;
		
	}
	
	public void setEmpty(String nickname) {
		Connection con = null;
		PreparedStatement pSta = null;
		try {
			con = JDBCUtil.getConnetionG();
			String sql = "Update garagePosition set isEmpty=0,nickname=null where nickname=?";
			pSta = con.prepareStatement(sql);
			pSta.setString(1, nickname);
			pSta.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, pSta, null);
		}
		
	}
	
	@Override
	public void upDateEmpty(int isEmpty, String county, String area, int num) {
		Connection con = null;
		PreparedStatement pSta = null;
		try {
			con = JDBCUtil.getConnetionG();
			String sql = "Update garagePosition set isEmpty=? where county=? && area=? && num=?";
			pSta = con.prepareStatement(sql);
			pSta.setInt(1, isEmpty);
			pSta.setString(2, county);
			pSta.setString(3, area);
			pSta.setInt(4, num);
			pSta.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, pSta, null);
		}
		
	}

}
