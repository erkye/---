package com.li.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.li.domain.CustomerBean;
import com.li.domain.DrugsBean;
import com.li.domain.OutHouseBean;
import com.li.domain.StaffBean;
import com.li.service.CustomerService;
import com.li.service.DrugsService;
import com.li.service.OutHouseService;
import com.li.service.StaffsService;
import com.li.service.impl.CustomerServiceImpl;
import com.li.service.impl.DrugsServiceImpl;
import com.li.service.impl.OutHouseServiceImpl;
import com.li.service.impl.StaffsServiceImpl;

/**
 * 处理出库信息页面点击修改的请求，显示修改界面
 */
public class RelOutHouseDisplayServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			//获得当前点击的记录id
			int oid = Integer.parseInt(request.getParameter("oid"));
			OutHouseService service4 = new OutHouseServiceImpl();
			OutHouseBean oldbean = service4.findRecordById(oid);
			
			
			//写入页面的基本信息
			DrugsService service1 = new DrugsServiceImpl();
			List<DrugsBean> druglist = service1.findAll();
			CustomerService service2 = new CustomerServiceImpl();
			List<CustomerBean> customerlist = service2.findAll();
			StaffsService service3 = new StaffsServiceImpl();
			List<StaffBean> stafflist = service3.findAll();
			
			request.setAttribute("oldbean", oldbean);
			request.setAttribute("druglist", druglist);
			request.setAttribute("customerlist", customerlist);
			request.setAttribute("stafflist", stafflist);
			
			
			
			//页面跳转
			request.getRequestDispatcher("/jsp/relOutRecord.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
