package com.li.dao;

import java.sql.SQLException;

import com.li.domain.OutHouseTableBean;

/**
 * 处理出库记录表的dao
 * @author 11699
 *
 */
public interface OutHouseTableDao {

	/**
	 * 插入出库记录
	 * @param bean
	 * @return
	 * @throws SQLException
	 */
	public boolean insertRecord(OutHouseTableBean bean) throws SQLException;
	
	/**
	 * 通过id查找出库记录
	 * @param oid
	 * @return
	 * @throws SQLException
	 */
	public OutHouseTableBean findRecordById(int oid) throws SQLException;
	
	/**
	 * 通过id删除出库记录
	 * @param oid
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteRecord(int oid) throws SQLException;
	
	/**
	 * 使用传入的bean更新outhouse表
	 * @param bean
	 * @return
	 * @throws SQLException
	 */
	public boolean update(OutHouseTableBean bean) throws SQLException;
}
