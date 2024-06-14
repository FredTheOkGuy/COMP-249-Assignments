package other;


/**
 * This class creates Journal objects which inherits from Library.
 * It inherits variables like name, author and year of publication, ID, as well as setter, getter and equals methods.
 * Has a static int journalNum that keeps track how many journals have been created and numOfVol which is the number of volumes.
 * It has a toString method that shows all the object's information.
 * 
 * @author Fred
 * @version 1
 */
public class Journal extends Library {
	protected static int journalNum;
	protected int numOfVol;
	
	
	/**
	 * The custom constructor calls the custom constructor of the parent class Library using super().
	 * It sets the name, author, year of publication, number of volumes and the ID of the Journal object.
	 * Adds 1 to journalNum as it creates a Journal object.
	 * 
	 * @param newName The name of the Journal, String.
	 * @param newAuthor The name of the journal's author, String.
	 * @param newYearPub The year of publication of the journal, int.
	 * @param newNumOfVol The number of volumes of the journal, int.
	 */
	public Journal(String newName, String newAuthor, int newYearPub, int newNumOfVol) {
		super(newName, newAuthor, newYearPub);
		this.numOfVol = newNumOfVol;
		this.ID = "J"+journalNum++;
	}
	
	
	/**
	 * Default constructor, calls the default constructor of the parent class Library using super().
	 * Sets numOfVol to 0 and adds 1 to journalNum.
	 */
	public Journal() {
		super();
		this.numOfVol = 0;
		this.ID = "J"+journalNum++;
	}
	
	
	/**
	 * Copy constructor, sets the value to the same values of the Journal object given.
	 * Adds 1 to journalNum.
	 * 
	 * @param newJournal The Journal that is copied, Journal.
	 */
	public Journal(Journal newJournal) {
		this(newJournal.name, newJournal.author, newJournal.yearPub, newJournal.numOfVol);
		this.ID = "J"+journalNum++;
	}
	
	
	/**
	 * To string method, which shows all the information of the journal object.
	 * 
	 * @return Returns a String containing all the Journal's information.
	 */
	public String toString() {
		return "Journal ID: "+this.ID +"\nJournal name: "+this.name+"\nAuthor name: "+this.author+"\nYear of publication: "+this.yearPub+"\nNumber of volumes: "+this.numOfVol;
	}
	
	
	/**
	 * Getter method that shows the number of volumes of the Journal.
	 * 
	 * @return Returns an int of the number of volumes of the journal.
	 */
	public int getNumOfVol() {
		return this.numOfVol;
	}
	
	
	/**
	 * Setter method that sets the number of volumes of the journal to a new value.
	 * 
	 * @param newNumOfVol The new value of the number of journals, int.
	 */
	public void setNumOfVol(int newNumOfVol) {
		this.numOfVol = newNumOfVol;
	}
	
	
	/**
	 * Getter methods that shows the number of journals created.
	 * 
	 * @return Returns an int of how many journal were created.
	 */
	public static int getNumOfJournals() {
		return journalNum;
	}
	
	
	/**
	 * Setter method that sets journalNum to the new value. Used when deleting a journal.
	 * 
	 * @param newValue The new value of the number of journals, int.
	 */
	public static void setNumOfJournal(int newValue) {
		journalNum = newValue;
	}
}
