package com.li.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.li.dao.OutHouseTableDao;
import com.li.domain.OutHouseTableBean;
import com.li.util.JDBCUtil;

public class OutHouseTableDaoImpl implements OutHouseTableDao {

	@Override
	public boolean insertRecord(OutHouseTableBean bean) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "insert into outhouse value(null,?,?,?,?,?)";
		int result = runner.update(sql, bean.getOdid(),bean.getOnum(),bean.getOdate(),bean.getOcid(),bean.getOhandler());
		if(result > 0){
			return true;
		}
		return false;
	}

	@Override
	public OutHouseTableBean findRecordById(int oid) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "select * from outhouse where oid = ?";
		return runner.query(sql, new BeanHandler<OutHouseTableBean>(OutHouseTableBean.class),oid);

	}

	@Override
	public boolean deleteRecord(int oid) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "delete from outhouse where oid = ?";
		int result = runner.update(sql, oid);
		if(result > 0){
			return true;
		}
		return false;
	}

	@Override
	public boolean update(OutHouseTableBean bean) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "update outhouse set onum = ?,odate=?,ocid=?,ohandler=? where oid =?";
		int result = runner.update(sql,bean.getOnum(),bean.getOdate(),bean.getOcid(),bean.getOhandler(),bean.getOid());
		if(result > 0){
			return true;
		}
		return false;
	}

}
