package com.li.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.li.domain.InHouseBean;
import com.li.service.InHouseService;
import com.li.service.impl.InHouseServiceImpl;

/**
 * 处理显示入库主界面的请求
 */
public class InHouseListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			InHouseService service = new InHouseServiceImpl();
			List<InHouseBean> inhouselist = service.findAll();
			
			request.setAttribute("inhouselist", inhouselist);
			request.getRequestDispatcher("/jsp/inhouse_list.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
