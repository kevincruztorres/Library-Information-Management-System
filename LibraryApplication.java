//Kevin Cruz-Torres

package assg6_cruztorresk20;

//import java.util.*;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileWriter;
//import java.io.IOException;
import java.util.ArrayList;
//import java.util.Collections;
import java.util.Scanner;

/**
* class for the main program
* @author Kevin Cruz-Torres
*
*/
public class LibraryApplication{
  
	/**
	 * main method of LibraryApplication which 
	 * does different actions based on input
	 * @param args
	 */
  public static void main(String[] args) {
  	String fileName = "assg6_catalog.txt";
  	BookCatalog obj = new BookCatalog();
  	int choice = 0;
   
  	obj.loadData(fileName);
   
  	Scanner kbd = new Scanner(System.in);

  	System.out.println("\nWelcome to the Library Application!");
  	boolean exit = false;
  	
  	//While loop to 
  	while(!exit) {
		
  		System.out.println("Please select an option:");
  		System.out.println("1. Display all books");
  		System.out.println("2. Search for a book by title");
  		System.out.println("3. Add a new book");
  		System.out.println("4. Update an existing book");
  		System.out.println("5. Remove a book");
  		System.out.println("6. Get books by publisher");
  		System.out.println("7. Sort all books by title");
  		System.out.println("8. Save data to file");
  		System.out.println("9. Exit");
      
  		choice = kbd.nextInt();
      /**
       * switch statements which do specific tasks
       */
		switch(choice) {
				/*
				 * displays catalog
				 */
			case 1:
				obj.displayCatalog();
				break;
				/**
				 * Searches for book based on title
				 */
			case 2:
				String title1 = "";
				Scanner kbd1 = new Scanner(System.in);
				System.out.println("Please enter the title of the book: ");
				title1 = kbd1.nextLine();
				System.out.println(obj.searchForBook(title1));
				break;
				/**
				 * Enters new book
				 */
			case 3:
				String title = "";
				Scanner kbd3 = new Scanner(System.in);
				System.out.print("Please enter the title of the book: ");
			    title = kbd3.nextLine();
			    Book temp = obj.searchForBook(title);
			    
			    if(temp != null) {
			        System.out.println("***Book already exists. Try again.");
			        break;
			    }

			    System.out.println("Enter the ISBN: ");
			    int isbn = kbd3.nextInt();
			    kbd3.nextLine();

			    System.out.println("Enter the AUTHOR: ");
			    String author = kbd3.nextLine();

			    System.out.println("Enter the PUBLISHER: ");
			    String publisher = kbd3.nextLine();

			    System.out.println("Enter the PUBLISHING YEAR: ");
			    int year = kbd3.nextInt();
			    
			    obj.addBook(isbn, title, author, publisher, year);

			    System.out.println("***New book has been added to the catalog***");
			    break;
			    
			    /**
			     * Updates existing book
			     */
			case 4:
				System.out.print("Please enter the title of the book: ");
			    Scanner kbd4 = new Scanner(System.in);
			    String title11 = kbd4.nextLine();
			    Book temp1 = obj.searchForBook(title11);
				
				if(temp1 == null) {
					System.out.println("***Sorry, book does not exist. Try again.");
					break;
				}
				
				int option = -1;
				
				while(option !=0) {
					System.out.println("Select the information you would like to change:");
					System.out.println("1. ISBN");
					System.out.println("2. Author");
					System.out.println("3. Publisher");
					System.out.println("4. Year");
					System.out.println("0. Back to main menu");
					
					option = kbd4.nextInt();
					kbd4.nextLine();
					
					switch (option) {
		            case 1:
		                System.out.print("Enter the new ISBN: ");
		                int newIsbn = kbd.nextInt();
		                kbd.nextLine();
		                temp1.setIsbn(newIsbn);
		                System.out.println("***ISBN updated successfully.***");
		                break;
		            case 2:
		                System.out.print("Enter the new author: ");
		                String newAuthor = kbd4.nextLine();
		                temp1.setAuthor(newAuthor);
		                System.out.println("***Author updated successfully.***");
		                break;
		            case 3:
		                System.out.print("Enter the new publisher: ");
		                String newPublisher = kbd4.nextLine();
		                temp1.setPublisher(newPublisher);
		                System.out.println("***Publisher updated successfully.***");
		                break;
		            case 4:
		                System.out.print("Enter the new publishing year: ");
		                int newYear = kbd.nextInt();
		                kbd.nextLine();
		                temp1.setYear(newYear);
		                System.out.println("***Publishing year updated successfully.***");
		                break;
		            case 0:
		                System.out.println("***Returning to main menu...***");
		                break;
		            default:
		                System.out.println("***Invalid choice. Try again.***");
					}
				}
				break;
				/**
				 * removes book
				 */
			case 5:
				String title2 = "";
				Scanner kbd2 = new Scanner(System.in);
				System.out.println("Enter a title of a book: ");
				title2 = kbd2.nextLine();
				obj.removeBook(title2);
				break;
				/**
				 * Prints book based on publisher
				 */
			case 6:
				String publisher1 = "";
				Scanner kbd6 = new Scanner(System.in);
				System.out.println("Enter the publisher you wish to search: ");
				publisher1 = kbd6.nextLine();
				ArrayList<Book> a = obj.getBooksByPublisher(publisher1);
				if(a.size() == 0) {
					System.out.println("***no books***");
				}
				else {
					for(Book book : a) {
						System.out.println(book);
					}
				}
				break;
				/**
				 * Sorts by title
				 */
			case 7:
				obj.sortByTitle();
				break;
				/**
				 * saves catalog
				 */
			case 8:
				obj.save(fileName);
				break;
				/**
				 * exits program
				 */
			case 9:
				obj.exit();
				break;
				/**
				 * defaults to this when invalid choice is entered
				 */
			default:
				System.out.println("***Invalid choice. Try again***");
					break;
			}
		
			
		}
  	kbd.close();
		System.out.println("**Program has been successfully exited***");
	}
}
