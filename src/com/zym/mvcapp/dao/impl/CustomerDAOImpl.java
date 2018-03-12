package com.zym.mvcapp.dao.impl;

import java.util.List;

import com.zym.mvcapp.dao.CustomerDAO;
import com.zym.mvcapp.dao.DAO;
import com.zym.mvcapp.domain.Customers;

public class CustomerDAOImpl extends DAO<Customers> implements CustomerDAO{

	@Override
	public List<Customers> getAll() {
		String sql = "SELECT * FROM customers";
		this.getForList(sql);
		return this.getForList(sql);
	}

	@Override
	public Customers get(Integer Id) {
		String sql = "SELECT * FROM customers WHERE id = ?";
		return this.get(sql, Id);
	}

	@Override
	public void delete(Integer Id) {
		String sql = "DELETE FROM customers WHERE id = ?";
		this.updata(sql, Id);
	}

	@Override
	public void save(Customers customers) {
		String sql = "INSERT INTO customers(id,name,address,phone) VALUES (?,?,?,?)";
		this.updata(sql, customers.getId(),customers.getName(),customers.getAddress(),customers.getPhone());
	}

	@Override
	public long getCountWithName(String name) {
		// TODO Auto-generated method stub
		String sql = "SELECT COUNT(id) FROM customers WHERE name = ?";
		return this.getValue(sql, name);
	}

}
