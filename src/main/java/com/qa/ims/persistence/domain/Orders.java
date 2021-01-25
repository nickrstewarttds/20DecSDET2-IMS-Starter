package com.qa.ims.persistence.domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Orders {

	private Long o_id;
	private java.util.Date order_date;
	private Long fkid;
	private Long fki_id;
	private Customer ordercustomer;
	private List <Items> orderitems = new ArrayList<>();

	public Orders(Long o_id, java.util.Date order_date, Long fkid, Long fki_id, Customer customer) {
		super();
		this.o_id = o_id;
		this.order_date = order_date ;
		this.fkid = fkid;
		this.fki_id = fki_id;
		this.ordercustomer = customer;
		this.orderitems = Items;
		
	}
	public Orders(Date order_date, Long fkid, Long fki_id, Customer customer) {
		super();
		this.order_date = order_date;
		this.fkid = fkid;
		this.fki_id = fki_id;
		this.ordercustomer = customer;
	}
	

	public Orders(java.util.Date order_date, Customer customer) {
		this.order_date = order_date;
		this.ordercustomer = customer;
	}


	public Long geto_id() {
		return o_id;
	}

	public void seto_id(Long o_id) {
		this.o_id = o_id;
	}

	public java.util.Date getorder_date() {
		return order_date;
	}

	public void setorder_date(java.util.Date order_date) {
		this.order_date = order_date; 
	}

	public Long getfkid() {
		return fkid;
	}

	public void setfkid(Long fkid) {
		this.fkid = fkid;
	}
	public Long getfki_id() {
		return fki_id;
	}

	public void setfki_id(Long fki_id) {
		this.fki_id = fki_id;
	}
	public Customer getCustomer() {
		return ordercustomer;
	}

	public void setCustomer(Customer customer) {
		this.ordercustomer = customer;
	}
	
	public List<Items> getItems(){
		return orderitems;
	}
	
	public void setItems (List<Items> items) {
		this.orderitems = items;
	}
	

	@Override
	public String toString() {
		return "o_id:" + o_id + " order_date:" + order_date + " fkid:" + fkid + "fki_id" + fki_id + "customer:" + ordercustomer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((order_date == null) ? 0 : order_date.hashCode());
		result = prime * result + ((o_id == null) ? 0 : o_id.hashCode());
		result = prime * result + ((fkid == null) ? 0 : fkid.hashCode());
		result = prime * result + ((fki_id == null) ? 0 : fki_id.hashCode());
		result = prime * result + ((ordercustomer == null) ? 0 : ordercustomer.hashCode());
		
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
		if (getorder_date() == null) {
			if (other.getorder_date() != null)
				return false;
		} else if (!getorder_date().equals(other.getorder_date()))
			return false;
		if (o_id == null) {
			if (other.o_id != null)
				return false;
		} else if (!o_id.equals(other.o_id))
			return false;
		if (fkid == null) {
			if (other.fkid != null)
				return false;
		} else if (!fkid.equals(other.fkid))
			return false;
		if (fki_id == null) {
			if (other.fki_id != null)
				return false;
		} else if (!fkid.equals(other.fki_id))
			return false;
		if (ordercustomer == null) {
			if (other.ordercustomer != null)
				return false;
		} else if (!ordercustomer.equals(other.ordercustomer))
			return false;
		return true;
	}

}
