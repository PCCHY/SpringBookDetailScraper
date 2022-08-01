package com.example.library.model;

public class Book {
	private String ISBN;
	private String title;
	private String cover;
	private String publisher;
	private String pages;
	private String available;
	
	@Override
	public String toString() {
		return "Book [ISBN=" + ISBN + ", title=" + title + ", cover=" + cover + ", publisher=" + publisher + ", pages="
				+ pages + ", available=" + available + "]";
	}

	public Book(String iSBN, String title, String cover, String publisher, String pages, String available) {
		super();
		ISBN = iSBN;
		this.title = title;
		this.cover = cover;
		this.publisher = publisher;
		this.pages = pages;
		this.available = available;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPages() {
		return pages;
	}

	public void setPages(String pages) {
		this.pages = pages;
	}

	public String getAvailable() {
		return available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}
	
}
