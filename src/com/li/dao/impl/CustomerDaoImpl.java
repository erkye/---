package com.li.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.li.dao.CustomerDao;
import com.li.domain.CustomerBean;
import com.li.domain.DrugsBean;
import com.li.util.CommUtil;
import com.li.util.JDBCUtil;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public List<CustomerBean> findAll() throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "select * from customer";
		return runner.query(sql, new BeanListHandler<CustomerBean>(CustomerBean.class));
	}

	@Override
	public List<CustomerBean> fuzzyQuery(String cname) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "select * from customer where 1=1";
		if(!CommUtil.isEmpty(cname)){
			sql = sql + " and cname like ?";
			return runner.query(sql, new BeanListHandler<CustomerBean>(CustomerBean.class),"%" + cname + "%");
		}else{
			return runner.query(sql, new BeanListHandler<CustomerBean>(CustomerBean.class));
		}

	}

	@Override
	public boolean insertCustomer(CustomerBean bean) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "insert into customer value(null,?,?)";
		int result = runner.update(sql,bean.getCname(),bean.getCphone());
		if(result > 0){
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteCustomer(int cid) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "delete from customer where cid = ?";
		int result = runner.update(sql, cid);
		
		if(result > 0){
			return true;
		}
		return false;
	}

	@Override
	public CustomerBean findCustomerById(int cid) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "select * from customer where cid =?";
		return runner.query(sql, new BeanHandler<CustomerBean>(CustomerBean.class),cid);
	}

	@Override
	public boolean RelCustomer(CustomerBean bean) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "update customer set cname = ?, cphone =? where cid=?";
		int result = runner.update(sql, bean.getCname(),bean.getCphone(),bean.getCid());
		if(result > 0){
			return true;
		}
		return false;
	}
}
