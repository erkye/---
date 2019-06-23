package com.li.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.li.dao.UserLoginDao;
import com.li.domain.RegisterBean;
import com.li.domain.UserBean;
import com.li.domain.UserResultBean;
import com.li.util.JDBCUtil;

public class UserLoginDaoImpl implements UserLoginDao {

	@Override
	public List<UserResultBean> login(UserBean user) throws SQLException {
		
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "select * from users where username = ? and password = ?";
		return runner.query(sql, new BeanListHandler<UserResultBean>(UserResultBean.class), user.getUsername(),user.getPassword());
	}

	@Override
	public boolean checkUserName(String username) throws SQLException {
		
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "select COUNT(*) from users where username = ?";
		//ScalarHandler接收聚集函数的返回值 Long类型
		Long result = (Long)runner.query(sql, new ScalarHandler(),username);
		if(result > 0){
			return false;
		}
		return true;
	}

	@Override
	public boolean register(RegisterBean bean) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "insert into users(username,password,email,phone,realname) values(? , ?, ?, ?, ?)";
		int result = runner.update(sql, bean.getUsername(),bean.getPassword(),bean.getEmail(),bean.getPhone(),bean.getRealname());
		if(result > 0){
			return true;
		}
		return false;
	}

	@Override
	public UserResultBean seeUerData(int userid) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "select * from users where id = ?";
		return runner.query(sql, new BeanHandler<UserResultBean>(UserResultBean.class),userid);
	}

}
