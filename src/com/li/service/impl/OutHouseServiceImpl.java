package com.li.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.li.dao.DrugsDao;
import com.li.dao.OutHouseDao;
import com.li.dao.OutHouseTableDao;
import com.li.dao.impl.DrugsDaoImpl;
import com.li.dao.impl.OutHouseDaoImpl;
import com.li.dao.impl.OutHouseTableDaoImpl;
import com.li.domain.OutHouseBean;
import com.li.domain.OutHouseTableBean;
import com.li.service.OutHouseService;

public class OutHouseServiceImpl implements OutHouseService {

	@Override
	public List<OutHouseBean> findAll() throws SQLException {
		return new OutHouseDaoImpl().findAll();
	}

	@Override
	public List<OutHouseBean> fuzzyQuery(String drugname, String customername, String staffname) throws SQLException {
		return new OutHouseDaoImpl().fuzzyQuery(drugname, customername, staffname);
	}

	@Override
	public boolean insertRecord(OutHouseTableBean bean) throws SQLException {
		DrugsDao dao1 = new DrugsDaoImpl();
		OutHouseTableDao dao2 = new OutHouseTableDaoImpl();
		
		if(dao2.insertRecord(bean)){
			return dao1.insertOuthouse(bean);
		}
		return false;
	}

	@Override
	public boolean deleteRecordById(int oid) throws SQLException {
		OutHouseTableDao housetabledao = new OutHouseTableDaoImpl();
		//找到该记录
		OutHouseTableBean outhousebean = housetabledao.findRecordById(oid);
		//删除记录
		boolean result = housetabledao.deleteRecord(oid);
		if(result){
			//删除成功，修改库存量
			DrugsDao drugdao = new DrugsDaoImpl();
			return drugdao.updateNumsById(outhousebean.getOdid(), outhousebean.getOnum());
		}
		
		return false;
	}

	@Override
	public OutHouseBean findRecordById(int oid) throws SQLException {
		return new OutHouseDaoImpl().findRecordById(oid);
	}

	@Override
	public boolean update(int oldnums, OutHouseTableBean bean) throws SQLException {
		OutHouseTableDao dao1 = new OutHouseTableDaoImpl();
		DrugsDao dao2 = new DrugsDaoImpl();
		
		int realnums = 0;//需要更改的值
		boolean result = dao1.update(bean);
		if(result){
			if(oldnums > bean.getOnum()){
				realnums = oldnums - bean.getOnum();
				return dao2.updateNumsById(bean.getOdid(), realnums);
			}else if(oldnums < bean.getOnum()){
				realnums = bean.getOnum() - oldnums;
				return dao2.updateNumsByIdDown(bean.getOdid(), realnums);
			}else{
				return result;
			}
		}
		return false;
	}

	
}
