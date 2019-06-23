package com.li.service;

import java.sql.SQLException;
import java.util.List;

import com.li.domain.RegisterBean;
import com.li.domain.UserBean;
import com.li.domain.UserResultBean;

/**
 * 处理用户表的事务层
 * @author 11699
 *
 */
public interface UserLoginService {

	/**
	 * 查询用户表，返回登录用户名的用户数据,完成登录
	 * @return
	 * @throws SQLException
	 */
	public List<UserResultBean> login(UserBean user) throws SQLException;
	
	/**
	 * 查询用户表中是否有传入的用户名，有返回false ， 没有返回 true
	 * @param username
	 * @return
	 * @throws SQLException
	 */
	public boolean checkUserName(String username) throws SQLException;
	
	/**
	 * 注册新用户 ，注册成功返回true 失败返回 false
	 * @param bean
	 * @return
	 * @throws SQLException
	 */
	public boolean register(RegisterBean bean) throws SQLException;
	/**
	 * 主界面查看用户的个人资料，传入用户的id，返回用户的个人数据
	 * @param userid
	 * @return
	 * @throws SQLException
	 */
	
	public UserResultBean seeUerData(int userid) throws SQLException;
}
