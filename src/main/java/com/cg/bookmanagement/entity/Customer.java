package com.cg.bookmanagement.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CustomerId")
	private int customer_id;
	private String customer_Name;
	private String customer_address;
	private String customer_email;
	private long contact_no;
	 @OneToOne(cascade = CascadeType.PERSIST)
	 
 private Order order;
	

	public String getCustomer_Name() {
		return customer_Name;
	}

	public void setCustomer_Name(String customer_Name) {
		this.customer_Name = customer_Name;
	}

	public String getCustomer_address() {
		return customer_address;
	}

	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}

	public String getCustomer_email() {
		return customer_email;
	}

	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}

	public long getContact_no() {
		return contact_no;
	}

	public void setContact_no(long contact_no) {
		this.contact_no = contact_no;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	 
		public Order getOrder() {
			return order;
		}

		public void setOrder(Order order) {
			this.order = order;
		}
	 
 

	public Customer( String customer_Name, String customer_address, String customer_email,
			long contact_no, Order order) {
		super();
	 
		this.customer_Name = customer_Name;
		this.customer_address = customer_address;
		this.customer_email = customer_email;
		this.contact_no = contact_no;
		this.order = order;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", customer_Name=" + customer_Name + ", customer_address="
				+ customer_address + ", customer_email=" + customer_email + ", contact_no=" + contact_no + ", orders="
				 + "]";
	}

	 
	 

}
