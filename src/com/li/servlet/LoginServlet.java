package com.li.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.li.domain.UserBean;
import com.li.domain.UserResultBean;
import com.li.service.UserLoginService;
import com.li.service.impl.UserLoginServiceImpl;
import com.li.util.CookiesUtil;

/**
 * 处理用户登录的servlet
 */
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		try {
			Map map = request.getParameterMap();
			UserBean user = new UserBean();
			BeanUtils.populate(user, map);//使用beanutil赋值对象
			
			UserLoginService service = new UserLoginServiceImpl();
			List<UserResultBean> UserList = service.login(user);
			if(!UserList.isEmpty()){
				request.getSession().setAttribute("userBean", user);
				Cookie cookie3 = new Cookie("nowuserid", Integer.toString(UserList.get(0).getId()));
				Cookie cookie4 = new Cookie("username", UserList.get(0).getUsername());
				response.addCookie(cookie3);
				response.addCookie(cookie4);
				
				//请求和转发相对路径有 /不能是有forward，这样不会返回客户端，不能使cookies立即生效
				response.sendRedirect("DrugsListServlet");
			}else{
				//重定向相对路径没有 /
				response.sendRedirect("html/login_error.html");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
