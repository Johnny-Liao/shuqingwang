package org.lsh.qing.action.main;

import java.util.List;

import org.lsh.qing.dao.CategoryDAO;
import org.lsh.qing.entity.Category;

public class CategoryAction {

	private List<Category> cats;
	private CategoryDAO categoryDAO;

	public String execute() throws Exception {
		// 返回parentId=1的Category对象
		cats = categoryDAO.findAll(1);
		return "success";
	}

	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

	public List<Category> getCats() {
		return cats;
	}

	public void setCats(List<Category> cats) {
		this.cats = cats;
	}

}
