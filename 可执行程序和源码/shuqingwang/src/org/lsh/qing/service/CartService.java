package org.lsh.qing.service;

import java.util.List;

import org.lsh.qing.entity.CartItem;

public interface CartService {
	public boolean buy(int id) throws Exception;

	public List<CartItem> getBuyPros() throws Exception;

	public String store();

	public void delete(int pid) throws Exception;

	public void recovery(int pid) throws Exception;

	public void modify(int pid, int qty) throws Exception;

	public double cost() throws Exception;

	/**
	 * 统计“确认购买”的商品节省金额
	 * 
	 * @return
	 * @throws Exception
	 */
	public double sale() throws Exception;

	/**
	 * 获取确认购买商品显示列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public void load(String findCookie);

	public List<CartItem> getPros() throws Exception;

}
