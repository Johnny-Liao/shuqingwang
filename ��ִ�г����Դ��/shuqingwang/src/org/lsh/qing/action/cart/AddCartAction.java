package org.lsh.qing.action.cart;

import javax.annotation.Resource;

import org.lsh.qing.action.BaseAction;
import org.lsh.qing.service.CartService;
import org.lsh.qing.util.Constant;
import org.lsh.qing.util.CookieUtil;

public class AddCartAction extends BaseAction {
	private int pid;
	private boolean buy = false;
	private CartService cartService;

	@Resource(name = "cartService")
	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}

	public String execute() throws Exception {
		buy = cartService.buy(pid);
		CookieUtil.addCookie(Constant.CART, cartService.store(), response);
		return "success";
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public boolean isBuy() {
		return buy;
	}

	public void setBuy(boolean buy) {
		this.buy = buy;
	}

}
