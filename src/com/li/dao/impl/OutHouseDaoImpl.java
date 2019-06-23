package com.li.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.li.dao.OutHouseDao;
import com.li.domain.DrugsBean;
import com.li.domain.OutHouseBean;
import com.li.util.CommUtil;
import com.li.util.JDBCUtil;

public class OutHouseDaoImpl implements OutHouseDao {

	@Override
	public List<OutHouseBean> findAll() throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "SELECT * FROM outrecord";
		return runner.query(sql, new BeanListHandler<OutHouseBean>(OutHouseBean.class));
	}

	@Override
	public List<OutHouseBean> fuzzyQuery(String drugname, String customername, String staffname) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql ="SELECT * FROM outrecord where 1=1";
		List<String> list = new ArrayList<String>();

		if (!CommUtil.isEmpty(drugname)) {
			sql = sql + " and dname like ?";
			list.add("%" + drugname + "%");
		}
		if (!CommUtil.isEmpty(customername)) {
			sql = sql + " and cname like ?";
			list.add("%" + customername + "%");
		}
		if (!CommUtil.isEmpty(staffname)) {
			sql = sql + " and sname like ?";
			list.add("%" + staffname + "%");
		}

		return runner.query(sql, new BeanListHandler<OutHouseBean>(OutHouseBean.class), list.toArray());
	}

	@Override
	public OutHouseBean findRecordById(int oid) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "select * from outrecord where oid=?";
		return runner.query(sql, new BeanHandler<OutHouseBean>(OutHouseBean.class),oid);
	}

}
