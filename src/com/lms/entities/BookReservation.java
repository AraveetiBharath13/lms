package com.lms.entities;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class BookReservation {
	
	private String reservationId;
	private Patron patron;
	private Book book;
	private LocalDate fromDate;
	private LocalDate reservationDate;
	private String invName;
	
	
	
	
	private BookReservation(String reservationId, Patron patron, Book book, LocalDate toDate,
		LocalDate fromDate2, String invName) {
		super();
		this.reservationId = reservationId;
		this.patron = patron;
		this.book = book;
		this.fromDate = fromDate2;
		this.reservationDate = toDate;
		this.invName = invName;
	}
	
	
	
	public String getInvName() {
		return invName;
	}



	public LocalDate getFromDate() {
		return fromDate;
	}



	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}



	public void setInvName(String invName) {
		this.invName = invName;
	}



	public String getReservationId() {
		return reservationId;
	}
	public void setReservationId(String reservationId) {
		this.reservationId = reservationId;
	}
	public Patron getPatron() {
		return patron;
	}
	public void setPatron(Patron patron) {
		this.patron = patron;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public LocalDate getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(LocalDate reservationDate) {
		this.reservationDate = reservationDate;
	}
	
	public static BookReservation issueBook(Patron patron, Book books, LocalDate toDate,LocalDate fromDate2, String invName ) {
		 
		return new BookReservation(Math.random()+"",patron,books,toDate, fromDate2, invName);
	}



	@Override
	public String toString() {
		return "BookReservation [reservationId=" + reservationId + ", patron=" + patron + ", book=" + book
				+ ", fromDate=" + fromDate + ", reservationDate=" + reservationDate + ", invName=" + invName + "]";
	}
	
	

}
