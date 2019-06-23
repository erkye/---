package com.li.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.li.dao.impl.CustomerDaoImpl;
import com.li.domain.CustomerBean;
import com.li.service.CustomerService;
import com.li.service.impl.CustomerServiceImpl;

/**
 * 客户信息的模糊查询
 */
public class CustomerFuzzyQueryServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		try {
			request.setCharacterEncoding("utf-8");
			String cname = request.getParameter("customername");
			CustomerService service = new CustomerServiceImpl();
			List<CustomerBean> customerlist = service.fuzzyQuery(cname);
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
