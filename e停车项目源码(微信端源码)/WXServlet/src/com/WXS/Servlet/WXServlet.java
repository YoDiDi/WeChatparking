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
		/*设置请求编码*/
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        /* 设置响应头允许ajax跨域访问 */
        resp.setHeader("Access-Control-Allow-Origin", "*");
        /* 星号表示所有的异域请求都可以接受， */
        resp.setHeader("Access-Control-Allow-Methods", "GET,POST");
        /*设置访问key*/
        String key;
        key = req.getParameter("key");
        UserInformation userInformation = new UserInformation();
		UserInformationDao userInformationDao = new UserInformationDao();
		GaragePosition garagePosition = new GaragePosition();
		GaragePositionDao garagePositionDao = new GaragePositionDao();
		/*获取传入的客户昵称*/
        String nickname = userInformationDao.get(req.getParameter("nickname")).getNickname();
       userInformation.setNickname(nickname);
        /*通过key决定执行的函数*/
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
		
		  //设置请求编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        // 设置响应头允许ajax跨域访问 
        resp.setHeader("Access-Control-Allow-Origin", "*");
        // 星号表示所有的异域请求都可以接受， 
        resp.setHeader("Access-Control-Allow-Methods", "GET,POST");

        //获取微信小程序get的参数值并打印
        System.out.println(req.getParameter("nickname"));
        String nickname = userInformationDao.get(req.getParameter("nickname")).getNickname();
        System.out.println(nickname);
       //判断是否为老用户
        if(nickname == null) {
        	//防止误插入空内容，使得下次判定时null==null成立，误判任何用户都为老用户
            userInformationDao.dalate();
            System.out.println("无");
            userInformation.setNickname(req.getParameter("nickname"));
            userInformationDao.save(userInformation);
        }else{
        	//防止空数据替换数据库内容
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
	  //设置请求编码
    req.setCharacterEncoding("utf-8");
    resp.setContentType("text/html;charset=utf-8");
    /* 设置响应头允许ajax跨域访问 */
    resp.setHeader("Access-Control-Allow-Origin", "*");
    /* 星号表示所有的异域请求都可以接受， */
    resp.setHeader("Access-Control-Allow-Methods", "GET,POST");

    //获取微信小程序get的参数值并打印
    System.out.println(req.getParameter("nickname"));
    String nickname = userInformationDao.get(req.getParameter("nickname")).getNickname();
    System.out.println(nickname);
   //判断是否为老用户
    if(nickname == null) {
    	//防止误插入空内容，使得下次判定时null==null成立，误判任何用户都为老用户
        userInformationDao.dalate();
        System.out.println("无");
        userInformation.setNickname(req.getParameter("nickname"));
        //以#为key判断老用户是否完善了信息，未完善为#
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
	

