package other;


/**
 * The Library class is the parent class of the Book, Journal and Media classes. It contains 4 variables, ID, name, author and yearPub.
 * It has a default constructor, custom constructor ad a copy constructor. It also contains an equals method, setters and getters.
 * 
 * @author Fred
 * @version 1
 */
public class Library {
	protected String ID;
	protected String name;
	protected String author;
	protected int yearPub;

	
	
	/**
	 * Default constructor, sets the name and author to N/A and the year of publication to 0.
	 * Does not affect the ID since the ID is special to each child class.
	 */
	public Library() {
		name = "N/A";
		author = "N/A";
		yearPub = 0;
	}
	
	
	/**
	 * The custom constructor sets the values of name, author and year of pub.
	 * Does not affect ID since it is special to each child class.
	 * 
	 * @param newName The name of the object, String.
	 * @param newAuthor The author of the object, String.
	 * @param newYearPub The year of publication of the object, int.
	 */
	public Library(String newName, String newAuthor, int newYearPub) {
		name = newName;
		author = newAuthor;
		yearPub = newYearPub;
	}
	
	
	/**
	 * The copy constructor sets the values to the same as the other Library object selected.
	 * Does not affect the ID since it is unique to each child class.
	 * 
	 * @param otherLib The Library object that is copied, Library.
	 */
	public Library(Library otherLib) {
		this(otherLib.name, otherLib.author, otherLib.yearPub);
	}
	
	
	/**
	 * Equals method that checks if two objects are the same. It first checks if the two objects are of the same class.
	 * Then looks if they have the same name, author and year of publication.
	 * 
	 * @param otherItem The other Library object that is compared.
	 * @return Returns a boolean of if the two objects are equal.
	 */
	public boolean equals(Library otherItem) {
		if((this.getClass() == otherItem.getClass()) && otherItem != null)
			return this.name == otherItem.name && this.author == otherItem.author && this.yearPub == otherItem.yearPub;
		else
			return false;
	}
	
	
	/**
	 * Getter method for the ID.
	 * 
	 * @return Returns a String of the ID of the object.
	 */
	public String getID() {
		return this.ID;
	}
	
	
	/**
	 * Getter method for the name.
	 * 
	 * @return Returns a String of the name of the object.
	 */
	public String getName() {
		return this.name;
	}
	
	
	/**
	 * Getter method for the author's name.
	 * 
	 * @return Returns a String of the author's name.
	 */
	public String getAuthor() {
		return this.author;
	}
	
	
	/**
	 * Getter method for the year of publication.
	 * 
	 * @return Returns an int of the year of publication.
	 */
	public int getYearPub() {
		return this.yearPub;
	}
	
	
	/**
	 * Setter method for the ID.
	 * 
	 * @param newID The new value of the ID, String.
	 */
	public void setID(String newID) {
		this.ID = newID;
	}
	
	
	/**
	 * Setter method for the name.
	 * 
	 * @param newName The new value of the name, String.
	 */
	public void setName(String newName) {
		this.name = newName;
	}
	
	
	/**
	 * Setter method for the author's name.
	 * 
	 * @param newAuthor The new value of the author's name, String.
	 */
	public void setAuthor(String newAuthor) {
		this.author = newAuthor;
	}
	
	
	/**
	 * Setter method for the year of publication.
	 * 
	 * @param newYearPub The new value of the year of publication, int.
	 */
	public void setYearPub(int newYearPub) {
		this.yearPub = newYearPub;
	}
}
