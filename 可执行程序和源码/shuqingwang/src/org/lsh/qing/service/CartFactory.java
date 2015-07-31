package org.lsh.qing.service;

import java.util.Map;

import org.lsh.qing.action.BaseAction;
import org.lsh.qing.util.Constant;
import org.lsh.qing.util.CookieUtil;


public class CartFactory extends BaseAction {
	
	public static CartService getInstance(Map<String, Object> session)
			throws Exception {
		CartService cart = (CartService) session.get(Constant.CART);
		if (cart == null) {
			cart = new CartServiceImpl();
			cart.load(CookieUtil.findCookie(Constant.CART, httpReq));
			session.put(Constant.CART, cart);
		}
		return cart;
	}

	public static void main(String[] args) {
		System.out.println("111");
	}

}
