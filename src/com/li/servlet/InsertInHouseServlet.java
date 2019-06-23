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

import com.li.domain.InHouseTableBean;
import com.li.domain.OutHouseTableBean;
import com.li.service.InHouseService;
import com.li.service.impl.InHouseServiceImpl;
import com.li.util.MyDateConverter;

/**
 * 处理添加入库记录提交上来的信息
 */
public class InsertInHouseServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		try {
			request.setCharacterEncoding("utf-8");
			//清除上次插入结果
			request.removeAttribute("insertresult");
			//beanutil不能自动转换date类型，注册自己的日期转换器
			ConvertUtils.register(new MyDateConverter(), Date.class);
			Map map = request.getParameterMap();
			InHouseTableBean bean = new InHouseTableBean();
			BeanUtils.populate(bean, map);
			
			InHouseService service = new InHouseServiceImpl();
			boolean result = service.insertRecord(bean);
			if(result){
				request.getRequestDispatcher("InHouseListServlet").forward(request, response);
			}else{
				request.setAttribute("insertresult", "添加失败！请重试！");
				request.getRequestDispatcher("/jsp/insertInRecord.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("insertresult", "添加失败！请重试！");
			request.getRequestDispatcher("/jsp/insertInRecord.jsp").forward(request, response);
		}
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
