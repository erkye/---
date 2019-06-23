package com.li.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.li.domain.StaffBean;
import com.li.service.StaffsService;
import com.li.service.impl.StaffsServiceImpl;

/**
 * 显示员工列表的servlet
 */
public class StaffListSevlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			StaffsService service = new StaffsServiceImpl();
			List<StaffBean> stafflist = service.findAll();
			
			request.setAttribute("stafflist", stafflist);
			request.getRequestDispatcher("/jsp/staff_list.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
