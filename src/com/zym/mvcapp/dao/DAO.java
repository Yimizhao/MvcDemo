package com.zym.mvcapp.dao;


import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.zym.mvcapp.db.JdbcUtils;

/**
 * 
 * @author Administrator
 *
 * @param <T> 当前DAO操作实体类的类型
 */
public class DAO<T> {
	
	private Class<T> clazz;
	private QueryRunner queryRunner = new QueryRunner();
	
	public DAO() {
		Type type = this.getClass().getGenericSuperclass();
		if (type instanceof ParameterizedType) {
			ParameterizedType type2 = (ParameterizedType) type;
			Type [] typeArgs = type2.getActualTypeArguments();
			Type typeArg = typeArgs[0];
			if(typeArg instanceof Class){
				this.clazz = (Class<T>) typeArg;
			}
		}
		this.clazz = (Class<T>) Object.class;
	}

	/**
	 * INSET，UPDATA,DELETE
	 * @param sql 所要执行的SQL语句
	 * @param arga sql语句用到的参数
	 * @throws SQLException 
	 */
	public void updata(String sql, Object ... arga) {
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			queryRunner.update(conn, sql, arga);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.relaseConnection(conn);
		}
	}
	
	/**
	 * 
	 * @param sql
	 * @param args
	 * @return
	 * @throws SQLException 
	 */
	public T get(String sql, Object ... args) {
		Connection connection = null;
		try {
			connection = JdbcUtils.getConnection();
			return queryRunner.query(connection, sql, new BeanHandler<T>(clazz), args);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.relaseConnection(connection);
		}
		return null;
	}
	
	/**
	 * 
	 * @param sql
	 * @param args
	 * @return
	 * @throws SQLException 
	 */
	public List<T> getForList(String sql, Object ... args) {
		Connection connection = null;
		try {
			connection = JdbcUtils.getConnection();
			return queryRunner.query(connection, sql, new BeanListHandler<T>(clazz), args);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.relaseConnection(connection);
		}
		return null;
	}
	
	/**
	 * 
	 * @param sql
	 * @param args
	 * @return
	 * @throws SQLException 
	 */
	public <E> E getValue(String sql, Object ... args) {
		Connection connection = null;
		try {
			connection = JdbcUtils.getConnection();
			return (E)queryRunner.query(connection, sql, new ScalarHandler<>(), args);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.relaseConnection(connection);
		}
		return null;
	}
}
