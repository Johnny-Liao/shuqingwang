package org.lsh.qing.action.cart;

import javax.annotation.Resource;

import org.lsh.qing.action.BaseAction;
import org.lsh.qing.service.CartService;
import org.lsh.qing.util.Constant;
import org.lsh.qing.util.CookieUtil;

public class RecoveryProductAction extends BaseAction {
	private int id;
	private CartService cart;

	@Resource(name = "cartService")
	public void setCart(CartService cart) {
		this.cart = cart;
	}

	public String execute() throws Throwable {
		cart.recovery(id);
		CookieUtil.addCookie(Constant.CART, cart.store(), response);
		return "success";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
