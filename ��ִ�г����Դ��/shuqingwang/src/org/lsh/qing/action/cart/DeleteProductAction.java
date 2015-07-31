package org.lsh.qing.action.cart;

import javax.annotation.Resource;

import org.lsh.qing.action.BaseAction;
import org.lsh.qing.service.CartService;
import org.lsh.qing.util.Constant;
import org.lsh.qing.util.CookieUtil;

public class DeleteProductAction extends BaseAction {
	private int pid;
	private CartService cart;

	@Resource(name = "cartService")
	public void setCart(CartService cart) {
		this.cart = cart;
	}

	public String execute() throws Exception {
		cart.delete(pid);
		CookieUtil.addCookie(Constant.CART, cart.store(), response);
		return "success";
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

}
