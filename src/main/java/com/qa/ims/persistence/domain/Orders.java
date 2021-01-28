package com.qa.ims.persistence.domain;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;




public class Orders {

	public static final Logger LOGGER = LogManager.getLogger();

	private Long oID;
	private Long cID;
	private Customer customer;
	private double orderValue;
	private List<Items> items = new ArrayList<>();

	public Orders(Long oID, Customer customer, double orderValue, List<Items> items) {
		super();
		this.oID = oID;
		this.customer = customer;
		this.orderValue = orderValue;
		this.items = items;
	}

	public Orders(Long oID, Customer customer, double orderValue) {
		super();
		this.oID = oID;
		this.customer = customer;
		this.orderValue = orderValue;
	}

	public Orders(Customer customer, double orderValue) {
		super();
		this.customer = customer;
		this.orderValue = orderValue;
	}

	public List<Items> showItems() {
		for (Items item : items) {
			LOGGER.info(item);
		}
		return items;
	}
	

	public Long getOid() {
		return oID;
	}

	public void setOid(Long oid) {
		oID = oid;
	}

	public Long getCid() {
		return cID;
	}

	public void setId(Long cID) {
		this.cID = cID;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getOrderValue() {
		return orderValue;
	}

	public void setOrderValue(double orderValue) {
		this.orderValue = orderValue;
	}

	public List<Items> getItems() {
		return items;
	}

	public void setItems(List<Items> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Orders [oID=");
		builder.append(oID);
		builder.append(", cID=");
		builder.append(customer.getId());
		builder.append(", customer=");
		builder.append(customer.getFirstName());
		builder.append(" ");
		builder.append(customer.getSurname());
		builder.append(", orderValue=");
		builder.append(orderValue);
		builder.append(", items=");
		builder.append(items);
		builder.append("]");
		return builder.toString();
	} 

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((oID == null) ? 0 : oID.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((cID == null) ? 0 : cID.hashCode());
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		long temp;
		temp = Double.doubleToLongBits(orderValue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		if (oID == null) {
			if (other.oID != null)
				return false;
		} else if (!oID.equals(other.oID))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (cID == null) {
			if (other.cID != null)
				return false;
		} else if (!cID.equals(other.cID))
			return false;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		if (Double.doubleToLongBits(orderValue) != Double.doubleToLongBits(other.orderValue))
			return false;
		return true;
	}

}
