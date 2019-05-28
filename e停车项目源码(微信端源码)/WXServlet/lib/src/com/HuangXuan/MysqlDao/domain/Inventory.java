package com.HuangXuan.MysqlDao.domain;

public class Inventory {
	/**商品id*/
	private String productId;
	/**商品入库时间*/
	private String enterTime;
	/**商品出库时间*/
	private String exitTime;
	/**商品所在仓库*/
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
