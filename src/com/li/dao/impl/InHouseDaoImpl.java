package com.li.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.li.dao.InHouseDao;
import com.li.domain.InHouseBean;
import com.li.domain.OutHouseBean;
import com.li.util.CommUtil;
import com.li.util.JDBCUtil;

public class InHouseDaoImpl implements InHouseDao {

	@Override
	public List<InHouseBean> findAll() throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "select * from inrecord";
		return runner.query(sql, new BeanListHandler<InHouseBean>(InHouseBean.class));
	}

	@Override
	public List<InHouseBean> fazzyQuery(String drugname, String staffname) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql ="SELECT * FROM inrecord where 1=1";
		List<String> list = new ArrayList<String>();

		if (!CommUtil.isEmpty(drugname)) {
			sql = sql + " and dname like ?";
			list.add("%" + drugname + "%");
		}
		if (!CommUtil.isEmpty(staffname)) {
			sql = sql + " and sname like ?";
			list.add("%" + staffname + "%");
		}

		return runner.query(sql, new BeanListHandler<InHouseBean>(InHouseBean.class), list.toArray());	}

	@Override
	public InHouseBean findById(int iid) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "SELECT * FROM inrecord where iid =?";
		return runner.query(sql, new BeanHandler<InHouseBean>(InHouseBean.class),iid);
	}

}
