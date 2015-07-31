package org.lsh.qing.entity;

import java.util.HashSet;
import java.util.Set;


public class Order implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer status;
	private long orderTime;
	private String orderDesc;
	private double totalPrice;
	// private Address address;
	private Set<Item> items = new HashSet<Item>();

	// Constructors

	/** default constructor */
	public Order() {
	}

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	/** minimal constructor */
	public Order(Integer userId, Integer status, long orderTime,
			double totalPrice) {
		this.status = status;
		this.orderTime = orderTime;
		this.totalPrice = totalPrice;
	}

	/** full constructor */
	public Order(Integer userId, Integer status, long orderTime,
			String orderDesc, double totalPrice, String receiveName,
			String fullAddress, String postalCode, String mobile, String phone) {
		this.status = status;
		this.orderTime = orderTime;
		this.orderDesc = orderDesc;
		this.totalPrice = totalPrice;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public long getOrderTime() {
		return this.orderTime;
	}

	public void setOrderTime(long orderTime) {
		this.orderTime = orderTime;
	}

	public String getOrderDesc() {
		return this.orderDesc;
	}

	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}

	public double getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

}