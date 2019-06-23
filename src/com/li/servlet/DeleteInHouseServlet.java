package com.li.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.li.service.InHouseService;
import com.li.service.impl.InHouseServiceImpl;

/**
 * 处理入库记录界面删除记录的请求
 */
public class DeleteInHouseServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		try {
			int iid = Integer.parseInt(request.getParameter("iid"));
			InHouseService service = new InHouseServiceImpl();
			boolean result = service.deleteRecordById(iid);
			if(result){
				
			}else{
				request.setAttribute("resulthidden", "删除失败！请重试！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("resulthidden", "删除失败！请重试！");
		}finally {
			request.getRequestDispatcher("InHouseListServlet").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
