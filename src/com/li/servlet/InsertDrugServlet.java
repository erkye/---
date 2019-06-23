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

import com.li.domain.DrugInsertRequestBean;
import com.li.service.DrugsService;
import com.li.service.impl.DrugsServiceImpl;
import com.li.util.MyDateConverter;

/**
 * 处理添加药品信息的servlet
 */
public class InsertDrugServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		try {
			request.setCharacterEncoding("utf-8");
			//清除上次插入结果
			request.removeAttribute("insertresult");
			//beanutil不能自动转换date类型，注册自己的日期转换器
			ConvertUtils.register(new MyDateConverter(), Date.class);
			Map map = request.getParameterMap();
			DrugInsertRequestBean bean = new DrugInsertRequestBean();
			BeanUtils.populate(bean, map);
			
			DrugsService service = new DrugsServiceImpl();
			boolean result = service.insertDrug(bean);
			
			if(result){
				request.getRequestDispatcher("DrugsListServlet").forward(request, response);
			}else{
				request.setAttribute("insertresult", "添加失败！该药品名称已在数据库中！");
				request.getRequestDispatcher("/jsp/insertDrug.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
