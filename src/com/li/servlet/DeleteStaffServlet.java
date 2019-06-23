package com.li.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.li.service.StaffsService;
import com.li.service.impl.StaffsServiceImpl;

/**
 * 删除员工信息
 */
public class DeleteStaffServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			int sid = Integer.parseInt(request.getParameter("sid"));
			StaffsService service = new StaffsServiceImpl();
			boolean result = service.deletStaffById(sid);
			
			if(result){
				request.getRequestDispatcher("StaffListSevlet").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("insertresult", "删除失败！在出入库记录中有该员工的记录，请先删除此纪录！");
			request.getRequestDispatcher("StaffListSevlet").forward(request, response);
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
