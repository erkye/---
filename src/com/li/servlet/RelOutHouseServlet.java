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
 * 处理修改出库记录提交上来的信息
 */
public class RelOutHouseServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		OutHouseTableBean bean = null;
		try {
			request.setCharacterEncoding("utf-8");
			int oldnums = Integer.parseInt(request.getParameter("oldnums"));
			//清除上次插入结果
			request.removeAttribute("insertresult");
			//beanutil不能自动转换date类型，注册自己的日期转换器
			ConvertUtils.register(new MyDateConverter(), Date.class);
			Map map = request.getParameterMap();
			bean = new OutHouseTableBean();
			BeanUtils.populate(bean, map);

			OutHouseService service = new OutHouseServiceImpl();
			boolean result = service.update(oldnums, bean);
			if(result){
				request.getRequestDispatcher("OutHouseListServlet").forward(request, response);
			}else{
				request.setAttribute("insertresult", "修改失败！请检查后重试！");
				request.getRequestDispatcher("RelOutHouseDisplayServlet?oid="+bean.getOid()).forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("insertresult", "修改失败！请检查后重试！");
			request.getRequestDispatcher("RelOutHouseDisplayServlet?oid="+bean.getOid()).forward(request, response);
		}
	
	
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
