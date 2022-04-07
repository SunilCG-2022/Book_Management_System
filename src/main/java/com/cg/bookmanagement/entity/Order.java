package com.cg.bookmanagement.entity;

 

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="OraderTable")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OrderId")
	private int order_id;
	private String order_Status;
	private int order_Price;
	private String address;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "supplierId")
	private Supplier supplier;
	 
 	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	 

	public int getOrder_id() {
		return order_id;
	}

	public String getOrder_Status() {
		return order_Status;
	}

	public void setOrder_Status(String order_Status) {
		this.order_Status = order_Status;
	}

	public int getOrder_Price() {
		return order_Price;
	}

	public void setOrder_Price(int order_Price) {
		this.order_Price = order_Price;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
 

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	 
	public Order(String order_Status, int order_Price, String address ) {
		super();
		this.order_Status = order_Status;
		this.order_Price = order_Price;
		this.address = address;
		 
	}

	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", order_Status=" + order_Status + ", order_Price=" + order_Price
				+ ", address=" + address + " "  + "]";
	}

	 

}
