package com.lms.entities; 

import java.util.stream.Collectors;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

public class LibrarayInventory { 

	private String branchName;
	
	Map<String, Book> booksAvailable = new HashMap<>();;
	
	public BookReservationStrategy bookReservationStrategy;
	
	private String address;
	
	private Map<Patron, Boolean> activePatrons = new HashMap<>();
	
	Map<Patron, List<BookReservation>> currentBookings =  new HashMap<>();
	
	
	
	
	public Map<String, Book> getBooksAvailable() {
		return this.booksAvailable;
	}
	public void setBooksAvailable(Map<String, Book> booksAvailable) {
		this.booksAvailable = booksAvailable;
	}
	public BookReservationStrategy getBookReservationStrategy() {
		return bookReservationStrategy;
	}
	public void setBookReservationStrategy(BookReservationStrategy bookReservationStrategy) {
		this.bookReservationStrategy = bookReservationStrategy;
	}
	public Map<Patron, List<BookReservation>> getCurrentBookings() {
		return currentBookings;
	}
	public void setCurrentBookings(Map<Patron, List<BookReservation>> currentBookings) {
		this.currentBookings = currentBookings;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Map<Patron, Boolean> getActivePatrons() {
		return activePatrons;
	}
	public void setActivePatrons(Map<Patron, Boolean> activePatrons) {
		this.activePatrons = activePatrons;
	}

	
	
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	
	// adding new Book
	public void addBook(Book book) {
		
		
//		int updateNumber = book.getNumberOfCopiesAvailable() + 1;
//		book.setNumberOfCopiesAvailable(updateNumber);
		this.booksAvailable.put(book.getBookTitle(), book);
		
	}
	
	// removing Book
	public void removeBook(String bookName) {
		
		this.booksAvailable.remove(bookName);
		
	}
	
	public void showAvailableBooks() {
		
		for(Book book : this.booksAvailable.values()) {
			System.out.println(book);
		}
		
	}
	
	// search Book by title
	public void searchBooksByTitle(String searchkey){
		
		 System.out.println(this.booksAvailable.get(searchkey));
		
	}
	
	public void searchBooksByAuth(String searchkey){
		
		List<Book> books = this.booksAvailable.values().stream()
				   .filter(b -> b.getAuthor().equalsIgnoreCase(searchkey))
				   .collect(Collectors.toList());
	 
	 	System.out.println(books);
			
	}

	public void searchBooksByISBN(String searchkey){
		
		 List<Book> books = this.booksAvailable.values().stream()
					   .filter(b -> b.getISBN().equalsIgnoreCase(searchkey))
					   .collect(Collectors.toList());
		 
		 	System.out.println(books);
			
	}
	
	// adding new patron
	public void addPatron(Patron patron) {
		
		this.getActivePatrons().put(patron, true);
		
			
	}
	
	// removing patron
	public void removePatron(Patron patron) {
		
		this.getActivePatrons().put(patron, false);
	}
	
	// updating available number of books
	public boolean updateBookByOne(String bookName, boolean bool) {
		
		Book book = this.booksAvailable.get(bookName);
		int updatedNumber = 0;
		if(bool) {
		  updatedNumber = book.getNumberOfCopiesAvailable() -1;
		}
		else {
	     updatedNumber = book.getNumberOfCopiesAvailable() + 1;
		}
	    book.setNumberOfCopiesAvailable(updatedNumber);
	    
	    addBook(book);
	    
	    return true;
	}
	
	
	public LibrarayInventory(String branchName, BookReservationStrategy bookReservationStrategy, String address) {
		super();
		this.branchName = branchName;
		this.bookReservationStrategy = bookReservationStrategy;
		this.address = address;
	}
	
	// Finds the Book name available
	public Boolean isBookAvialble(String bookName) {
		
		 return this.booksAvailable.get(bookName).getNumberOfCopiesAvailable() > 0; 
	}
	
	
	// issuing a new book
	public void issueBook(Patron patron, 
			Book book,LocalDate fromDate, LocalDate toDate) {
		
		if(this.booksAvailable.get(book.getBookTitle()) == null) {
			System.out.print("This Book will be available soon :)");
		}
		
		if(this.isBookAvialble(book.getBookTitle())) {
			
			BookReservation bookReservation = BookReservation.issueBook(patron, 
					book, toDate, fromDate, this.getBranchName());
			
			List<BookReservation> list = this.currentBookings.get(patron);
			
			if(list != null) {
				list.add(bookReservation);
				this.currentBookings.put(patron, list);
			}else {
				list = new ArrayList<BookReservation>();
				list.add(bookReservation);
				this.currentBookings.put(patron, list);
				
			}
		
		
			updateBookByOne(book.getBookTitle(), true);
		}else {
			System.out.print(book.getBookTitle() + " book is unavailable right now, please reserve book");
		}
		
		
	}
	
	// overloaded to reserve the book future purpose
	 
	public BookReservation issueBooks(Patron patron, 
			Book book,LocalDate fromDate, LocalDate toDate) {
		
		if(this.booksAvailable.get(book.getBookTitle()) == null) {
			System.out.print("This Book will be available soon :)");
		}
		
		BookReservation bookReservation = null;
		
		
			
			 bookReservation = BookReservation.issueBook(patron, 
					book, toDate, fromDate, this.getBranchName());
			
			List<BookReservation> list = this.currentBookings.get(patron);
			
			if(list != null) {
				list.add(bookReservation);
				this.currentBookings.put(patron, list);
			}else {
				list = new ArrayList<BookReservation>();
				list.add(bookReservation);
				this.currentBookings.put(patron, list);
				
			}
			
		
		return bookReservation;
	}
	
	private boolean isBookExists(String bookTitle) {
		
		return this.booksAvailable.get(bookTitle) != null; 
	}
	
	// returning book 
	public void returnBook(Patron patron, String  bookingId ) {
		
		List<BookReservation> brs = currentBookings.get(patron);
		
		Optional<BookReservation> brOp
							   =	brs.stream()
									  .filter(br -> br.getReservationId().contentEquals(bookingId))
									  .findFirst();
	
		if(!bookReservationStrategy.checkIsBookReserved(brOp.get())) {
			
			updateBookByOne(brOp.get().getBook().getBookTitle(), false);
		}
		
		patron.addHistory(brOp.get().getBook());
		
		brs.remove(brOp.get());
		
		
	}
	
	// checking the book available or not
	public boolean isQuatityAvailable(String bookName, int quantity) {
		
		return this.booksAvailable.get(bookName)
				       .getNumberOfCopiesAvailable() >= quantity;
	}
	
	public void reserveBook(int numberOfDays, String bookName, Patron patron) {
		
		this.getBookReservationStrategy().reserveBook(this, numberOfDays, bookName, patron);
	}

	
}
