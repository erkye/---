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
 * 点击修改，显示药品的详细信息
 */
public class DrugDisplayServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			int did = Integer.parseInt(request.getParameter("did"));
			DrugsService service = new DrugsServiceImpl();
			DrugsBean drug = service.findDrugById(did);
			
			request.setAttribute("drug", drug);
			request.getRequestDispatcher("/jsp/relDrug.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
