package com.li.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.li.service.CustomerService;
import com.li.service.impl.CustomerServiceImpl;

/**
 * 处理删除客户信息的请求
 */
public class DeleteCustomerServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			int cid = Integer.parseInt(request.getParameter("cid"));
			CustomerService service = new CustomerServiceImpl();
			boolean result = service.deleteCustomer(cid);
			if(result){
			}else{
				request.setAttribute("insertresult", "删除失败！请重试！");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("insertresult", "删除失败！出入库记录中有该客户的记录，请先删除此纪录!");
		}finally {
			request.getRequestDispatcher("CustomerListServlet").forward(request, response);
		}
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
