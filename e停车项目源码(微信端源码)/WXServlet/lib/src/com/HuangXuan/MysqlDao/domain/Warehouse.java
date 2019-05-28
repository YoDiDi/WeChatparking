package com.HuangXuan.MysqlDao.domain;

public class Warehouse {
	/**仓库名称*/
	private String warehouseName;
	/**仓库管理员*/
	private String admin;
	/**仓库货物存储数量上限*/
	private int upperLimit;
	/**仓库货物存储数量下限*/
	private int floorLimit;
	/**仓库剩余存储数量*/
	private int surpluNum;
	public String getWarehouseName() {
		return warehouseName;
	}
	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public int getUpperLimit() {
		return upperLimit;
	}
	public void setUpperLimit(int upperLimit) {
		this.upperLimit = upperLimit;
	}
	public int getFloorLimit() {
		return floorLimit;
	}
	public void setFloorLimit(int floorLimit) {
		this.floorLimit = floorLimit;
	}
	public int getSurpluNum() {
		return surpluNum;
	}
	public void setSurpluNum(int surpluNum) {
		this.surpluNum = surpluNum;
	}
}
