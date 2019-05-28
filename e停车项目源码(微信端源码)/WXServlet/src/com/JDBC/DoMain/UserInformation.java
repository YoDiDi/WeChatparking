package com.JDBC.DoMain;

import java.util.Date;

public class UserInformation {
    private int VIP = 0;
    private String userName;
    private int ID;
	private double money;
    private String carID;
    private java.sql.Date enterTime;
    private java.sql.Date outTime;
    private String nickname;
	public int isVIP() {
		return VIP;
	}
	public void setVIP(int vIP) {
		VIP = vIP;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	 public int getID() {
		return ID;
	}
	public void setID(int ID) {
		this.ID = ID;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getCarID() {
		return carID;
	}
	public void setCarID(String carID) {
		this.carID = carID;
	}
	public java.sql.Date getEnterTime() {
		return enterTime;
	}
	public void setEnterTime(java.sql.Date enterTime) {
		this.enterTime = enterTime;
	}
	public java.sql.Date getOutTime() {
		return outTime;
	}
	public void setOutTime(java.sql.Date outTime) {
		this.outTime = outTime;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
}
