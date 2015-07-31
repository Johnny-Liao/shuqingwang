package org.lsh.qing.entity;

import java.util.List;
import java.util.Set;

public class Category implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer turn;
	private String enName;
	private String name;
	private String description;
	private Integer parentId;
	// 用于储存商品信息
	private List<Book> books;
	private List<Category> listCates;
	// 用于储存 商品商量
	private int pnum;

	// Constructors
	
	/** default constructor */
	public Category() {
	}

	/** minimal constructor */
	public Category(Integer turn, String enName, String name) {
		this.turn = turn;
		this.enName = enName;
		this.name = name;
	}

	/** full constructor */
	public Category(Integer turn, String enName, String name,
			String description, Integer parentId) {
		this.turn = turn;
		this.enName = enName;
		this.name = name;
		this.description = description;
		this.parentId = parentId;
	}

	// Property accessors
	
	public List<Category> getListCates() {
		return listCates;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public void setListCates(List<Category> listCates) {
		this.listCates = listCates;
	}

	public int getPnum() {
		return pnum;
	}

	public void setPnum(int pnum) {
		this.pnum = pnum;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTurn() {
		return this.turn;
	}

	public void setTurn(Integer turn) {
		this.turn = turn;
	}

	public String getEnName() {
		return this.enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

}