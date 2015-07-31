package org.lsh.qing.action.main;

import java.util.List;

import org.lsh.qing.action.BaseAction;
import org.lsh.qing.dao.CategoryDAO;
import org.lsh.qing.dao.ProductDAO;
import org.lsh.qing.entity.Book;
import org.lsh.qing.entity.Category;

public class BookListAction extends BaseAction {
	// input
	private int pid;// 父类别ID
	private int cid;// 当前类别ID
	private int page = 1;// 显示第几页，默认第一页
	// output
	private List<Category> cats;// 根据pid获取的子类别
	private int totalNum;// 全部数量
	private List<Book> books;// 中间产品列表信息
	// injection
	private int pageSize = 3;// 每页显示3条
	private int totalPage;// 分类数量
	private CategoryDAO categoryDAO;
	private ProductDAO productDAO;

	public String execute() throws Exception {
		cats = categoryDAO.findByParentId(pid); // 根据总分类找出所有子分类
		for (Category c : cats) {
			totalNum += c.getPnum(); // 获取总数
		}
		books = productDAO.findBooksByCatId(cid, page, pageSize); // 所有的书籍列表
		totalPage = productDAO.findNumByCat_id(cid, pageSize);
		return "success";
	}

	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}

	public List<Category> getCats() {
		return cats;
	}

	public void setCats(List<Category> cats) {
		this.cats = cats;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
