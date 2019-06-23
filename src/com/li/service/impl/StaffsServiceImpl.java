package com.li.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.li.dao.impl.StaffsDaoImpl;
import com.li.domain.StaffBean;
import com.li.service.StaffsService;

public class StaffsServiceImpl implements StaffsService{

	@Override
	public List<StaffBean> findAll() throws SQLException {
		return new StaffsDaoImpl().findAll();
	}

	@Override
	public List<StaffBean> fuzzyQuery(String staffname, String staffsex, String staffjop) throws SQLException {
		return new StaffsDaoImpl().fuzzyQuery(staffname, staffsex, staffjop);
	}

	@Override
	public boolean insertStaff(StaffBean bean) throws SQLException {
		return new StaffsDaoImpl().insertStaff(bean);
	}

	@Override
	public boolean deletStaffById(int sid) throws SQLException {
		return new StaffsDaoImpl().deletStaffById(sid);
	}

	@Override
	public StaffBean findStaffById(int sid) throws SQLException {
		return new StaffsDaoImpl().findStaffById(sid);
	}

	@Override
	public boolean RelStaffByBean(StaffBean bean) throws SQLException {
		return new StaffsDaoImpl().RelStaffByBean(bean);
	}

}
