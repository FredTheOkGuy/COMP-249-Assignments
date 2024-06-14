package other;


/**
 * This class creates Book objects that inherits from the Library class.
 * It inherits variables such as name, author, year of publication, ID and methods such a getters, setters and equals.
 * It contains a static int that keeps track of how many Books have been created and an int of the number of page of the book.
 * It has a toString method that displays all the book's values.
 * 
 * @author Fred
 * @version 1
 */
public class Book extends Library{
	protected static int bookNum;
	protected int numOfPages;
	
	
	/**
	 * The custom constructor calls the custom constructor of the parent class Library using super().
	 * It sets the name, author, year of publication, number of pages and the ID of the Book object.
	 * Adds 1 to bookNum as it creates a Book object.
	 * 
	 * @param newName
	 * @param newAuthor
	 * @param newYearPub
	 * @param newNumOfPages
	 */
	public Book(String newName, String newAuthor, int newYearPub, int newNumOfPages) {
		super(newName, newAuthor, newYearPub);
		this.ID = "B"+bookNum++;
		this.numOfPages = newNumOfPages;
	}
	
	
	/**
	 * This is the default constructor, it calls the default constructor of the parent class Library using super().
	 * Sets the numOfPages to 0 and adds 1 to bookNum.
	 */
	public Book() {
		super();
		this.numOfPages = 0;
		this.ID = "B"+bookNum++;
	}
	
	
	/**
	 * This is the copy constructor, sets the values of the book to the selected book.
	 * Adds 1 to bookNum.
	 * 
	 * @param newBook The book that is copied, Book.
	 */
	public Book(Book newBook) {
		this(newBook.name, newBook.author, newBook.yearPub, newBook.numOfPages);
		this.ID = "B"+bookNum++;
	}
	
	
	/**
	 * The toString method that displays all the book's information.
	 * 
	 * @return Returns a String containing all the book's information.
	 */
	public String toString() {
		return "Book ID: "+this.ID +"\nBook name: "+this.name+"\nAuthor name: "+this.author+"\nYear of publication: "+this.yearPub+"\nNumber of pages: "+this.numOfPages;
	}
	
	
	/**
	 * A method to show how many pages a book have.
	 * 
	 * @return Returns an int of how many pages the book has
	 */
	public int getNumOfPages() {
		return this.numOfPages;
	}
	
	
	/**
	 * A method that changes the amount of pages of a book.
	 * 
	 * @param newNumOfPages The new value of pages.
	 */
	public void setNumOfPages(int newNumOfPages) {
		this.numOfPages = newNumOfPages;
	}
	
	
	/**
	 * A method that shows how many books were created.
	 * 
	 * @return Returns an int of how many books were created.
	 */
	public static int getNumOfBooks() {
		return bookNum;
	}
	
	
	/**
	 * A method that changes the value of how many books were created.
	 * Used when deleting a book.
	 * 
	 * @param newValue The new value of the number of books.
	 */
	public static void setNumOfBook(int newValue) {
		bookNum = newValue;
	}
	
	
	

}
