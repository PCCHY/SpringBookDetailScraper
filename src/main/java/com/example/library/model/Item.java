package com.example.library.model;

public class Item {
	private String title;
	private String url;
	private String price;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Item [title=" + title + ", url=" + url + ", price=" + price + "]";
	}
	
	
}
