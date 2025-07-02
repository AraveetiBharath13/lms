package lms;

import java.time.LocalDate;

import com.lms.entities.Book;
import com.lms.entities.LibrarayInventory;
import com.lms.entities.Patron;
import com.lms.entities.RigidBookReservationStrategy;

public class LibraryManagementSystem {

	public static void main(String[] args) {
		
		LibrarayInventory bookInv = new LibrarayInventory("Kokapet",
				new RigidBookReservationStrategy(),"Hyderabad");
		
		
		Book book1 = new Book("The Hobbit", "J.R.R. Tolkien", "9780547928227", 1937, 4);
        Book book2 = new Book("Pride and Prejudice", "Jane Austen", "9781503290563", 1813, 6);
        Book book3 = new Book("The Catcher in the Rye", "J.D. Salinger", "9780316769488", 1951, 1);
        
        Patron patron1 = new Patron("Aarav Singh", "aarav.singh@example.com", "9876543210");
        Patron patron2 = new Patron("Meera Patel", "meera.patel@example.com", "9123456789");

        bookInv.addPatron(patron2);
        bookInv.addPatron(patron1);
        
        bookInv.addBook(book3);
        bookInv.addBook(book1);
        bookInv.addBook(book2);
        
        System.out.println("Available Books :");
        System.out.println(" ");
        bookInv.showAvailableBooks();
        
        System.out.println(" ");
        System.out.println("-----------------------------------");
        
        System.out.println("Cuurent Bookings :");
        System.out.println(" ");
        
        bookInv.issueBook(patron2, book3, LocalDate.now()
        		, LocalDate.now().plusDays(3));
        
        System.out.println(bookInv.getCurrentBookings());
        
        System.out.println(" "); 
        System.out.println("-----------------------------------");
        
        bookInv.issueBook(patron1, book3, LocalDate.now()
        		, LocalDate.now().plusDays(3));
        
        bookInv.reserveBook(2, book3.getBookTitle(), patron1);
        
        System.out.println(" ");
        System.out.println("-----------------------------------");
        
        bookInv.reserveBook(2, "ABC return Homes", patron1);
        
        
        
        
        
        
        
        
	}
}
