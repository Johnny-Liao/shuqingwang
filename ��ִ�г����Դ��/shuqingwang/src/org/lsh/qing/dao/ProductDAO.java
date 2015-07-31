package org.lsh.qing.dao;

import java.util.List;

import org.lsh.qing.entity.Book;
import org.lsh.qing.entity.Item;
import org.lsh.qing.entity.Product;

public interface ProductDAO {
	public List<Product> findHotNewBook(int size);

	public List<Book> findRecommendBook();

	public List<Book> findBooksByCatId(int cid, int page, int pageSize);

	public List<Book> findBooksByCatId(int cid);

	public int findNumByCat_id(int cat_id, int pageSize);

	public Product findById(int id);

	public List<Product> findHotBook(int size);

	public List<Item> find(final int size);
}
