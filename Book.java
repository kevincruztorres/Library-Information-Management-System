//Kevin Cruz-Torres

package assg6_cruztorresk20;

/**
 * Book class represents a book object 
 * with title, author, publisher, ISBN, and 
 * publishing year
 * @author Kevin Cruz-Torres
 *
 */
public class Book implements Comparable <Book>{
	private String title, author, publisher;
	private int isbn, publishingYear;
	
	/**
	 * Constructs a Book object with the given properties below
	 * @param isbn
	 * @param title
	 * @param author
	 * @param publisher
	 * @param publishingYear
	 */
	public Book(int isbn, String title, String author, String publisher, int publishingYear) {
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.isbn = isbn;
		this.publishingYear = publishingYear;
	}
	
	/**
	 * Gets ISBN of book
	 * @return
	 */
	public int getIsbn() {
        return isbn;
    }
    
	/**
	 * Gets title of book
	 * @return
	 */
    public String getTitle() {
        return title;
    }
    
    /**
     * gets author of book
     * @return
     */
    public String getAuthor() {
        return author;
    }
    
    /**
     * gets publisher of book
     * @return
     */
    public String getPublisher() {
        return publisher;
    }
    
    /**
     * gets year of book
     * @return
     */
    public int getYear() {
        return publishingYear;
    }
    
    /**
     * sets isbn of book
     * @param isbn
     */
    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }
    
    /**public void setTitle(String title) {
		this.title = title;
		
	}*/
    
    /**
     * sets author of book
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }
    
    /**
     * sets publisher of book
     * @param publisher
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    
    /**
     * sets year of book
     * @param publishingYear
     */
    public void setYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }
	
    /**
     * Returns string of book's properties
     */
	public String toString() {
	    return "\n" + isbn + "\n" + title + "\n" + author + "\n" + publisher + "\n" + publishingYear + "\n";
	}
	
	/**
	 * compares book object to specified object
	 */
	@Override
	public boolean equals(Object book) {
		if(book == this) {
			return true;
		}
		if(!(book instanceof Book)) {
			return false;
		}
		Book otherBook = (Book) book;
        return this.title.equals(otherBook.title);
	}
	
	/**
	 * compares book based on title
	 */
	@Override
	public int compareTo(Book that) {
		return this.title.compareTo(that.title);
	}
}
