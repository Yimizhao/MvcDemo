package com.zym.mvcapp.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class JdbcUtils {
	
	public static void relaseConnection(Connection connection) {
		try {
			if (!Objects.isNull(connection)) {
				connection.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	private static DataSource dataSource = null;
	
	static{
		//����Դֻ�ܱ�����һ��. 
		dataSource = new ComboPooledDataSource("mvcapp");
	}
	
	/**
	 * ��������Դ��һ�� Connection ����
	 * @return
	 * @throws SQLException  
	 */
	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}

}
