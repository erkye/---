package com.li.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.li.domain.UserResultBean;
import com.li.service.UserLoginService;
import com.li.service.impl.UserLoginServiceImpl;
import com.li.util.CookiesUtil;

/**
 * 系统主界面处理用户点击查看个人资料的请求
 */
public class SeeUserDataServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			//获取当前登录用户的id
			Cookie[] cookies = request.getCookies();
			Cookie findCookie = CookiesUtil.findCookie(cookies, "nowuserid");
			int userid = Integer.parseInt(findCookie.getValue());
			
			UserLoginService service = new UserLoginServiceImpl();
			UserResultBean uerData = service.seeUerData(userid);
			
			request.setAttribute("userData", uerData);
			request.getRequestDispatcher("/jsp/see_userdata.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
