//package com.qa.ims.persistence.dao;
//
//import static org.junit.Assert.assertEquals;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//
//
//import com.qa.ims.persistence.domain.Customer;
//import com.qa.ims.persistence.domain.Items;
//import com.qa.ims.persistence.domain.Orders;
//import com.qa.ims.utils.DatabaseUtilities;
//
//public class OrderDAOTest {
//	private final ItemDao IDAO = new ItemDao();
//	private final CustomerDao CDAO = new CustomerDao();
//	private final OrderDao ODAO = new OrderDao(IDAO, CDAO);
//	
//	private Orders testOrder;
//	
//	
//	@Before
//	public void setup() {
//		DatabaseUtilities.connect();
//		DatabaseUtilities.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
//		List<Items> item = new ArrayList<>();
//		item.add(new Items(1L, "Super SmashBros", 44.00));
//		item.add(new Items(2L, "FFVII remake", 30.00));
//		testOrder = new Orders(1L, new Customer(1L, "Arsalan", "Asad"), 74, item);
//	}
//	
//	@Test
//	public void testCreate() {
//		final Orders created = new Orders (2L, new Customer(1L, "Nick", "John"), 0.0);
//		assertEquals(created, ODAO.create(created));
//	}
//
//	@Test
//	public void testReadAll() {
//		List<Orders> expected = new ArrayList<>();
//		expected.add(new Orders(1L, new Customer(1L, "Arsalan", "Asad"), 74.00));
//		assertEquals(expected, ODAO.readAll());
//	}
//	
//	@Test
//	public void testDelete() { 
//		assertEquals(1, ODAO.delete(1));
//	}
//	
//	
//	
//	
//	
//	
//	
//	
//}
