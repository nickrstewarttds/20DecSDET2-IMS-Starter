package com.qa.ims.controller;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrdersDao;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.JavaUtilities;

public class OrdersController implements ICrudController<Orders> {
    public static final Logger LOGGER = LogManager.getLogger();

    private OrdersDao ordersDao;
    private JavaUtilities javaUtilities;

    public OrdersController(OrdersDao ordersDao, JavaUtilities javaUtilities) {
        super();
        this.ordersDao = ordersDao;
        this.javaUtilities = javaUtilities;
       }
    
    
    @Override
    public List<Orders> readAll() {
        List<Orders> order = ordersDao.readAll();
        for (Orders orders : order) {
            LOGGER.info(orders.toString());
        }
        return order;
    }

   
	@Override
	public Orders create () {
        LOGGER.info("Please enter the order date");
        Date order_date = javaUtilities.getDate();
        Orders orders = ordersDao.create(new Orders(order_date)); 
        LOGGER.info("order_date entered");
        return orders;
    }

    @Override
    public Orders update() {
        LOGGER.info("Please enter your order date");
        Date order_date= javaUtilities.getDate();
        Orders orders = ordersDao.update(new Orders(order_date)); 
        LOGGER.info("order_date updated");
        return orders;
    }

    @Override
    public int delete() {
        LOGGER.info("Please enter the id of the item you would like to delete");
        Long i_id = javaUtilities.getLong();
        return ordersDao.delete(i_id);
    }


}

