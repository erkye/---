package com.li.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.li.domain.DrugsBean;
import com.li.service.DrugsService;
import com.li.service.impl.DrugsServiceImpl;

/**
 * 药品信息界面的模糊查询
 */
public class DrugFuzzyQueryServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			request.setCharacterEncoding("utf-8");
			//获取查询的药品名称，生产厂家，存放位置
			String drugname = request.getParameter("drugname");
			String drugfactory = request.getParameter("drugfactory");
			String drugposition = request.getParameter("drugposition");
			DrugsService service = new DrugsServiceImpl();
			List<DrugsBean> drugslist = service.fuzzyQuery(drugname, drugfactory, drugposition);
			
			request.setAttribute("drugslist", drugslist);
			
			request.getRequestDispatcher("/jsp/drugs_list.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
