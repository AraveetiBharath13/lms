package com.lms.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class RigidBookReservationStrategy implements BookReservationStrategy{

	
	
	public void reserveBook(LibrarayInventory libInv, int numberOfDays, String bookName, Patron patron) {
		
	
		Optional<BookReservation> brOps = libInv.getCurrentBookings().values().stream()
					.flatMap(List::stream)
					.filter(b -> b.getBook().getBookTitle().equals(bookName)).findFirst();
		
		if(brOps.isEmpty()) {
			
				System.out.print(bookName + " book is unavailable right now, will be availble soon"
						+ " Please reserve books which are availble in the list");
			return ;
		}
		
		LocalDate fromDate = LocalDate.now();//. .get().getReservationDate();
		fromDate = fromDate.plusDays(1);
		LocalDate toDate = fromDate.plusDays(numberOfDays) ;
		
		BookReservation bookReservation = 
				 libInv.issueBooks(patron, brOps.get().getBook(), fromDate, toDate );
		
		
		 System.out.println(" ");
		
		 if(bookReservation != null)
		 {
				System.out.println("Hey " + patron.getName() + " you have "
						+ "successfully reserved book " + bookName 
						+ " from " + bookReservation.getFromDate() 
						+ " to " + bookReservation.getReservationDate() + " Happy Learning :)");
		 }
		
	}

	
	public boolean checkIsBookReserved(BookReservation brOps) {
		
		return reservedBooks.get(brOps) == null? false : true;
	}

	
	 
	
	
	

}
