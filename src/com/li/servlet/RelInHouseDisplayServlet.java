package com.li.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.li.domain.DrugsBean;
import com.li.domain.InHouseBean;
import com.li.domain.StaffBean;
import com.li.service.DrugsService;
import com.li.service.InHouseService;
import com.li.service.StaffsService;
import com.li.service.impl.DrugsServiceImpl;
import com.li.service.impl.InHouseServiceImpl;
import com.li.service.impl.StaffsServiceImpl;

/**
 * 处理入库记录界面修改请求
 */
public class RelInHouseDisplayServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			//获得当前点击的记录id
			int iid = Integer.parseInt(request.getParameter("iid"));
			InHouseService service = new InHouseServiceImpl();
			InHouseBean oldbean = service.findById(iid);
			
			DrugsService service2 = new DrugsServiceImpl();
			List<DrugsBean> druglist = service2.findAll();
			StaffsService service3 = new StaffsServiceImpl();
			List<StaffBean> stafflist = service3.findAll();
			request.setAttribute("druglist", druglist);
			request.setAttribute("stafflist", stafflist);
			request.setAttribute("oldbean", oldbean);
			
			
			request.getRequestDispatcher("/jsp/relInRecord.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
