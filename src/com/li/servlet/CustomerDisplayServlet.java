package com.li.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.li.domain.CustomerBean;
import com.li.service.CustomerService;
import com.li.service.impl.CustomerServiceImpl;

/**
 * 点击修改客户信息按钮时，显示客户信息
 */
public class CustomerDisplayServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			int cid = Integer.parseInt(request.getParameter("cid"));
			
			CustomerService service = new CustomerServiceImpl();
			CustomerBean customer = service.findCustomerById(cid);
			request.setAttribute("customer", customer);
			request.getRequestDispatcher("/jsp/relCustomer.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
