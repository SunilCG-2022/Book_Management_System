package com.cg.bookmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Supplier {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SupplierId")
	private int supplier_id;
	private String supplier_Name;
	private String supplier_email;
	private long contact_no;

	public Supplier() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Supplier [supplier_id=" + supplier_id + ", supplier_Name=" + supplier_Name + ", supplier_email="
				+ supplier_email + ", contact_no=" + contact_no + " ]";
	}

	public Supplier(int supplier_id, String supplier_Name, String supplier_email, long contact_no) {
		super();
		this.supplier_id = supplier_id;
		this.supplier_Name = supplier_Name;
		this.supplier_email = supplier_email;
		this.contact_no = contact_no;

	}

	public int getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}

	public String getSupplier_Name() {
		return supplier_Name;
	}

	public void setSupplier_Name(String supplier_Name) {
		this.supplier_Name = supplier_Name;
	}

	public String getSupplier_email() {
		return supplier_email;
	}

	public void setSupplier_email(String supplier_email) {
		this.supplier_email = supplier_email;
	}

	public long getContact_no() {
		return contact_no;
	}

	public void setContact_no(long contact_no) {
		this.contact_no = contact_no;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (contact_no ^ (contact_no >>> 32));

		result = prime * result + ((supplier_Name == null) ? 0 : supplier_Name.hashCode());
		result = prime * result + ((supplier_email == null) ? 0 : supplier_email.hashCode());
		result = prime * result + supplier_id;
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
		Supplier other = (Supplier) obj;
		if (contact_no != other.contact_no)
			return false;

		if (supplier_Name == null) {
			if (other.supplier_Name != null)
				return false;
		} else if (!supplier_Name.equals(other.supplier_Name))
			return false;
		if (supplier_email == null) {
			if (other.supplier_email != null)
				return false;
		} else if (!supplier_email.equals(other.supplier_email))
			return false;
		if (supplier_id != other.supplier_id)
			return false;
		return true;
	}

}
