package com.HuangXuan.supplierManagementJFrame;

import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.HuangXuan.MysqlDao.Dao.ProductDao;
import com.HuangXuan.MysqlDao.domain.Product;

public class ProductPanel extends JPanel{
	/**从数据库获取的商品数据*/
	ArrayList<Product> products;
	/**商品表单*/
	JTable productTable;
	/**商品表单填充*/
	DefaultTableModel productModel;
	/**JDBC ProductDao*/
	ProductDao productDao = new ProductDao();
	public ProductPanel() {
		//从数据库获取的商品数据
		products = productDao.getAll();
		//设置面板大小
		this.setSize(800,460);
		//初始化productTable
		productModel = new DefaultTableModel();
		//添加首标签
		productModel.setColumnIdentifiers(new Object[]{"商品名称", "商品编号", "商品进价", "商品售价", "生产日期" ,"保质期"});
		for(Product p: products) {
			productModel.addRow(new Object[] {
					p.getProductName(),p.getProductId(),p.getPurchasePrice(),p.getPrice(),p.getDateInProduced(),p.getShelfLife()
			});
		}
		productTable = new JTable(productModel);
		
		//添加表格
		this.add(productTable);
		this.setVisible(true);
	}
}
