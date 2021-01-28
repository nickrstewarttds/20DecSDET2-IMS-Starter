package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;


import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Items;
import com.qa.ims.utils.DatabaseUtilities;

public class ItemDAOTest {
	
	private final ItemDao IDAO = new ItemDao();
	
	
	
	@Before
	public void setup() {
		
	DatabaseUtilities.connect();
	DatabaseUtilities.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	
         }
	
	@Test
	public void testCreate() {
		final Items created = new Items(4L, "NBA2K21", 50.00);
		assertEquals(created, IDAO.create(created));
	
	}
	
	@Test
	public void testReadAll() {
		List<Items> expected = new ArrayList<>();
		expected.add(new Items(1L, "Super SmashBros", 44.00));
		expected.add(new Items(2L, "FFVII remake", 30.00));
		expected.add(new Items(3L, "GTA v", 25.00));
		assertEquals(expected, IDAO.readAll());
		
	}
	
	
	@Test
	public void testReadLatest() {
		assertEquals(new Items (3L, "GTA v", 25.00), IDAO.readLatest());
	}
	
	@Test
	public void testRead() {
		final Long iID = 1L;
		assertEquals(new Items(iID, "Super SmashBros", 44.00), IDAO.read(iID));
	}
	
	 
	@Test
	public void testUpdate() {
		final Items updated = new Items(1L, "NBA2K21", 50.00);
		assertEquals(updated, IDAO.update(updated));
	}
	@Test
	public void testDelete() {
	assertEquals(1, IDAO.delete(2));
	}
	
	@After
	public void testEnd() {
		System.out.println("Test is complete");
	}
	 


	
	
	

}
