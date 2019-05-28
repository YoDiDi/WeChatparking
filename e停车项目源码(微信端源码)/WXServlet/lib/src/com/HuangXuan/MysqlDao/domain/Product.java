package com.HuangXuan.MysqlDao.domain;

import java.util.Date;

public class Product {
	/**商品id*/
	private String productId;
	/**商品名称*/
	private String productName;
	/**商品进价*/
	private double purchasePrice;
	/**商品售价*/
	private double price;
	/**商品生产日期*/
	private Date dateInProduced;
	/**商品保质期*/
	private Date shelfLife;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getDateInProduced() {
		return dateInProduced;
	}
	public void setDateInProduced(Date dateInProduced) {
		this.dateInProduced = dateInProduced;
	}
	public Date getShelfLife() {
		return shelfLife;
	}
	public void setShelfLife(Date shelfLife) {
		this.shelfLife = shelfLife;
	}
	
}
