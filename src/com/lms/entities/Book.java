package com.lms.entities;

public class Book {
	
	private String bookTitle;
	private String author;
	private String ISBN;
	private int year;
	
	private int NumberOfCopiesAvailable;
	
	
	
	public Book(String bookTitle, String author, String iSBN, int year, int numberOfCopiesAvailable) {
		super();
		this.bookTitle = bookTitle;
		this.author = author;
		ISBN = iSBN;
		this.year = year;
		NumberOfCopiesAvailable = numberOfCopiesAvailable;
	}
	
	public int getNumberOfCopiesAvailable() {
		return NumberOfCopiesAvailable;
	}
	public void setNumberOfCopiesAvailable(int numberOfCopiesAvailable) {
		NumberOfCopiesAvailable = numberOfCopiesAvailable;
	} 
	public String getBookTitle() {
		return bookTitle; 
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	} 
	public String getAuthor() {  
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Book [bookTitle=" + bookTitle + ", author=" + author + ", ISBN=" + ISBN + ", year=" + year
				+ ", NumberOfCopiesAvailable=" + NumberOfCopiesAvailable + "]";
	}
	
	
	
	

}
