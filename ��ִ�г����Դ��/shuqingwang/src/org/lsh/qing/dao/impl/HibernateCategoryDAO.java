package org.lsh.qing.dao.impl;

import java.util.List;

import org.lsh.qing.dao.BaseDAO;
import org.lsh.qing.dao.CategoryDAO;
import org.lsh.qing.entity.Category;
import org.springframework.stereotype.Repository;

@Repository("categoryDAO")
public class HibernateCategoryDAO extends BaseDAO implements CategoryDAO {

	// 按parentId当条件查询类别， 并且将subCats子类别集合加载
	@SuppressWarnings("unchecked")
	public List<Category> findAll(int id) {
		String hql = "select distinct c " + "from Category c "
				+ "join fetch c.listCates " + "where c.parentId=?";
		Object[] params = { id };
		List<Category> list = this.getHibernateTemplate().find(hql, params);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Category> findByParentId(int id) {
		String hql = "from Category where parentId=?";
		Object[] params = { id };
		List<Category> list = this.getHibernateTemplate().find(hql, params);
		return list;
	}

}
