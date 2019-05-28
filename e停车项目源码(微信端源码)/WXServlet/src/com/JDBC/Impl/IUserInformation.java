package com.JDBC.Impl;

	import java.util.List;

	import com.JDBC.DoMain.*;;

	public interface IUserInformation {
		//插入数据
		public void save(UserInformation userInformation);
		//删除数据
		public void dalate();
		//更新数据
		public void upDateVip(UserInformation userInformation);
		//获取指定数据
		public UserInformation get(String name);
		//获取所有数据
		public List<UserInformation> getAll();
		public void upDateInf(UserInformation userInformation);
	}

