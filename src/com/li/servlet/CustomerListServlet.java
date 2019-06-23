package com.li.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.li.domain.CustomerBean;
import com.li.service.CustomerService;
import com.li.service.impl.CustomerServiceImpl;

/**
 * 客户管理主界面的servlet
 */
public class CustomerListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		try {
			CustomerService service = new CustomerServiceImpl();
			List<CustomerBean> customerlist = service.findAll();
			request.setAttribute("customerlist", customerlist);
			request.getRequestDispatcher("/jsp/customer_list.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
