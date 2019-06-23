package com.creativepage.moviecatalogservice.models;

public class CatalogItem {
	
	private String title;
	private String desc;
	private int rating;
	
	
	
	public CatalogItem() {
		super();
	}
	public CatalogItem(String title, String desc, int rating) {
		super();
		this.title = title;
		this.desc = desc;
		this.rating = rating;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
}
