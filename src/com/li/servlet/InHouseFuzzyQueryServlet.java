package com.li.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.li.domain.InHouseBean;
import com.li.service.InHouseService;
import com.li.service.impl.InHouseServiceImpl;

/**
 * 处理入库记录界面的模糊查询请求
 */
public class InHouseFuzzyQueryServlet extends HttpServlet implements Servlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		try {
			request.setCharacterEncoding("utf-8");
			String drugname = request.getParameter("drugname");
			String staffname = request.getParameter("staffname");
			InHouseService service = new InHouseServiceImpl();
			List<InHouseBean> inhouselist = service.fazzyQuery(drugname, staffname);
			
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
