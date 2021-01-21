package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemsDao;
import com.qa.ims.persistence.domain.Items;
import com.qa.ims.utils.JavaUtilities;

public class ItemsController implements ICrudController<Items> {

	public static final Logger LOGGER = LogManager.getFormatterLogger();

	private ItemsDao itemsDao;
	private JavaUtilities javaUtilities;

	public ItemsController(ItemsDao itemsDao, JavaUtilities javaUtilities) {
		super();
		this.itemsDao = itemsDao;
		this.javaUtilities = javaUtilities;

	}

	@Override
	public List<Items> readAll() {
		List<Items> items = itemsDao.readAll();
		for (Items item : items) {
			LOGGER.info(item);
		}

		return items;
	}

	@Override
	public Items create() {
		LOGGER.info("Please enter an item name");
		String itemName = javaUtilities.getString();
		LOGGER.info("Please enter a price");
		double price = javaUtilities.getDouble();
		Items items = itemsDao.create(new Items(itemName, price));
		LOGGER.info("Item created");
		return items;
	}

	@Override
	public Items update() {
		LOGGER.info("Please enter the Iid you would like to update");
		Long Iid = javaUtilities.getLong();
		LOGGER.info("Please enter the item name");
		String itemName = javaUtilities.getString();
		LOGGER.info("Please enter the price");
		double price = javaUtilities.getDouble();
		Items items = itemsDao.update(new Items(Iid, itemName, price));
		LOGGER.info("Item updated");

		return items;
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the item id (Iid) you would like to delete");
		Long Iid = javaUtilities.getLong();
		return itemsDao.delete(Iid);
	}

}
