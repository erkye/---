package com.li.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.li.dao.impl.CustomerDaoImpl;
import com.li.domain.CustomerBean;
import com.li.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	@Override
	public List<CustomerBean> findAll() throws SQLException {
		return new CustomerDaoImpl().findAll();
	}

	@Override
	public List<CustomerBean> fuzzyQuery(String cname) throws SQLException {
		return new CustomerDaoImpl().fuzzyQuery(cname);
	}

	@Override
	public boolean insertCustomer(CustomerBean bean) throws SQLException {
		return new CustomerDaoImpl().insertCustomer(bean);
	}

	@Override
	public boolean deleteCustomer(int cid) throws SQLException {
		return new CustomerDaoImpl().deleteCustomer(cid);
	}

	@Override
	public CustomerBean findCustomerById(int cid) throws SQLException {
		return new CustomerDaoImpl().findCustomerById(cid);
	}

	@Override
	public boolean RelCustomer(CustomerBean bean) throws SQLException {
		return new CustomerDaoImpl().RelCustomer(bean);
	}

}
