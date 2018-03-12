package com.zym.mvcapp.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.zym.mvcapp.dao.DAO;
import com.zym.mvcapp.domain.Customers;

public class DAOTest {

	DAO<Customers> dao = new DAO<>();
	@Test
	public void testUpdata() {
		
		String sql = "DELETE FROM customers WHERE id =?";
		dao.updata(sql, 5);
	}

	@Test
	public void testGet() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetForList() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetValu() {
		fail("Not yet implemented");
	}

}
