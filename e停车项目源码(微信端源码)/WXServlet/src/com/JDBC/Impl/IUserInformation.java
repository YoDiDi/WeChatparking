package com.JDBC.Impl;

	import java.util.List;

	import com.JDBC.DoMain.*;;

	public interface IUserInformation {
		//��������
		public void save(UserInformation userInformation);
		//ɾ������
		public void dalate();
		//��������
		public void upDateVip(UserInformation userInformation);
		//��ȡָ������
		public UserInformation get(String name);
		//��ȡ��������
		public List<UserInformation> getAll();
		public void upDateInf(UserInformation userInformation);
	}

