// ------------------------------------------------------------
// Assignment 0
// Question 1
// Written by: Fred
// ------------------------------------------------------------

/**
 * This class makes Book objects, it includes an author, a title, an ISBN number and a price.
 * This class contains a constructor, mutators and getters, an equals method, a toString method and a static method.
 * 
 * @author Fred
 * @version 1
 */
package test;

public class Book {
	private String title;
	private String author;
	private long ISBN;
	private double price;
	private static int numOfBooks = 0;
	
	/**
	 * This is a custom constructor, it sets the title, author, ISBN and price to what the user inputed,
	 * it also adds 1 to the number of books created.
	 * 
	 * @param title the title of the book
	 * @param author the author of the book
	 * @param ISBN the ISBN number of the book
	 * @param price the price of the book
	 * @param numOfBooks the number of books created, we add 1 to this when this constructor is called
	 */
	public Book(String title, String author, long ISBN, double price) {
		this.title = title;
		this.author = author;
		this.ISBN = ISBN;
		this.price = price;
		numOfBooks += 1;
	}
	/**
	 * This method sets the title of a book to a new title.
	 * 
	 * @param newTitle the new title of the book
	 */
	public void setTitle(String newTitle) {
		this.title = newTitle;
	}
	/**
	 * This method sets the author of a book to a new author.
	 * 
	 * @param newAuthor the new author of that book
	 */
	public void setAuthor(String newAuthor) {
		this.author = newAuthor;
	}
	/**
	 * This method sets the ISBN number of a book to a new ISBN number.
	 * 
	 * @param newISBN the new ISBN number of that book
	 */
	public void setISBN(long newISBN) {
		this.ISBN = newISBN;
	}
	/**
	 * This method sets the price of a book to a new price.
	 * 
	 * @param newPrice the new price of the book
	 */
	public void setPrice(double newPrice) {
		this.price = newPrice;
	}
	/**
	 * This method returns the title of the book.
	 * 
	 * @return a String, the title
	 */
	public String getTitle() {
		return this.author;
	}
	/**
	 * This method returns the author of the book.
	 * 
	 * @return a String, the author
	 */
	public String getAuthor() {
		return this.author;
	}
	/**
	 * This method returns the ISBN number of the book.
	 * 
	 * @return a Long, the ISBN number
	 */
	public long getISBN() {
		return this.ISBN;
	}
	/**
	 * This method returns the price of the book.
	 * 
	 * @return a double, the price
	 */
	public double getPrice() {
		return this.price;
	}
	/**
	 * This method is static, so its not instance based, it returns te total number of books created.
	 * 
	 * @return a static int, the number of books created
	 */
	public static int findNumberOfCreatedBooks() {
		return numOfBooks;
	}
	/**
	 * This method returns if two books are equal, so if both their ISBN number and their price is the same.
	 * 
	 * @param book2 the book which you want to compare with
	 * @return a boolean, if the two books are equal
	 */
	public boolean equals(Book book2) {
		return this.ISBN == book2.ISBN && this.price == book2.price;
	}
	/**
	 * This method returns the author, the title, the ISBN number and the price of the book.
	 * 
	 * @return a String, the book's information
	 */
	public String toString() {
		return "Author: "+this.author+"\nTitle by: "+this.title+"\nISBN: "+this.ISBN+"\nPrice: "+this.price+"$";
	}
}

