package com.li.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.li.dao.InHouseTableDao;
import com.li.domain.InHouseTableBean;
import com.li.util.JDBCUtil;

public class InHouseTableDaoImpl implements InHouseTableDao {

	@Override
	public boolean insertRecord(InHouseTableBean bean) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "insert into inhouse value(null,?,?,?,?)";
		int result = runner.update(sql, bean.getIdid(),bean.getIdate(),bean.getInum(),bean.getIhandler());
		if(result > 0){
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteRecordById(int iid) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "delete from inhouse where iid=?";
		int result = runner.update(sql, iid);
		if(result > 0){
			return true;
		}
		return false;
	}

	@Override
	public boolean update(InHouseTableBean bean) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "update inhouse set idate =?,inum=?,ihandler=? where iid=?";
		int result = runner.update(sql,bean.getIdate(),bean.getInum(),bean.getIhandler(),bean.getIid());
		if(result > 0){
			return true;
		}
		return false;
	}

}
