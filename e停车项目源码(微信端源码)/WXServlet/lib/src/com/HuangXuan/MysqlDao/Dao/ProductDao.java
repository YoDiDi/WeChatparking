package com.HuangXuan.MysqlDao.Dao;

import java.sql.*;
import java.util.ArrayList;

import com.HuangXuan.MysqlDao.JDBCUtil.JDBCUtil;
import com.HuangXuan.MysqlDao.domain.Product;
import com.HuangXuan.MysqlDao.interf.IProduct;

public class ProductDao implements IProduct{

	@Override
	public ArrayList getAll() {
		Connection con = null;
		PreparedStatement pSta = null;
		ResultSet rs = null;
		ArrayList<Product> products = new ArrayList<>();
		Product product = new Product();
		try {
			con = JDBCUtil.getConnetion();
			String sql = "select * from product";
			pSta = con.prepareStatement(sql);
			rs = pSta.executeQuery();
			while(rs.next()){
				if(rs.next()) {
					product.setPrice(rs.getDouble("price"));
					product.setDateInProduced(rs.getDate("dateInProduced"));
					product.setProductId(rs.getString("productId"));
					product.setProductName(rs.getString("productName"));
					product.setPurchasePrice(rs.getDouble("purchasePrice"));
					product.setShelfLife(rs.getDate("shelfLife"));
					products.add(product);
				}
			}
			return products;	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, pSta, rs);
		}
		
		return null;
	}

}
