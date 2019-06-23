package com.li.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.li.domain.DrugsBean;
import com.li.service.DrugsService;
import com.li.service.impl.DrugsServiceImpl;

/**
 * 处理用户添加出库记录时ajax请求最库存量
 */
public class GetDrugsMaxNumsServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			int did = Integer.parseInt(request.getParameter("did"));
			DrugsService service = new DrugsServiceImpl();
			DrugsBean drug = service.findDrugById(did);
			if(drug != null){
				response.getWriter().println(drug.getDnums());
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
