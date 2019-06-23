package com.li.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.li.domain.CustomerBean;
import com.li.service.CustomerService;
import com.li.service.impl.CustomerServiceImpl;

/**
 * 处理插入客户信息的请求
 */
public class InsertCustomerServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			request.setCharacterEncoding("utf-8");
			Map map = request.getParameterMap();
			CustomerBean bean = new CustomerBean();
			BeanUtils.populate(bean, map);
			
			CustomerService service = new CustomerServiceImpl();
			boolean result = service.insertCustomer(bean);
			if(result){
				request.getRequestDispatcher("CustomerListServlet").forward(request, response);
			}else{
				request.setAttribute("insertresult", "添加客户失败！请检查后重新尝试！");
				request.getRequestDispatcher("/jsp/insertCustomer.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("insertresult", "添加客户失败！请检查后重新尝试！");
			request.getRequestDispatcher("/jsp/insertCustomer.jsp").forward(request, response);
		}
		
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
