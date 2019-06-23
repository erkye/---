package com.li.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.li.dao.UserLoginDao;
import com.li.dao.impl.UserLoginDaoImpl;
import com.li.domain.RegisterBean;
import com.li.domain.UserBean;
import com.li.domain.UserResultBean;
import com.li.service.UserLoginService;

/**
 * 处理登录事务层的实现类
 * @author 11699
 *
 */
public class UserLoginServiceImpl implements UserLoginService {

	@Override
	public List<UserResultBean> login(UserBean user) throws SQLException {
		UserLoginDao dao = new UserLoginDaoImpl();
		return dao.login(user);
	}

	@Override
	public boolean checkUserName(String username) throws SQLException {
		return new UserLoginDaoImpl().checkUserName(username);
	}

	@Override
	public boolean register(RegisterBean bean) throws SQLException {
		return new UserLoginDaoImpl().register(bean);
	}

	@Override
	public UserResultBean seeUerData(int userid) throws SQLException {
		return new UserLoginDaoImpl().seeUerData(userid);
	}

}
