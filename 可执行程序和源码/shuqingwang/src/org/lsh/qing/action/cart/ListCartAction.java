package org.lsh.qing.action.cart;

import java.util.List;

import org.lsh.qing.action.BaseAction;
import org.lsh.qing.entity.CartItem;
import org.lsh.qing.service.CartService;

public class ListCartAction extends BaseAction {
	private List<CartItem> items;
	private double total;
	private double save;
	private CartService cartService;

	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}

	public String execute() throws Exception {
		items = cartService.getBuyPros();
		total = cartService.cost();
		save = cartService.sale();
		return "success";
	}

	public List<CartItem> getItems() {
		return items;
	}

	public void setItems(List<CartItem> items) {
		this.items = items;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getSave() {
		return save;
	}

	public void setSave(double save) {
		this.save = save;
	}

}
