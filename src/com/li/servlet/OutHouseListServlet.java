package com.li.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.li.domain.OutHouseBean;
import com.li.service.OutHouseService;
import com.li.service.impl.OutHouseServiceImpl;

/**
 * 显示出库记录列表
 */
public class OutHouseListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			OutHouseService service = new OutHouseServiceImpl();
			List<OutHouseBean> outhouselist = service.findAll();
			request.setAttribute("outhouselist", outhouselist);
			
			request.getRequestDispatcher("/jsp/outhouse_list.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
