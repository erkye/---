package com.li.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.li.domain.DrugsBean;
import com.li.service.InHouseService;
import com.li.service.impl.InHouseServiceImpl;

/**
 * 处理入库记录界面通过iid查看该药品最大的库存量的ajax请求
 */
public class GetMaxNumsByiidServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		try {
			int iid = Integer.parseInt(request.getParameter("iid"));
			InHouseService service = new InHouseServiceImpl();
			boolean result = service.getNumsByiid(iid);
			if(result){
				response.getWriter().println(1);
			}else{
				response.getWriter().println(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println(0);
		}
		
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
