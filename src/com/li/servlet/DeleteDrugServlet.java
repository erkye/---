package com.li.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.li.service.DrugsService;
import com.li.service.impl.DrugsServiceImpl;

/**
 * 处理删除药品的请求
 */
public class DeleteDrugServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			int did = Integer.parseInt(request.getParameter("did"));
			DrugsService service = new DrugsServiceImpl();
			boolean result = service.deleteDrugById(did);
			
			if(result){
				request.getRequestDispatcher("DrugsListServlet").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("insertresult", "删除失败！在出入库记录中该药品的记录，请先删除记录！");
			request.getRequestDispatcher("DrugsListServlet").forward(request, response);
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
