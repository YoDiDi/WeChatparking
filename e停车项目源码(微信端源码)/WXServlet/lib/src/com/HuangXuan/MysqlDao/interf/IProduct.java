package com.HuangXuan.MysqlDao.interf;

import java.util.ArrayList;

import com.HuangXuan.MysqlDao.domain.Product;

public interface IProduct {
	/**
	 * 函数名称:getAll();
	 * 返回值:ArrayList;
	 * 参数:无
	 * 功能:获取数据库所有商品信息;
	 */
	public ArrayList getAll();
}
