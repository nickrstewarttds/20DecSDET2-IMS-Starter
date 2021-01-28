package com.qa.ims.persistence.domain;

public class Items {

	private Long iID;
	private String itemName;
	private double price;

	public Items(String itemName, double Price) {
		this.setItemName(itemName);
		this.setPrice(Price);
	}

	public Items(Long iID, String itemName, double Price) {
		this.setIid(iID);
		this.setItemName(itemName);
		this.setPrice(Price);
	}

	public Long getIid() {
		return iID;
	}

	public void setIid(Long iid) {
		iID = iid;
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
		return "Items [iid=" + iID + ", itemName=" + itemName + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((iID == null) ? 0 : iID.hashCode());
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
		if (iID == null) {
			if (other.iID != null)
				return false;
		} else if (!iID.equals(other.iID))
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
