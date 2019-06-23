package com.li.dao;

import java.sql.SQLException;
import java.util.List;

import com.li.domain.CustomerBean;
import com.li.domain.OutHouseBean;

/**
 * 处理出库记录的dao 视图outrecord
 * @author 11699
 *
 */
public interface OutHouseDao {

	/**
	 * 查找所有的出库记录视图
	 * @return
	 * @throws SQLException
	 */
	public List<OutHouseBean> findAll() throws SQLException;
	
	/**
	 * 出库记录信息的模糊查询
	 * @return
	 * @throws SQLException
	 */
	public List<OutHouseBean> fuzzyQuery(String drugname, String customername, String staffname) throws SQLException;
	
	
	/**
	 * 根据id查找出库视图的相应的记录
	 * @param oid
	 * @return
	 * @throws SQLException
	 */
	public OutHouseBean findRecordById(int oid) throws SQLException;
}
