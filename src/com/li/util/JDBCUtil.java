package com.li.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * JDBC 连接的工具类 使用c3p0数据库链接池
 * @author 11699
 *
 */
public class JDBCUtil {

	static ComboPooledDataSource dataSource = null;
	static{
		dataSource = new ComboPooledDataSource();
	}
	/**
	 * 返回一个数据c3p0的连接池对象
	 * @return
	 */
	public static ComboPooledDataSource getDataSource(){
		return dataSource;
	}
	
	public static void colseAll(Connection conn,PreparedStatement ps,ResultSet rs){
		closeResult(rs);
		closeStatement(ps);
		closeConnection(conn);
	}
	public static void closeAll(Connection conn,PreparedStatement ps){
		closeStatement(ps);
		closeConnection(conn);
	}
	public static void closeConnection(Connection conn){
		try {
			if (conn != null) {
				conn.close();
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			conn = null;
		}
	}
	public static void closeStatement(PreparedStatement ps){
		try {
			if (ps != null) {
				ps.close();
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ps = null;
		}
	}
	public static void closeResult(ResultSet rs){
		try {
			if (rs != null) {
				rs.close();
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			rs = null;
		}
	}
}
