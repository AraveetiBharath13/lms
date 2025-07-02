package com.lms.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface BookReservationStrategy {
	 
	public static final Map<BookReservation, Patron> reservedBooks = new HashMap();
	
	boolean checkIsBookReserved(BookReservation bookReservation);
	void reserveBook(LibrarayInventory libInv, int numberOfDays, String BookName, Patron patron);
	
}
