package com.li.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.li.dao.StaffsDao;
import com.li.domain.DrugsBean;
import com.li.domain.StaffBean;
import com.li.util.CommUtil;
import com.li.util.JDBCUtil;

public class StaffsDaoImpl implements StaffsDao {

	@Override
	public List<StaffBean> findAll() throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "select * from staff";
		return runner.query(sql, new BeanListHandler<StaffBean>(StaffBean.class));
	}

	@Override
	public List<StaffBean> fuzzyQuery(String staffname, String staffsex, String staffjop) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "select * from staff where 1=1";
		List<String> list = new ArrayList<String>();

		if (!CommUtil.isEmpty(staffname)) {
			sql = sql + " and sname like ?";
			list.add("%" + staffname + "%");
		}
		if (!CommUtil.isEmpty(staffsex)) {
			sql = sql + " and ssex = ?";
			list.add(staffsex);
		}
		if (!CommUtil.isEmpty(staffjop)) {
			sql = sql + " and sjob = ?";
			list.add(staffjop);
		}

		return runner.query(sql, new BeanListHandler<StaffBean>(StaffBean.class), list.toArray());
	}

	@Override
	public boolean insertStaff(StaffBean bean) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "insert into staff value(null,?,?,?,?,?)";
		int result = runner.update(sql,
				bean.getSname(),
				bean.getSsex(),
				bean.getSage(),
				bean.getSeducation(),
				bean.getSjob()
				);
		if(result > 0){
			return true;
		}
		return false;
	}

	@Override
	public boolean deletStaffById(int sid) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "delete from staff where sid =?";
		int result = runner.update(sql,sid);
		if(result > 0){
			return true;
		}
		return false;
	}

	@Override
	public StaffBean findStaffById(int sid) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "select * from staff where sid =?";
		return runner.query(sql, new BeanHandler<StaffBean>(StaffBean.class),sid);
	}

	@Override
	public boolean RelStaffByBean(StaffBean bean) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "update staff set sname = ? ,ssex = ?, sage = ? ,seducation =?,sjob = ? where sid=?";
		int result = runner.update(sql,
				bean.getSname(),
				bean.getSsex(),
				bean.getSage(),
				bean.getSeducation(),
				bean.getSjob(),
				bean.getSid()
				);
		if(result > 0){
			return true;
		}
		return false;
	}

}
