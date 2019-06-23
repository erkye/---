package com.li.service;

import java.sql.SQLException;
import java.util.List;

import com.li.domain.DrugInsertRequestBean;
import com.li.domain.DrugRelRequestBean;
import com.li.domain.DrugsBean;

/**
 * 处理药品信息表的service
 * @author 11699
 *
 */
public interface DrugsService {
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
	 * 处理插入药品的service 插入成功返回true 失败返回false
	 * @return
	 * @throws SQLException
	 */
	public boolean insertDrug(DrugInsertRequestBean bean) throws SQLException;
	
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
	 * 处理修改药品信息
	 * @param bean
	 * @return
	 * @throws SQLException
	 */
	public boolean RelDrugByBean(DrugsBean bean) throws SQLException;
}
