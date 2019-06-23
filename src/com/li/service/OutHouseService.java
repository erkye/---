package com.li.service;

import java.sql.SQLException;
import java.util.List;

import com.li.domain.OutHouseBean;
import com.li.domain.OutHouseTableBean;

/**
 * 处理入库记录的事务层
 * @author 11699
 *
 */
public interface OutHouseService {


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
	 * 插入出库记录
	 * @param bean
	 * @return
	 * @throws SQLException
	 */
	public boolean insertRecord(OutHouseTableBean bean) throws SQLException;
	
	/**
	 * 删除出库记录
	 * @param oid
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteRecordById(int oid) throws SQLException;
	
	/**
	 * 根据id查找出库视图的相应的记录
	 * @param oid
	 * @return
	 * @throws SQLException
	 */
	public OutHouseBean findRecordById(int oid) throws SQLException;
	
	/**
	 * 更新outhouse表
	 * @param oldnums
	 * @param bean
	 * @return
	 * @throws SQLException
	 */
	public boolean update(int oldnums,OutHouseTableBean bean) throws SQLException;
	
}
