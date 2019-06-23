package com.li.dao;

import java.sql.SQLException;
import java.util.List;

import com.li.domain.InHouseBean;

/**
 * 处理入库视图的的dao
 * @author 11699
 *
 */
public interface InHouseDao {

	/**
	 * 查找所有的入库记录
	 * @return
	 * @throws SQLException
	 */
	public List<InHouseBean> findAll() throws SQLException;
	
	
	/**
	 * 模糊查询
	 * @param drugname
	 * @param staffname
	 * @return
	 * @throws SQLException
	 */
	public List<InHouseBean> fazzyQuery(String drugname,String staffname) throws SQLException;
	
	/**
	 * 通过id查找到入库记录
	 * @param iid
	 * @return
	 * @throws SQLException
	 */
	public InHouseBean findById(int iid) throws SQLException;
}
