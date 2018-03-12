package com.zym.mvcapp.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.zym.mvcapp.dao.CustomerDAO;
import com.zym.mvcapp.dao.impl.CustomerDAOImpl;
import com.zym.mvcapp.domain.Customers;

public class CustomersDAOImplTest {
	CustomerDAO customerDAO = new CustomerDAOImpl();

	@Test
	public void testGetAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetInteger() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testSave() {
		Customers customers = new Customers(2, "HEDE", "henan", "123456789");
		customerDAO.save(customers);
	}

	@Test
	public void testGetCountWithName() {
		fail("Not yet implemented");
	}

}
