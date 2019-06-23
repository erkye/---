package com.li.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

import com.li.domain.OutHouseTableBean;
import com.li.service.OutHouseService;
import com.li.service.impl.OutHouseServiceImpl;
import com.li.util.MyDateConverter;

/**
 * 处理插入出库记录的请求
 */
public class InsertOutHouseServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		try {
			request.setCharacterEncoding("utf-8");
			//清除上次插入结果
			request.removeAttribute("insertresult");
			//beanutil不能自动转换date类型，注册自己的日期转换器
			ConvertUtils.register(new MyDateConverter(), Date.class);
			Map map = request.getParameterMap();
			OutHouseTableBean bean = new OutHouseTableBean();
			BeanUtils.populate(bean, map);
			
			OutHouseService service = new OutHouseServiceImpl();
			boolean reuslt = service.insertRecord(bean);
			if(reuslt){
				request.getRequestDispatcher("OutHouseListServlet").forward(request, response);
			}else{
				request.setAttribute("insertresult", "添加失败！请重试！");
				request.getRequestDispatcher("/jsp/insertOutRecord.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("insertresult", "添加失败！请重试！");
			request.getRequestDispatcher("/jsp/insertOutRecord.jsp").forward(request, response);
		}
		
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
