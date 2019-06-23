package com.li.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.li.util.CommUtil;
import com.li.dao.DrugsDao;
import com.li.domain.DrugInsertRequestBean;
import com.li.domain.DrugRelRequestBean;
import com.li.domain.DrugsBean;
import com.li.domain.OutHouseTableBean;
import com.li.util.JDBCUtil;

public class DrugsDaoImpl implements DrugsDao {

	@Override
	public List<DrugsBean> findAll() throws SQLException {

		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "select * from drug";
		return runner.query(sql, new BeanListHandler<DrugsBean>(DrugsBean.class));
	}

	@Override
	public List<DrugsBean> fuzzyQuery(String drugname, String drugfactory, String drugposition) throws SQLException {

		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "select * from drug where 1=1";
		List<String> list = new ArrayList<String>();

		if (!CommUtil.isEmpty(drugname)) {
			sql = sql + " and dname like ?";
			list.add("%" + drugname + "%");
		}
		if (!CommUtil.isEmpty(drugfactory)) {
			sql = sql + " and dfactory like ?";
			list.add("%" + drugfactory + "%");
		}
		if (!CommUtil.isEmpty(drugposition)) {
			sql = sql + " and dposition like ?";
			list.add("%" + drugposition + "%");
		}

		return runner.query(sql, new BeanListHandler<DrugsBean>(DrugsBean.class), list.toArray());
	}

	@Override
	public boolean insertDrug(DrugInsertRequestBean bean) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "insert into drug values(null,?,?,?,?,?,?,?,0)";
		int result = runner.update(sql, bean.getDname(), bean.getDfactory(), bean.getDpdate(), bean.getDperiod(),
				bean.getDpurpose(), bean.getDprice(), bean.getDposition());
		if (result > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean checkDrugName(String drugname) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "select count(*) from drug where dname = ?";
		Long query = (Long) runner.query(sql, new ScalarHandler(), drugname);
		if (query > 0) {
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteDrugById(int did) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "delete from drug where did = ?";
		int result = runner.update(sql, did);
		if (result > 0) {
			return true;
		}
		return false;
	}

	@Override
	public DrugsBean findDrugById(int did) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "select * from drug where did = ?";
		return runner.query(sql, new BeanHandler<DrugsBean>(DrugsBean.class), did);
	}

	@Override
	public boolean RelDrugByBean(DrugsBean bean) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "update drug set dname = ?,dfactory=?,dpdate=?,dperiod=?,dpurpose=?,dprice=?,dposition=?,dnums=? where did=?";
		int result = runner.update(sql,
				bean.getDname(),
				bean.getDfactory(),
				bean.getDpdate(),
				bean.getDperiod(),
				bean.getDpurpose(),
				bean.getDprice(),
				bean.getDposition(),
				bean.getDnums(),
				bean.getDid()
				);
		
		if(result > 0){
			return true;
		}
		return false;
	}

	@Override
	public boolean checkDrugName(String drugname, int did) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "select count(*) from drug where dname = ? and did != ?";
		Long query = (Long) runner.query(sql, new ScalarHandler(), drugname,did);
		if (query > 0) {
			return false;
		}
		return true;
	}

	@Override
	public boolean insertOuthouse(OutHouseTableBean bean) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "UPDATE drug SET dnums = dnums-? WHERE did=?";
		int result = runner.update(sql, bean.getOnum(),bean.getOdid());
		if(result > 0){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateNumsById(int did, int num) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "UPDATE drug SET dnums = dnums+? WHERE did=?";
		int result = runner.update(sql, num,did);
		if(result > 0){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateNumsByIdDown(int did, int num) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "UPDATE drug SET dnums = dnums-? WHERE did=?";
		int result = runner.update(sql, num,did);
		if(result > 0){
			return true;
		}
		return false;
	}

}
