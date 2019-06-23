package com.li.service;

import java.sql.SQLException;
import java.util.List;

import com.li.domain.DrugsBean;
import com.li.domain.InHouseBean;
import com.li.domain.InHouseTableBean;

/**
 * 处理入库记录的事务层
 * @author 11699
 *
 */
public interface InHouseService {

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
	 * 添加一条入库记录，并更改药品表中的库存量
	 * @param bean
	 * @return
	 * @throws SQLException
	 */
	public boolean insertRecord(InHouseTableBean bean) throws SQLException;
	
	/**
	 * 根据id删除一条入库记录，并修改库存信息
	 * @param iid
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteRecordById(int iid) throws SQLException;
	
	/**
	 * 通过iid查找该记录所指药品的库存量,查看而是否可以删除
	 * @param iid
	 * @return
	 * @throws SQLException
	 */
	public boolean getNumsByiid(int iid) throws SQLException;
	
	/**
	 * 通过id查找记录
	 * @param iid
	 * @return
	 * @throws SQLException
	 */
	public InHouseBean findById(int iid) throws SQLException;
	
	/**
	 * 更新入库记录表，并修改库存量
	 * @param oldnums
	 * @param bean
	 * @return
	 * @throws SQLException
	 */
	public boolean update(int oldnums,InHouseTableBean bean) throws SQLException;
}
