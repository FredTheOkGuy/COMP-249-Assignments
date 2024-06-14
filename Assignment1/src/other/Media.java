package other;

/**
 * This class creates Media objects which extends from the Library class. Media objects have a name, an author, a year of publication, an ID and a media type.
 * This class also contains a static int which keeps track of how many books have been created used also for the ID.
 * This class inherits the name, author and year of publication variables, as well as their setters and getters and the equals method.
 * Contains a toString method.
 * 
 * @author Fred
 * @version 1
 */
public class Media extends Library {
	protected static int mediaNum;
	protected String mediaType;
	
	
	/**
	 * Custom constructor, that uses super() to call the constructor of the Library class (parent).
	 * Sets the name. author, year of publication, ID and media type of the Media object.
	 * Adds 1 to the mediaNum as calling this method means a media object has been created.
	 * 
	 * @param newName The name of the media, String.
	 * @param newAuthor The author of the media, String.
	 * @param newYearPub The year of publication of the media, int.
	 * @param newMediaType The media type of the media, String.
	 */
	public Media(String newName, String newAuthor, int newYearPub, String newMediaType) {
		super(newName, newAuthor, newYearPub);
		this.mediaType = newMediaType;
		this.ID = "M"+mediaNum++;
	}
	
	
	/**
	 * This is the default constructor. It uses super() to call the default constructor of the parent class Library.
	 * Sets the media type to N/A and the ID number.
	 * Adds 1 to the variable mediaNum.
	 */
	public Media() {
		super();
		this.mediaType = "N/A";
		this.ID = "M"+mediaNum++;
	}
	
	
	/**
	 * This is the copy constructor. Copies the values of another Media object but with a different ID.
	 * Adds 1 to the variable mediaNum.
	 * 
	 * @param newMedia The Media object that will be copied, Media.
	 */
	public Media(Media newMedia) {
		this(newMedia.name, newMedia.author, newMedia.yearPub, newMedia.mediaType);
		this.ID = "M"+mediaNum++;
	}
	
	
	/**
	 * A toString method that prints out the information of the Media object.
	 * 
	 * @return Returns a String containing all the information of the Media object.
	 */
	public String toString() {
		return "Media ID: "+this.ID +"\nMedia name: "+this.name+"\nAuthor name: "+this.author+"\nYear of publication: "+this.yearPub+"\nMedia type: "+this.mediaType;
	}
	
	
	/**
	 * A getter method that shows the media type of the object.
	 * 
	 * @return Returns a String of which media type the object is.
	 */
	public String getMediaType() {
		return this.mediaType;
	}
	
	
	/**
	 * A setter methods that sets the media type to newMediaType.
	 * 
	 * @param newMediaType The new media type of the object, String.
	 */
	public void setMediaType(String newMediaType) {
		this.mediaType = newMediaType;
	}
	
	
	/**
	 * A getter method that shows how many media have been created.
	 * 
	 * @return Returns an int of how many media objects have been created.
	 */
	public static int getNumOfMedias() {
		return mediaNum;
	}
	
	public String getID() {
		return super.getID();
	}
	
	
	/**
	 * A setter method that sets the mediaNum variable to a new value.
	 * Used when deleting a media object.
	 * 
	 * @param newValue The new value of mediaNum, int.
	 */
	public static void setNumOfMedia(int newValue) {
		mediaNum = newValue;
	}
}
