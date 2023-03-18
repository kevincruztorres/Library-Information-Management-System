//Kevin Cruz-Torres

package assg6_cruztorresk20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.*;
import java.io.FileWriter;


public class BookCatalog implements BookCatalogInterface{
	
	private ArrayList<Book> bookList;
    @SuppressWarnings("unused")
	private boolean isModified;
	@SuppressWarnings("unused")
	private String fileName;
	public BookCatalog() {
		bookList = new ArrayList<Book>();
	}
	
	/*
	 * loads and fills data from catalog
	 */
	public void loadData(String fileName) {
		
		try {
			this.fileName = fileName;
			Scanner inputStream = null;
			
			inputStream = new Scanner(new File(fileName));
			@SuppressWarnings("unused")
			Book book = null;
			
			while(inputStream.hasNext()) {
				int isbn = inputStream.nextInt();
				inputStream.nextLine();
				String title = inputStream.nextLine();
				String author = inputStream.nextLine();
				String publisher = inputStream.nextLine();
				int publishingYear = inputStream.nextInt();
				
				bookList.add(new Book(isbn, title, author, publisher, publishingYear));
			}
			inputStream.close();
		} catch (FileNotFoundException e) {
			System.out.println("Oh No! File not found!");
		}
	}
	
	/**
	 * displays catalog
	 */
	public void displayCatalog() {
		if(bookList == null) {
			System.out.println("***The list of books is empty***");
		}
		else {
			for(Book b : bookList) {
				System.out.println(b.toString());
			}
			System.out.println("");
		}

	}
	/**
	 * Searches for book based on title
	 */
	public Book searchForBook(String title) {
		for(Book book : bookList) {
			if(title.equalsIgnoreCase(book.getTitle())) {
				return book;
			}
		}
		return null;
		
	}
	
	/**
	 * Enters new book
	 */
	public boolean addBook(int isbn, String title, String author, String publisher, int publishingYear) {
	    for (Book book : bookList) {
	        if (book.getTitle().equals(title)) {
	            System.out.println("***Book Already Exists***");
	            return false;
	        }
	    }
	    bookList.add(new Book(isbn, title, author, publisher, publishingYear));   
	    return true;

	}
	/**
	 * Updates existing book
	 */
	public boolean updateBook(int isbn, String title, String author, String publisher, int publishingYear) {
		for (Book book : bookList) {
	        if (title.equalsIgnoreCase(book.getTitle())) {
	            book.setIsbn(isbn);
	            book.setAuthor(author);
	            book.setPublisher(publisher);
	            book.setYear(publishingYear);
	            isModified = true;
	            return true;
	        }
	    }
		System.out.println("***Sorry, book does not exist. Try again.***");
		return false;
	}
	/**
	 * removes book
	 */
	public boolean removeBook(String title) {
	    boolean bookRemoved = false;
	    for (Book book : bookList) {
	        if (book.getTitle().compareTo(title) == 0) {
	            bookList.remove(book);
	            bookRemoved = true;
	            break;
	        }
	    }
	    if (bookRemoved) {
	        System.out.println("Book removed successfully.");
	    } else {
	        System.out.println("Book not found.");
	    }
		return bookRemoved;
	}
	
	/**
	 * Prints book based on publisher
	 */
	public ArrayList<Book> getBooksByPublisher(String publisher) {
		ArrayList<Book> booksByPublisher = new ArrayList<Book>();
	    for (Book book : bookList) {
	        if (book.getPublisher().equals(publisher)) {
	            //System.out.println(book);
	        	booksByPublisher.add(book);
	        }
	    }
	    return booksByPublisher;
	}
	
	/**
	 * Sorts by title
	 */
	public void sortByTitle() {
		 Collections.sort(bookList);
		    for (Book book : bookList) {
		        System.out.println(book);
		    }
		}
	
	/**
	 * exits program
	 */
	public void exit() {
		boolean isModified = true;
		if(isModified) {
			save("assg6_catalog.txt");
		}
		System.out.println("***Exiting program***");
	    System.exit(0);
		//return isModified;
	}

	/**
	 * saves catalog
	 */
	public void save(String string) {
		String fileName = "assg6_catalog.txt";
		try {
			PrintWriter outputStream = new PrintWriter(new FileWriter(fileName));
			for (Book book : bookList) {
                outputStream.println(book);
                outputStream.println();
				}
			outputStream.close();
			System.out.println("***File Successfully Saved***");
		}catch(IOException e){
			System.out.println("Error opening file " + fileName);
		}
		
	}
}
