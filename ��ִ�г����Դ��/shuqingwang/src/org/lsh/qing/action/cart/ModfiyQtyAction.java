package org.lsh.qing.action.cart;

import javax.annotation.Resource;

import org.lsh.qing.action.BaseAction;
import org.lsh.qing.service.CartService;
import org.lsh.qing.util.Constant;
import org.lsh.qing.util.CookieUtil;

public class ModfiyQtyAction extends BaseAction {
	private int pid;
	private String qty;
	private String error = null;
	private CartService cart;

	@Resource(name = "cartService")
	public void setCart(CartService cart) {
		this.cart = cart;
	}

	public String execute() throws Exception {
		String reg = "^[0-9]+$";
		if (!qty.trim().matches(reg)) {
			error = "«Î ‰»Î ˝◊÷";
		} else {
			int num = Integer.parseInt(qty.trim());
			cart.modify(pid, num);
		}
		CookieUtil.addCookie(Constant.CART, cart.store(), response);
		return "success";
	}

	public String getQty() {
		return qty;
	}

	public void setQty(String qty) {
		this.qty = qty;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public static void main(String[] args) {
		String a = "  12";
		System.out.println(a.trim());
	}

}
