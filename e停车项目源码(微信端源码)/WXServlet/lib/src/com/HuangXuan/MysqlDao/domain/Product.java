package com.HuangXuan.MysqlDao.domain;

import java.util.Date;

public class Product {
	/**��Ʒid*/
	private String productId;
	/**��Ʒ����*/
	private String productName;
	/**��Ʒ����*/
	private double purchasePrice;
	/**��Ʒ�ۼ�*/
	private double price;
	/**��Ʒ��������*/
	private Date dateInProduced;
	/**��Ʒ������*/
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
