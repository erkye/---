package com.li.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.li.domain.DrugsBean;
import com.li.service.DrugsService;
import com.li.service.UserLoginService;
import com.li.service.impl.DrugsServiceImpl;
import com.li.service.impl.UserLoginServiceImpl;

/**
 * 查看所有的药品信息
 */
public class DrugsListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			DrugsService service = new DrugsServiceImpl();
			List<DrugsBean> drugslist = service.findAll();
			request.setAttribute("drugslist", drugslist);
			
			request.getRequestDispatcher("/jsp/drugs_list.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
