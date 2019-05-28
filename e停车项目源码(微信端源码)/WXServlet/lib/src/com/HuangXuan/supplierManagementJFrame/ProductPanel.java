package com.HuangXuan.supplierManagementJFrame;

import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.HuangXuan.MysqlDao.Dao.ProductDao;
import com.HuangXuan.MysqlDao.domain.Product;

public class ProductPanel extends JPanel{
	/**�����ݿ��ȡ����Ʒ����*/
	ArrayList<Product> products;
	/**��Ʒ��*/
	JTable productTable;
	/**��Ʒ�����*/
	DefaultTableModel productModel;
	/**JDBC ProductDao*/
	ProductDao productDao = new ProductDao();
	public ProductPanel() {
		//�����ݿ��ȡ����Ʒ����
		products = productDao.getAll();
		//��������С
		this.setSize(800,460);
		//��ʼ��productTable
		productModel = new DefaultTableModel();
		//����ױ�ǩ
		productModel.setColumnIdentifiers(new Object[]{"��Ʒ����", "��Ʒ���", "��Ʒ����", "��Ʒ�ۼ�", "��������" ,"������"});
		for(Product p: products) {
			productModel.addRow(new Object[] {
					p.getProductName(),p.getProductId(),p.getPurchasePrice(),p.getPrice(),p.getDateInProduced(),p.getShelfLife()
			});
		}
		productTable = new JTable(productModel);
		
		//��ӱ��
		this.add(productTable);
		this.setVisible(true);
	}
}
