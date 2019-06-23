package com.li.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.li.service.OutHouseService;
import com.li.service.impl.OutHouseServiceImpl;

/**
 * 处理删除出库记录的请求（删除+恢复药品表库存量）
 */
public class DeleteOutHouseServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		try {
			int oid = Integer.parseInt(request.getParameter("oid"));
			OutHouseService service = new OutHouseServiceImpl();
			boolean result = service.deleteRecordById(oid);
			
			if(result){
				
			}else{
				request.setAttribute("resulthidden", "删除失败！请重试！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("resulthidden", "删除失败！请重试！");
		}finally {
			request.getRequestDispatcher("OutHouseListServlet").forward(request, response);
		}
		
	
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
