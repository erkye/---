package com.li.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.li.domain.StaffBean;
import com.li.service.StaffsService;
import com.li.service.impl.StaffsServiceImpl;

/**
 * 修改员工信息处理跳转资料修改页面的请求
 */
public class StaffDisplayServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			int sid = Integer.parseInt(request.getParameter("sid"));
			StaffsService service = new StaffsServiceImpl();
			StaffBean staff = service.findStaffById(sid);
			
			request.setAttribute("staff", staff);
			request.getRequestDispatcher("/jsp/relStaff.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
