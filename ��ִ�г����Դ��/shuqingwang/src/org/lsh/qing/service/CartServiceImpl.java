package org.lsh.qing.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.lsh.qing.action.BaseAction;
import org.lsh.qing.dao.ProductDAO;
import org.lsh.qing.entity.CartItem;
import org.lsh.qing.entity.Product;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("cartService")
@Scope("session")
public class CartServiceImpl extends BaseAction implements CartService {
	// 储存商品
	List<CartItem> store = new ArrayList<CartItem>();
	private ProductDAO productDAO;

	@Resource(name = "productDAO")
	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	public boolean buy(int id) throws Exception {
		// 判断是否购买过
		if (store == null)
			return false;
		for (CartItem item : store) {
			if (item.getProduct().getId() == id) {
				return false;
			}
		}
		// 未购买过
		System.out.println(id + "进去了");
		System.out.println(productDAO);
		Product pro = productDAO.findById(id);
		System.out.println("没结果");
		// System.out.println(pro.getProductName());
		CartItem item = new CartItem();
		item.setProduct(pro);
		store.add(item);
		return true;
	}

	// 列出
	public List<CartItem> getBuyPros() throws Exception {
		return store;
	}

	public String store() {
		StringBuffer sub = new StringBuffer();
		if (store.size() == 0) {
			sub.append("0");// 导入时做判断
		} else {
			for (int i = 0; i < store.size(); i++) {
				CartItem item = store.get(i);
				sub.append(item.getProduct().getId() + "," + item.getQty()
						+ "," + item.isBuy() + ";");
			}
		}
		// if(sub.length()>1){
		// sub.deleteCharAt(sub.length()-1);
		// }

		return sub.toString();
	}

	// 导出商品
	public void load(String content) {
		if (content == null || content.equals("0")) {
			return;
		}
		String[] pcs = content.split(";");
		for (int i = 0; i < pcs.length; i++) {
			String pc = pcs[i];
			String[] strs = pc.split(",");
			int id = Integer.parseInt(strs[0]);
			int qty = Integer.parseInt(strs[1]);
			boolean buy = Boolean.parseBoolean(strs[2]);

			try {
				Product pro = productDAO.findById(id);
				CartItem item = new CartItem();
				item.setProduct(pro);
				item.setQty(qty);
				item.setBuy(buy);
				store.add(item);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// 删除商品
	public void delete(int pid) throws Exception {
		for (CartItem item : store) {
			if (item.getProduct().getId() == pid) {
				item.setBuy(false);
			}
		}
		// CookieUtil.addCookie(Constant.CART, cart.store(), response);
	}

	// 恢复商品
	public void recovery(int pid) throws Exception {
		for (CartItem item : store) {
			if (item.getProduct().getId() == pid) {
				item.setBuy(true);
			}
		}

	}

	// 修改商品数量
	public void modify(int pid, int qty) throws Exception {
		for (CartItem item : store) {
			if (item.getProduct().getId() == pid) {
				item.setQty(qty);
			}
		}

	}

	// 计算商品总金额
	public double cost() throws Exception {
		double total = 0;
		for (CartItem item : store) {
			if (item.isBuy() == true) {
				total += item.getProduct().getDangPrice() * item.getQty();
			}

		}
		return total;
	}

	/*
	 * 
	 * 计算节省价钱
	 */
	public double sale() throws Exception {
		double save = 0;
		for (CartItem item : store) {
			if (item.isBuy() == true) {
				save += (item.getProduct().getFixedPrice() - item.getProduct()
						.getDangPrice()) * item.getQty();
			}
		}
		return save;
	}

	public List<CartItem> getPros() throws Exception {
		List<CartItem> items = new ArrayList<CartItem>();
		for (CartItem item : store) {
			if (item.isBuy()) {
				items.add(item);
			}
		}
		return items;
	}
}
