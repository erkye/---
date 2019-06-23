package com.li.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.li.domain.StaffBean;
import com.li.service.StaffsService;
import com.li.service.impl.StaffsServiceImpl;

/**
 * 员工信息模糊查询
 */
public class StaffFuzzyQueryServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			request.setCharacterEncoding("utf-8");
			String staffname = request.getParameter("staffname");
			String staffsex = request.getParameter("staffsex");
			String staffjop = request.getParameter("staffjop");
			StaffsService service = new StaffsServiceImpl();
			List<StaffBean> stafflist = service.fuzzyQuery(staffname, staffsex, staffjop);
			
			request.setAttribute("stafflist", stafflist);
			request.getRequestDispatcher("/jsp/staff_list.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
