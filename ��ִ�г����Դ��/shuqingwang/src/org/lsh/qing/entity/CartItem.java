package org.lsh.qing.entity;

import org.lsh.qing.entity.Product;

public class CartItem {
	private Product product;
	private int qty = 1;
	/*
	 * 是否确认购买 如果购买为true 否则为false
	 */
	private boolean buy = true;
	public CartItem(){
		
	}
	public CartItem(Product product, int qty, boolean buy) {
		super();
		this.product = product;
		this.qty = qty;
		this.buy = buy;
	}
	public boolean isBuy() {
		return buy;
	}


	public void setBuy(boolean buy) {
		this.buy = buy;
	}


	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	

}
