package com.lms.entities;

import java.util.HashMap;
import java.util.Map;

public class Patron {

	private String name;
	private String emailId;
	private String mobileNumber;
	
	 Map<Book, Integer> bookingHistory = new HashMap();
	 
	 

	public Patron(String name, String emailId, String mobileNumber) {
		super();
		this.name = name;
		this.emailId = emailId;
		this.mobileNumber = mobileNumber;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public String getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public void updateProfile(String name, 
			String emailId, String mobileNumber) {
		
		this.name = name;
		this.emailId = emailId;
		this.mobileNumber = mobileNumber;
		
	}


	public Map<Book, Integer> getBookingHistory() {
		return bookingHistory;
	}


	public void setBookingHistory(Map<Book, Integer> bookingHistory) {
		this.bookingHistory = bookingHistory;
	}
	
	public void addHistory(Book book) {
		bookingHistory.put(book, bookingHistory.getOrDefault(book, 0)+1);
	}
	
}
