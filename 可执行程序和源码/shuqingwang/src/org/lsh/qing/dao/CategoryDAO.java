package org.lsh.qing.dao;

import java.util.List;

import org.lsh.qing.entity.Category;

public interface CategoryDAO {
	public List<Category> findAll(int id);

	public List<Category> findByParentId(int id);
}
