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
	 * ͳ�ơ�ȷ�Ϲ��򡱵���Ʒ��ʡ���
	 * 
	 * @return
	 * @throws Exception
	 */
	public double sale() throws Exception;

	/**
	 * ��ȡȷ�Ϲ�����Ʒ��ʾ�б�
	 * 
	 * @return
	 * @throws Exception
	 */
	public void load(String findCookie);

	public List<CartItem> getPros() throws Exception;

}
