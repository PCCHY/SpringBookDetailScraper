package com.example.library.model;

public class Order {
	private static final long serialVersionUID = 1L;
	
	private String booking_id;
	private String ISBN;
	private String booking_date;
	private int quantity;
	
	@Override
	public String toString() {
		return "Order [booking_id=" + booking_id + ", ISBN=" + ISBN + ", booking_date=" + booking_date + ", quantity="
				+ quantity + "]";
	}

	public String getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(String booking_id) {
		this.booking_id = booking_id;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getBooking_date() {
		return booking_date;
	}

	public void setBooking_date(String booking_date) {
		this.booking_date = booking_date;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}
