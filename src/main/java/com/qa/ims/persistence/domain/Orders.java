package com.qa.ims.persistence.domain;

import java.util.ArrayList;
import java.util.List;

public class Orders {

	private Long oid;
	private Customer oCustomer;
	private Double value;
	List<Items> oItems = new ArrayList<Items>();

	public Orders(Customer oCustomer, Double value, List<Items> oItems) {
		this.setCustomer(oCustomer);
		this.setValue(value);
		this.setOItems(oItems);
	}

	public Orders(Long oid, Customer oCustomer, Double value, List<Items> oItems) {
		this.setOid(oid);
		this.setCustomer(oCustomer);
		this.setValue(value);
		this.setOItems(oItems);
	}

	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public Customer getCustomer() {
		return oCustomer;
	}

	public void setCustomer(Customer oCustomer) {
		this.oCustomer = oCustomer;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public List<Items> getOItems() {
		return oItems;
	}

	public void setOItems(List<Items> items) {
		this.oItems = items;
	}

	@Override
	public String toString() {
		StringBuilder order = new StringBuilder();
		order.append(String.format("%s: %s %s", this.oid, oCustomer.getFirstName(), oCustomer.getLastName()));
		if ()
		return "oid:" + oid + " f_cid:" + f_cid + " f_oid:" + f_oid + " f_iid" + f_iid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((oid == null) ? 0 : oid.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		result = prime * result + ((items == null) ? 0 : items.hashCode());
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
		if (getF_cid() == null) {
			if (other.getF_cid() != null)
				return false;
		} else if (!getF_cid().equals(other.getF_cid()))
			return false;
		if (oid == null) {
			if (other.oid != null)
				return false;
		} else if (!oid.equals(other.oid))
			return false;
		if (f_cid == null) {
			if (other.f_cid != null)
				return false;
		} else if (!f_cid.equals(other.f_cid))
			return false;
		if (f_iid == null) {
			if (other.f_iid != null)
				return false;
		} else if (!f_iid.equals(other.f_iid))
			return false;
		return true;
	}

}