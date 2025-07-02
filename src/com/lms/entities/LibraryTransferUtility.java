package com.lms.entities;

public class LibraryTransferUtility { 
	
	public void transferBooks(LibrarayInventory libInv,
			LibrarayInventory toLib, String bookName, int numberofBooks ) {
		
		if(libInv.isQuatityAvailable(bookName, numberofBooks)) {
			System.out.println("Quantity Available, Transfering books....");
		}else {
			System.out.println("Books unavilable, terminating....");
			return;
		}
		
		libInv.updateBookByOne(bookName, false);
		toLib.updateBookByOne(bookName, true);
		
	}
	

}
