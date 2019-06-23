package com.li.dao;

import java.sql.SQLException;

import com.li.domain.InHouseTableBean;

/**
 * 入库记录表（inhouse）的dao
 * @author 11699
 *
 */
public interface InHouseTableDao {

	
	/**
	 * 出入一条新入库纪录
	 * @param bean
	 * @return
	 * @throws SQLException
	 */
	public boolean insertRecord(InHouseTableBean bean) throws SQLException;
	
	
	/**
	 * 根据id删除记录
	 * @param iid
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteRecordById(int iid) throws SQLException;
	
	/**
	 * 更新入库记录
	 * @param bean
	 * @return
	 * @throws SQLException
	 */
	
	public boolean update(InHouseTableBean bean) throws SQLException;
}
