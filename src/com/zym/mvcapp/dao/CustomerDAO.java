package com.zym.mvcapp.dao;

import java.util.List;

import com.zym.mvcapp.domain.Customers;

public interface CustomerDAO {

	public List<Customers> getAll();
	public Customers get(Integer Id);
	public void delete(Integer Id);
	public void save(Customers customers);
	
	public long getCountWithName(String name);
}
