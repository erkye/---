package com.li.dao;

import java.sql.SQLException;
import java.util.List;

import com.li.domain.StaffBean;

/**
 * 处理员工表的dao
 * @author 11699
 *
 */
public interface StaffsDao {

	/**
	 * 查询所有的员工信息
	 * @return
	 * @throws SQLException
	 */
	public List<StaffBean> findAll() throws SQLException;
	
	/**
	 * 员界面的模糊查询
	 * @param staffname
	 * @param staffsex
	 * @param staffjop
	 * @return
	 * @throws SQLException
	 */
	public List<StaffBean> fuzzyQuery(String staffname,String staffsex,String staffjop) throws SQLException;
	
	/**
	 * 处理插入员工信息 成功返回true 失败返回false
	 * @param bean
	 * @return
	 * @throws SQLException
	 */
	public boolean insertStaff(StaffBean bean) throws SQLException;
	
	/**
	 * 通过员工的id删除员工信息
	 * @param sid
	 * @return
	 * @throws SQLException
	 */
	public boolean deletStaffById(int sid) throws SQLException;
	
	/**
	 * 根据传入的员工id，返回对应的员工bean
	 * @param sid
	 * @return
	 * @throws SQLException
	 */
	public StaffBean findStaffById(int sid) throws SQLException;
	
	/**
	 * 通过传入bean 来更新员工的信息
	 * @param bean
	 * @return
	 * @throws SQLException
	 */
	public boolean RelStaffByBean(StaffBean bean) throws SQLException;
}

