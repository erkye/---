package com.li.dao;

import java.sql.SQLException;
import java.util.List;

import com.li.domain.CustomerBean;
import com.li.domain.DrugsBean;

/**
 * 处理客户表的dao
 * @author 11699
 *
 */
public interface CustomerDao {

	/**
	 * 查看所有的客户信息
	 * @return
	 * @throws SQLException
	 */
	public List<CustomerBean> findAll() throws SQLException;
	
	/**
	 * 客户信息的模糊查询
	 * @return
	 * @throws SQLException
	 */
	public List<CustomerBean> fuzzyQuery(String cname) throws SQLException;
	
	/**
	 * 插入一个新的客户信息
	 * @param bean
	 * @return
	 * @throws SQLException
	 */
	public boolean insertCustomer(CustomerBean bean) throws SQLException;
	
	/**
	 * 根据id删除客户信息
	 * @param cid
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteCustomer(int cid) throws SQLException;
	
	
	/**
	 * 根据客户的id返回客户的bean
	 * @param cid
	 * @return
	 * @throws SQLException
	 */
	public CustomerBean findCustomerById(int cid) throws SQLException;
	
	/**
	 * 根据传入的客户bean更新数据库中的内容
	 * @param bean
	 * @return
	 * @throws SQLException
	 */
	public boolean RelCustomer(CustomerBean bean ) throws SQLException;
}
