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
import com.li.domain.DrugRelRequestBean;
import com.li.domain.DrugsBean;
import com.li.service.DrugsService;
import com.li.service.impl.DrugsServiceImpl;
import com.li.util.MyDateConverter;

/**
 * 
 */
public class RelDrugServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			request.setCharacterEncoding("utf-8");
			//清除上次插入结果
			request.removeAttribute("relresult");
			//beanutil不能自动转换date类型，注册自己的日期转换器
			ConvertUtils.register(new MyDateConverter(), Date.class);
			Map map = request.getParameterMap();
			DrugsBean bean = new DrugsBean();
			BeanUtils.populate(bean, map);
			
			DrugsService service = new DrugsServiceImpl();
			boolean result = service.RelDrugByBean(bean);
			
			if(result){
				request.getRequestDispatcher("DrugsListServlet").forward(request, response);
			}else{
				request.setAttribute("relresult", "修改失败！药品名称重复");
				request.getRequestDispatcher("DrugDisplayServlet?did="+bean.getDid() ).forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
