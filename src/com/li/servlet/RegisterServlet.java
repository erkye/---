package com.li.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.li.domain.RegisterBean;
import com.li.service.UserLoginService;
import com.li.service.impl.UserLoginServiceImpl;

/**
 * 处理用户注册
 */
public class RegisterServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			request.setCharacterEncoding("UTF-8");
			Map map = request.getParameterMap();
			RegisterBean bean = new RegisterBean();
			BeanUtils.populate(bean, map);
			
			UserLoginService service = new UserLoginServiceImpl();
			boolean result = service.register(bean);
			if(result){
				response.sendRedirect("html/register_success.html");
			}else{
				response.sendRedirect("html/register_error.html");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
