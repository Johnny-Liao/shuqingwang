package org.lsh.qing.action.main;

import java.util.List;

import org.lsh.qing.action.BaseAction;
import org.lsh.qing.dao.CategoryDAO;
import org.lsh.qing.dao.ProductDAO;
import org.lsh.qing.entity.Book;
import org.lsh.qing.entity.Category;

public class BookListAction extends BaseAction {
	// input
	private int pid;// �����ID
	private int cid;// ��ǰ���ID
	private int page = 1;// ��ʾ�ڼ�ҳ��Ĭ�ϵ�һҳ
	// output
	private List<Category> cats;// ����pid��ȡ�������
	private int totalNum;// ȫ������
	private List<Book> books;// �м��Ʒ�б���Ϣ
	// injection
	private int pageSize = 3;// ÿҳ��ʾ3��
	private int totalPage;// ��������
	private CategoryDAO categoryDAO;
	private ProductDAO productDAO;

	public String execute() throws Exception {
		cats = categoryDAO.findByParentId(pid); // �����ܷ����ҳ������ӷ���
		for (Category c : cats) {
			totalNum += c.getPnum(); // ��ȡ����
		}
		books = productDAO.findBooksByCatId(cid, page, pageSize); // ���е��鼮�б�
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
