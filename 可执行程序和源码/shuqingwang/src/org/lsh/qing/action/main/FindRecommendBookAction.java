package org.lsh.qing.action.main;

import java.util.List;

import org.lsh.qing.dao.ProductDAO;
import org.lsh.qing.entity.Book;

public class FindRecommendBookAction {
	private List<Book> books;
	private ProductDAO productDAO;

	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	public String execute() throws Exception {
		books = productDAO.findRecommendBook();
		return "success";
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

}
