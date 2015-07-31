package org.lsh.qing.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.lsh.qing.dao.BaseDAO;
import org.lsh.qing.dao.ProductDAO;
import org.lsh.qing.entity.Book;
import org.lsh.qing.entity.Category;
import org.lsh.qing.entity.Item;
import org.lsh.qing.entity.Product;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

@Repository("productDAO")
public class HibernateProductDAO extends BaseDAO implements ProductDAO {

	@SuppressWarnings("unchecked")
	// 新书
	public List<Product> findHotNewBook(final int size) {
		List<Product> list = (List<Product>) this.getHibernateTemplate()
				.execute(new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						String hql = "from Product "
								+ "order by add_time desc ";
						Query query = session.createQuery(hql);
						query.setFirstResult(1);
						query.setMaxResults(8);
						return query.list();
					}
				});

		return list;
	}

	@SuppressWarnings("unchecked")
	// 推荐图书
	public List<Book> findRecommendBook() {
		List<Book> list = (List<Book>) this.getHibernateTemplate().execute(
				new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						String hql = "from Book order by rand()";
						Query query = session.createQuery(hql);
						query.setFirstResult(1);
						query.setMaxResults(2);
						return query.list();
					}
				});

		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Book> findBooksByCatId(final int cid, final int page,
			final int pageSize) {
		List<Book> list = (List<Book>) this.getHibernateTemplate().execute(
				new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						String hql = "select c.books from Category c where c.id=?";
						Query query = session.createQuery(hql);
						query.setInteger(0, cid);
						query.setFirstResult((page - 1) * pageSize);
						query.setMaxResults(pageSize);
						return query.list();
					}
				});

		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Book> findBooksByCatId(final int cid) {
		String hql = "select c.books from Category c where c.id=?";
		Object[] params = { cid };
		List<Book> list = this.getHibernateTemplate().find(hql, params);
		System.out.println(list.size());
		return list;
	}

	@SuppressWarnings("unchecked")
	public int findNumByCat_id(final int catId, int pageSize) {
		List<Category> list = (List<Category>) this.getHibernateTemplate()
				.execute(new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session
								.createQuery("from Category where id=?");
						query.setInteger(0, catId);
						return query.list();
					}
				});
		int totalRows = list.get(0).getPnum();
		// 计算总页数
		// 根据totalRows和pageSize计算总页数totalPages
		if (totalRows == 0) {
			return 1;// 没有记录认为1页
		} else if (totalRows % pageSize == 0) {
			return totalRows / pageSize;
		} else {
			return totalRows / pageSize + 1;
		}
	}

	// 根据id查找产品
	public Product findById(int id) {
		Product pro = (Product) this.getHibernateTemplate().get(Product.class,
				id);
		return pro;
	}

	@SuppressWarnings("unchecked")
	// 热门图书
	public List<Product> findHotBook(final int size) {
		List<Product> list = (List<Product>) this.getHibernateTemplate()
				.execute(new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						String hql = "from Product p join fetch p.items i group by p.id order by sum(i.productNum)";
						// String
						// hql="from Item i join fetch i.product p group by p.id order by sum(i.productNum)";
						Query query = session.createQuery(hql);
						query.setFirstResult(1);
						query.setMaxResults(4);
						return query.list();
					}
				});
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Item> find(final int size) {
		List<Item> list = (List<Item>) this.getHibernateTemplate().execute(
				new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						String hql = "from Product p join fetch p.items i group by p.id order by sum(i.productNum)";
						Query query = session.createQuery(hql);
						query.setFirstResult(1);
						query.setMaxResults(size);
						return query.list();
					}
				});
		return list;
	}
}
