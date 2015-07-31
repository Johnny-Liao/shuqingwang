package org.lsh.qing.action.main;

import java.util.List;

import org.lsh.qing.dao.ProductDAO;
import org.lsh.qing.entity.Product;

public class FindNewBookAction {
	private List<Product> products;
	private int size;
	private ProductDAO productDAO;

	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	public String execute() throws Exception {
		products = productDAO.findHotNewBook(size);
		return "success";
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
