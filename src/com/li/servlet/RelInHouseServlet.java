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
import com.li.service.OutHouseService;
import com.li.service.impl.InHouseServiceImpl;
import com.li.service.impl.OutHouseServiceImpl;
import com.li.util.MyDateConverter;

/**
 * 
 */
public class RelInHouseServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InHouseTableBean bean = null;
		try {
			request.setCharacterEncoding("utf-8");
			int oldnums = Integer.parseInt(request.getParameter("oldnums"));
			request.removeAttribute("insertresult");
			ConvertUtils.register(new MyDateConverter(), Date.class);
			Map map = request.getParameterMap();
			bean = new InHouseTableBean();
			BeanUtils.populate(bean, map);

			InHouseService service = new InHouseServiceImpl();
			boolean result = service.update(oldnums, bean);
			
			if(result){
				request.getRequestDispatcher("InHouseListServlet").forward(request, response);
			}else{
				request.setAttribute("insertresult", "修改失败！请检查后重试！");
				request.getRequestDispatcher("RelInHouseDisplayServlet?iid="+bean.getIid()).forward(request, response);
			}
			}catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("insertresult", "修改失败！请检查后重试！");
				request.getRequestDispatcher("RelInHouseDisplayServlet?iid="+bean.getIid()).forward(request, response);
			}
	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
