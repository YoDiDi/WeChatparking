package com.HuangXuan.MysqlDao.domain;

public class Warehouse {
	/**�ֿ�����*/
	private String warehouseName;
	/**�ֿ����Ա*/
	private String admin;
	/**�ֿ����洢��������*/
	private int upperLimit;
	/**�ֿ����洢��������*/
	private int floorLimit;
	/**�ֿ�ʣ��洢����*/
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
