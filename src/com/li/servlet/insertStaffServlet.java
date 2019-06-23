package com.li.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;


import com.li.domain.StaffBean;
import com.li.service.StaffsService;
import com.li.service.impl.StaffsServiceImpl;


/**
 * 处理插入员工的servlet
 */
public class insertStaffServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			request.setCharacterEncoding("utf-8");
			//清除上次插入结果
			request.removeAttribute("insertresult");
			Map map = request.getParameterMap();
			StaffBean bean = new StaffBean();
			BeanUtils.populate(bean, map);
			
			StaffsService service = new StaffsServiceImpl();
			boolean result = service.insertStaff(bean);
			
			if(result){
				request.getRequestDispatcher("StaffListSevlet").forward(request, response);
			}else{
				request.setAttribute("insertresult", "添加失败!");
				request.getRequestDispatcher("/jsp/insertStaff.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
