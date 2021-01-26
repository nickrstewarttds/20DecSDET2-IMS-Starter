package com.qa.ims.persistence.domain;

public class Items {

	private Long Iid;
	private String itemName;
	private double price;

	public Items(String itemName, double Price) {
		this.setItemName(itemName);
		this.setPrice(Price);
	}

	public Items(Long Iid, String itemName, double Price) {
		this.setIid(Iid);
		this.setItemName(itemName);
		this.setPrice(Price);
	}

	public Long getIid() {
		return Iid;
	}

	public void setIid(Long iid) {
		Iid = iid;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	

	@Override
	public String toString() {
		return "Items [Iid=" + Iid + ", itemName=" + itemName + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Iid == null) ? 0 : Iid.hashCode());
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
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
		Items other = (Items) obj;
		if (Iid == null) {
			if (other.Iid != null)
				return false;
		} else if (!Iid.equals(other.Iid))
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}

}
