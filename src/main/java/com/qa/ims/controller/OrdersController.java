package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



import com.qa.ims.persistence.dao.OrderDao;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.JavaUtilities;

public class OrdersController implements ICrudController<Orders> {
	
	public static final Logger LOGGER = LogManager.getLogger();
	private OrderDao orderDao;
	private JavaUtilities javaUtilities;


	public OrdersController(OrderDao orderDao, JavaUtilities javaUtilities) {
		super();
		this.orderDao= orderDao;
		this.javaUtilities = javaUtilities;
	}

	@Override
	public List<Orders> readAll() {
	    List<Orders> orders = orderDao.readAll();
        for (Orders order : orders) {
            LOGGER.info(order);
        }
        return orders;
	}

	@Override
	public Orders create() {
		
		 LOGGER.info("Please enter a customer fk_id");
	        Long customerID = javaUtilities.getLong();
	        Orders orders = orderDao.create(new Orders(new Customer(customerID, null, null), 0.0));
	        LOGGER.info("Order created");
	        return orders;
		
	}

	@Override
	public Orders update() {
		Orders orderValue = null;
		LOGGER.info("Please enter an order Oid");
		Long Oid = javaUtilities.getLong();
		LOGGER.info("Would you like to Add or Remove an item?");
		String action = javaUtilities.getString();
		if(action.equals("Add")) {
			LOGGER.info("Please enter the item Iid you would like to add");
			Long Iid = javaUtilities.getLong();
			orderValue = orderDao.addItems(Oid, Iid);
			orderDao.update(orderValue);
		}  else if(action.equals("Remove")) {
			LOGGER.info("Please enter the item Iid you would like to remove");
			Long Iid = javaUtilities.getLong();
			orderValue = orderDao.removeItems(Oid, Iid);
			orderDao.update(orderValue);
		} else {
			LOGGER.info("Invalid input, choose Add or Remove");
		}
		 
		return orderValue;
		 
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the Oid of the order you would like to delete");
        Long Oid = javaUtilities.getLong();
        return orderDao.delete(Oid);
	}

}
