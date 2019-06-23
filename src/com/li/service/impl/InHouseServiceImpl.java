package com.li.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.li.dao.DrugsDao;
import com.li.dao.InHouseDao;
import com.li.dao.InHouseTableDao;
import com.li.dao.impl.DrugsDaoImpl;
import com.li.dao.impl.InHouseDaoImpl;
import com.li.dao.impl.InHouseTableDaoImpl;
import com.li.domain.DrugsBean;
import com.li.domain.InHouseBean;
import com.li.domain.InHouseTableBean;
import com.li.service.InHouseService;

public class InHouseServiceImpl implements InHouseService {

	@Override
	public List<InHouseBean> findAll() throws SQLException {
		return new InHouseDaoImpl().findAll();
	}

	@Override
	public List<InHouseBean> fazzyQuery(String drugname, String staffname) throws SQLException {
		return new InHouseDaoImpl().fazzyQuery(drugname, staffname);
	}

	@Override
	public boolean insertRecord(InHouseTableBean bean) throws SQLException {
		InHouseTableDao dao1 = new InHouseTableDaoImpl();
		DrugsDao dao2 = new DrugsDaoImpl();
		
		boolean result = dao1.insertRecord(bean);
		if(result){
			return dao2.updateNumsById(bean.getIdid(), bean.getInum());
		}
		return false;
	}

	@Override
	public boolean deleteRecordById(int iid) throws SQLException {
		InHouseDao dao1 = new InHouseDaoImpl();
		InHouseTableDao dao2 = new InHouseTableDaoImpl();
		DrugsDao dao3 = new DrugsDaoImpl();
		
		InHouseBean bean = dao1.findById(iid);
		boolean result = dao2.deleteRecordById(iid);
		if(result){
			return dao3.updateNumsByIdDown(bean.getDid(), bean.getInum());
		}
		
		return false;
	}

	@Override
	public boolean getNumsByiid(int iid) throws SQLException {
		InHouseDao dao1 = new InHouseDaoImpl();
		InHouseBean inhousebean = dao1.findById(iid);
		DrugsDao dao2 = new DrugsDaoImpl();
		DrugsBean drugbean = dao2.findDrugById(inhousebean.getDid());
		if(drugbean.getDnums() >= inhousebean.getInum()){
			return true;
		}
		return false;
	}

	@Override
	public InHouseBean findById(int iid) throws SQLException {
		return new InHouseDaoImpl().findById(iid);
	}

	@Override
	public boolean update(int oldnums, InHouseTableBean bean) throws SQLException {
		int realnums = 0;
		DrugsDao dao1 = new DrugsDaoImpl();
		InHouseTableDao dao2 = new InHouseTableDaoImpl();
		
		boolean result = dao2.update(bean);
		if(result){
			if(oldnums > bean.getInum()){
				realnums = oldnums - bean.getInum();
				return dao1.updateNumsByIdDown(bean.getIdid(), realnums);
			}else if(oldnums < bean.getInum()){
				realnums = bean.getInum() - oldnums;
				return dao1.updateNumsById(bean.getIdid(), realnums);
			}else{
				return result;
			}
		}
		
		
		return false;
	}

}
