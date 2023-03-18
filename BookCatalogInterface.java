//Kevin Cruz-Torres

package assg6_cruztorresk20;

import java.util.ArrayList;

public interface BookCatalogInterface {
	/**
	 * loads and fills data from book catalog 
	 * @param fileName
	 */
	public void loadData(String fileName);
	/**
	 * displays current book catalog
	 */
	public void displayCatalog();
	/**
	 * Searches for book with specified title
	 * @param title
	 * @return
	 */
	public Book searchForBook(String title);
	/**
	 * adds books to catalog with given properties
	 * @param isbn
	 * @param title
	 * @param author
	 * @param publisher
	 * @param publishingYear
	 * @return
	 */
	public boolean addBook(int isbn, String title, String author, String publisher, int publishingYear);
	/**
	 * updates given properties in book catalog
	 * @param isbn
	 * @param title
	 * @param author
	 * @param publisher
	 * @param publishingYear
	 * @return
	 */
	public boolean updateBook(int isbn, String title, String author, String publisher, int publishingYear);
	/**
	 * removes book based on title
	 * @param title
	 * @return
	 */
	public boolean removeBook(String title);
	/**
	 * returns book based on publisher
	 * @param publisher
	 * @return
	 */
	public ArrayList<Book> getBooksByPublisher(String publisher);
	/**
	 * sorts book in alphabetical order
	 */
	public void sortByTitle();
	/**
	 * saves current book catalog
	 * @param fileName2
	 */
	public void save(String fileName2);
}
