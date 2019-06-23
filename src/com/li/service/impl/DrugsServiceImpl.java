package com.li.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.li.dao.DrugsDao;
import com.li.dao.impl.DrugsDaoImpl;
import com.li.domain.DrugInsertRequestBean;
import com.li.domain.DrugRelRequestBean;
import com.li.domain.DrugsBean;
import com.li.service.DrugsService;

public class DrugsServiceImpl implements DrugsService {

	@Override
	public List<DrugsBean> findAll() throws SQLException {
		DrugsDao dao = new DrugsDaoImpl();
		return dao.findAll();
	}

	@Override
	public List<DrugsBean> fuzzyQuery(String drugname, String drugfactory, String drugposition) throws SQLException {
		return new DrugsDaoImpl().fuzzyQuery(drugname, drugfactory, drugposition);
	}

	@Override
	public boolean insertDrug(DrugInsertRequestBean bean) throws SQLException {
		DrugsDaoImpl dao = new DrugsDaoImpl();
		if(dao.checkDrugName(bean.getDname())){
			return dao.insertDrug(bean);
		}
		return false;
	}

	@Override
	public boolean deleteDrugById(int did) throws SQLException {
		return new DrugsDaoImpl().deleteDrugById(did);
	}

	@Override
	public DrugsBean findDrugById(int did) throws SQLException {
		return new DrugsDaoImpl().findDrugById(did);
	}

	@Override
	public boolean RelDrugByBean(DrugsBean bean) throws SQLException {
		DrugsDao dao = new DrugsDaoImpl();
		if(dao.checkDrugName(bean.getDname(),bean.getDid())){
			return dao.RelDrugByBean(bean);
		}
		return false;
	}

}
