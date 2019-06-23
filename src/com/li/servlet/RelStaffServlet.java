package com.li.servlet;

import java.io.IOException;
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
 * 处理修改员工信息提交的请求
 */
public class RelStaffServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		try {
			request.setCharacterEncoding("utf-8");
			request.removeAttribute("relresult");
			Map map = request.getParameterMap();
			StaffBean bean = new StaffBean();
			BeanUtils.populate(bean, map);
			
			StaffsService service = new StaffsServiceImpl();
			boolean result = service.RelStaffByBean(bean);
			if(result){
				request.getRequestDispatcher("StaffListSevlet").forward(request, response);
			}else{
				request.setAttribute("relresult", "修改失败！请重试");
				request.getRequestDispatcher("StaffDisplayServlet?sid="+bean.getSid() ).forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
