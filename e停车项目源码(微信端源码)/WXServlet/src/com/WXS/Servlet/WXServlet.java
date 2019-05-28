package com.WXS.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.registry.infomodel.User;

import com.JDBC.DAO.GaragePositionDao;
import com.JDBC.DAO.UserInformationDao;
import com.JDBC.DoMain.GaragePosition;
import com.JDBC.DoMain.UserInformation;
import com.google.gson.Gson;

	

public class WXServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*�����������*/
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        /* ������Ӧͷ����ajax������� */
        resp.setHeader("Access-Control-Allow-Origin", "*");
        /* �Ǻű�ʾ���е��������󶼿��Խ��ܣ� */
        resp.setHeader("Access-Control-Allow-Methods", "GET,POST");
        /*���÷���key*/
        String key;
        key = req.getParameter("key");
        UserInformation userInformation = new UserInformation();
		UserInformationDao userInformationDao = new UserInformationDao();
		GaragePosition garagePosition = new GaragePosition();
		GaragePositionDao garagePositionDao = new GaragePositionDao();
		/*��ȡ����Ŀͻ��ǳ�*/
        String nickname = userInformationDao.get(req.getParameter("nickname")).getNickname();
       userInformation.setNickname(nickname);
        /*ͨ��key����ִ�еĺ���*/
        switch (key) {
		case "becomeVip":
			  userInformation.setVIP(Integer.valueOf(req.getParameter("VIP")));
              userInformationDao.upDateVip(userInformation);  
			break;
		case "submitInformation":
			 userInformation.setUserName(req.getParameter("userName"));
             userInformation.setCarID(req.getParameter("carID"));
             userInformationDao.upDateInf(userInformation); 
			break;
		case "getIsEmpty":
			int isEmpty = garagePositionDao.getIsEmpty(req.getParameter("county"),req.getParameter("area"),
					Integer.parseInt(req.getParameter("num")));
			System.out.println(req.getParameter("county") + "|" + req.getParameter("area") + 
					"|" + req.getParameter("num"));
			resp.getWriter().write(isEmpty);
			break;
		case "setIsEmptyAndGetPosition":
			//System.out.println(req.getParameter("nickname"));
			String county = req.getParameter("county");
			String area = req.getParameter("area");
			int num = Integer.parseInt(req.getParameter("num"));
			garagePositionDao.upDateEmpty(1, county, area, num);
			garagePosition = garagePositionDao.getPosition(county, area, num);
			garagePositionDao.updataNickname(req.getParameter("nickname"), county, area, num);
			resp.getWriter().write(garagePosition.getLatitude()+"|"+garagePosition.getLongitude());
			break;
		case "cancelReservation":
			nickname = req.getParameter("nickname");
			garagePositionDao.setEmpty(nickname);
			break;
		default:
			break;
		}
	}
	
	
	
	
	/*
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserInformation userInformation = new UserInformation();
		UserInformationDao userInformationDao = new UserInformationDao();
		
		  //�����������
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        // ������Ӧͷ����ajax������� 
        resp.setHeader("Access-Control-Allow-Origin", "*");
        // �Ǻű�ʾ���е��������󶼿��Խ��ܣ� 
        resp.setHeader("Access-Control-Allow-Methods", "GET,POST");

        //��ȡ΢��С����get�Ĳ���ֵ����ӡ
        System.out.println(req.getParameter("nickname"));
        String nickname = userInformationDao.get(req.getParameter("nickname")).getNickname();
        System.out.println(nickname);
       //�ж��Ƿ�Ϊ���û�
        if(nickname == null) {
        	//��ֹ���������ݣ�ʹ���´��ж�ʱnull==null�����������κ��û���Ϊ���û�
            userInformationDao.dalate();
            System.out.println("��");
            userInformation.setNickname(req.getParameter("nickname"));
            userInformationDao.save(userInformation);
        }else{
        	//��ֹ�������滻���ݿ�����
        		 userInformation.setUserName(req.getParameter("userName"));
                 userInformation.setCarID(req.getParameter("carID"));
                 userInformation.setNickname(req.getParameter("nickname"));
                 userInformation.setVIP(Integer.valueOf(req.getParameter("VIP")));
                 System.out.println("username=" + req.getParameter("userName") + 
                		 "\ncarID=" + req.getParameter("carID") + 
                		 "\nVIP=" + req.getParameter("VIP"));
                 
                 userInformationDao.upDate(userInformation);     
        }
	}
*/


protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	UserInformation userInformation = new UserInformation();
	UserInformationDao userInformationDao = new UserInformationDao();
	GaragePositionDao garagePositionDao = new GaragePositionDao();
	//resp.getWriter().write("connect servlet");
	  //�����������
    req.setCharacterEncoding("utf-8");
    resp.setContentType("text/html;charset=utf-8");
    /* ������Ӧͷ����ajax������� */
    resp.setHeader("Access-Control-Allow-Origin", "*");
    /* �Ǻű�ʾ���е��������󶼿��Խ��ܣ� */
    resp.setHeader("Access-Control-Allow-Methods", "GET,POST");

    //��ȡ΢��С����get�Ĳ���ֵ����ӡ
    System.out.println(req.getParameter("nickname"));
    String nickname = userInformationDao.get(req.getParameter("nickname")).getNickname();
    System.out.println(nickname);
   //�ж��Ƿ�Ϊ���û�
    if(nickname == null) {
    	//��ֹ���������ݣ�ʹ���´��ж�ʱnull==null�����������κ��û���Ϊ���û�
        userInformationDao.dalate();
        System.out.println("��");
        userInformation.setNickname(req.getParameter("nickname"));
        //��#Ϊkey�ж����û��Ƿ���������Ϣ��δ����Ϊ#
        userInformation.setCarID("#");
        userInformation.setUserName("#");
        userInformationDao.save(userInformation);
        resp.getWriter().write(userInformation.getNickname() + "|" + 
		    	userInformation.getUserName() + "|" + 
		    	userInformation.getCarID() + "|" + 
		    	userInformation.isVIP());
    }else{
    	userInformation = userInformationDao.get(nickname);
    	String position = garagePositionDao.getPosition(nickname);
    	if(userInformation.getCarID()!="#") {
    		resp.getWriter().write(userInformation.getNickname() + "|" + 
    		    	userInformation.getUserName() + "|" + 
    		    	userInformation.getCarID() + "|" + 
    		    	userInformation.isVIP() + "|" + position);
    	}
    	
    }
}
}
	

