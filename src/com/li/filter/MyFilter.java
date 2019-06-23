package com.li.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.li.domain.UserBean;
import com.li.service.UserLoginService;
import com.li.service.impl.UserLoginServiceImpl;
import com.li.util.CookiesUtil;

public class MyFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		try {
			HttpServletRequest request = (HttpServletRequest) req;
			HttpServletResponse response = (HttpServletResponse) res;
			UserBean userbean = (UserBean) request.getSession().getAttribute("userBean");
			String url = request.getRequestURI();//  /Drugsmanagement/html/login_in.html
			String path = request.getContextPath();// /Drugsmanagement
			int begin =  url.indexOf("/",2);
		    int end = url.lastIndexOf("/");

		    String requpath = null;
		    
		    if(begin == end){
		    	requpath = "";
		    }else{
		    	 requpath =url.substring(begin+1,end);
		    }
		    String laststr = url.substring(end+1);
			if ("html".equals(requpath)||"LoginServlet".equals(requpath)||"".equals(requpath)||"css".equals(requpath)||"img".equals(requpath)||"register.jsp".equals(laststr)) {
				//对访问登录界面的不拦截
				chain.doFilter(request, response);
			} else {
				//访问其他界面
				if (userbean != null) {
					//说明会话还未失效，不拦截
					chain.doFilter(request, response);
				} else {
					//会话失效
					Cookie[] cookies = request.getCookies();
					Cookie findCookie = CookiesUtil.findCookie(cookies, "username");

					if (findCookie != null) {
						String name = findCookie.getValue();
						UserLoginService service = new UserLoginServiceImpl();
						boolean result = service.checkUserName(name);
						
						if(!result){
							//有该用户名,不拦截，否则拦截
							chain.doFilter(request, response);
						}
					}
					System.out.println("拦截了一次请求");
				}
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
