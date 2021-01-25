package com.qa.ims.persistence.domain;

public class Orders {

	private Long oid;
	private Long f_cid;
	private Long f_oid;
	private Long f_iid;

	public Orders(Long f_cid, Long f_oid, Long f_iid) {
		this.setF_cid(f_cid);
		this.setF_oid(f_oid);
		this.setF_iid(f_iid);
	}

	public Orders(Long oid, Long f_cid, Long f_oid, Long f_iid) {
		this.setOid(oid);
		this.setF_cid(f_cid);
		this.setF_oid(f_oid);
		this.setF_iid(f_iid);
	}

	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public Long getF_cid() {
		return f_cid;
	}

	public void setF_cid(Long f_cid) {
		this.f_cid = f_cid;
	}

	public Long getF_oid() {
		return f_oid;
	}

	public void setF_oid(Long f_oid) {
		this.f_oid = f_oid;
	}

	public Long getF_iid() {
		return f_iid;
	}

	public void setF_iid(Long f_iid) {
		this.f_iid = f_iid;
	}

	@Override
	public String toString() {
		return "oid:" + oid + " f_cid:" + f_cid + " f_oid:" + f_oid + " f_iid" + f_iid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((f_cid == null) ? 0 : f_cid.hashCode());
		result = prime * result + ((oid == null) ? 0 : oid.hashCode());
		result = prime * result + ((f_oid == null) ? 0 : f_oid.hashCode());
		result = prime * result + ((f_iid == null) ? 0 : f_iid.hashCode());
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