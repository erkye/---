package com.li.dao;

import java.sql.SQLException;
import java.util.List;

import com.li.domain.DrugInsertRequestBean;
import com.li.domain.DrugRelRequestBean;
import com.li.domain.DrugsBean;
import com.li.domain.OutHouseTableBean;

/**
 * 操作药品信息表的dao
 * @author 11699
 *
 */
public interface DrugsDao {

	/**
	 * 查找所有药品信息
	 * @return
	 * @throws SQLException
	 */
	public List<DrugsBean> findAll() throws SQLException;
	
	/**
	 * 药品信息页面的模糊查询
	 * @return
	 * @throws SQLException
	 */
	public List<DrugsBean> fuzzyQuery(String drugname,String drugfactory,String drugposition) throws SQLException;
	
	
	/**
	 * 插入药品信息，传入一个添加药品的bean 返回boolean类型
	 * @param bean
	 * @return
	 * @throws SQLException
	 */
	public boolean insertDrug(DrugInsertRequestBean bean) throws SQLException;
	
	/**
	 * 检查插入药品时，药品名时候可用 可用返回true 不可用返回false
	 * @param drugname
	 * @return
	 * @throws SQLException
	 */
	
	public boolean checkDrugName(String drugname) throws SQLException;
	
	/**
	 * 检查插入药品时，药品名时候可用(排除当前id) 可用返回true 不可用返回false
	 * @param drugname
	 * @return
	 * @throws SQLException
	 */
	public boolean checkDrugName(String drugname,int did) throws SQLException;
	
	/**
	 * 根据传入的id删除数据库中相应的记录
	 * @param did
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteDrugById(int did) throws SQLException;
	
	/**
	 * 根据传入的id查找某个药品信息，返回药品的bean
	 * @param did
	 * @return
	 * @throws SQLException
	 */
	
	public DrugsBean findDrugById(int did) throws SQLException;
	
	
	/**
	 * 根据传入的bean 更新信息
	 * @param bean
	 * @return
	 * @throws SQLException
	 */
	public boolean RelDrugByBean(DrugsBean bean) throws SQLException;
	
	/**
	 * 出库时，更新表内的库存量信息
	 * @param outnum
	 * @return
	 * @throws SQLException
	 */
	public boolean insertOuthouse(OutHouseTableBean bean) throws SQLException;
	
	/**
	 * 删除出库记录时更新库存量，数量增加
	 * @param did
	 * @param num
	 * @return
	 * @throws SQLException
	 */
	public boolean updateNumsById(int did,int num) throws SQLException;
	
	/**
	 * 更新药品数量信息，数量减少
	 * @param did
	 * @param num
	 * @return
	 * @throws SQLException
	 */
	public boolean updateNumsByIdDown(int did,int num) throws SQLException;



}
