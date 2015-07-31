package org.lsh.qing.entity;

import java.util.HashSet;
import java.util.Set;

public class Product implements java.io.Serializable {

	// Fields

	private Integer id;
	private String productName;
	private String description;
	private long addTime;
	private double fixedPrice;
	private double dangPrice;
	private String keywords;
	private Integer hasDeleted;
	private String productPic;
	private Set<Category> cates = new HashSet<Category>();
	private Set<Item> items = new HashSet<Item>();

	// Constructors

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	public Set<Category> getCates() {
		return cates;
	}

	public void setCates(Set<Category> cates) {
		this.cates = cates;
	}

	/** default constructor */
	public Product() {
	}

	/** minimal constructor */
	public Product(String productName, double fixedPrice, double dangPrice,
			Integer hasDeleted) {
		this.productName = productName;
		this.fixedPrice = fixedPrice;
		this.dangPrice = dangPrice;
		this.hasDeleted = hasDeleted;
	}

	/** full constructor */
	public Product(String productName, String description, long addTime,
			double fixedPrice, double dangPrice, String keywords,
			Integer hasDeleted, String productPic) {
		this.productName = productName;
		this.description = description;
		this.addTime = addTime;
		this.fixedPrice = fixedPrice;
		this.dangPrice = dangPrice;
		this.keywords = keywords;
		this.hasDeleted = hasDeleted;
		this.productPic = productPic;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getAddTime() {
		return this.addTime;
	}

	public void setAddTime(long addTime) {
		this.addTime = addTime;
	}

	public double getFixedPrice() {
		return this.fixedPrice;
	}

	public void setFixedPrice(double fixedPrice) {
		this.fixedPrice = fixedPrice;
	}

	public double getDangPrice() {
		return this.dangPrice;
	}

	public void setDangPrice(double dangPrice) {
		this.dangPrice = dangPrice;
	}

	public String getKeywords() {
		return this.keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public Integer getHasDeleted() {
		return this.hasDeleted;
	}

	public void setHasDeleted(Integer hasDeleted) {
		this.hasDeleted = hasDeleted;
	}

	public String getProductPic() {
		return this.productPic;
	}

	public void setProductPic(String productPic) {
		this.productPic = productPic;
	}

}