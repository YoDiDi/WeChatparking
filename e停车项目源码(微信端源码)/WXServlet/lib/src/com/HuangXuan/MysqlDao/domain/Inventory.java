package com.HuangXuan.MysqlDao.domain;

public class Inventory {
	/**��Ʒid*/
	private String productId;
	/**��Ʒ���ʱ��*/
	private String enterTime;
	/**��Ʒ����ʱ��*/
	private String exitTime;
	/**��Ʒ���ڲֿ�*/
	private String warehouse;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getEnterTime() {
		return enterTime;
	}
	public void setEnterTime(String enterTime) {
		this.enterTime = enterTime;
	}
	public String getExitTime() {
		return exitTime;
	}
	public void setExitTime(String exitTime) {
		this.exitTime = exitTime;
	}
	public String getWarehouse() {
		return warehouse;
	}
	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}
}
