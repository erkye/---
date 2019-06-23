package com.li.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.li.service.UserLoginService;
import com.li.service.impl.UserLoginServiceImpl;

/**
 * 用户注册时，完成ajax用户名验证的功能
 */
public class checkUserNameServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			request.setCharacterEncoding("utf-8");
			String username = request.getParameter("username");
			UserLoginService service = new UserLoginServiceImpl();
			boolean result = service.checkUserName(username);
			//true:表示 用户名可以使用 false:表示用户名不可用
			if(result){
				//可用
				response.getWriter().println(1);;
			}else{
				//不可用
				response.getWriter().println(0);;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
