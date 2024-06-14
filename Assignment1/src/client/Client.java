/**
 * This class makes Client objects. These client have a name, an age, a maximum amount of items, a list of items
 * and a number of items leased. There is also a static variable to keep track of the amount of clients created.
 * This class contains constructors, mutators, getters and other methods.
 * 
 * 
 * @author Fred
 * @version 1
 */

package client;
import other.*;

public class Client {
	protected String name;
	protected int age;
	protected Library[] items;
	protected int itemsLeased;
	protected int maxItems;
	protected static int numOfClients;
	
	protected static Library[] leasedItems;
	
	
	/**
	 * Custom constructor with 3 parameters. It sets the name, age of the client, how many items he can have.
	 * It also creates an array of Library objects with a size of the max items he can hold. This custom constructor 
	 * adds 1 to the number of clients.
	 * 
	 * @param newName The name of the client, String.
	 * @param newAge The age of the client, int.
	 * @param maxItems The maximum amount of items the client can lease, int.
	 */
	public Client(String newName, int newAge, int maxItems) {
		this.name = newName;
		this.age = newAge;
		this.maxItems = maxItems;
		this.items = new Library[maxItems];
		numOfClients +=1;
	}
	
	
	/**
	 * Default constructor. Uses this() to make the name of the client "N/A", his age 0 and the max items 5.
	 * This constructor adds 1 to the number of clients created.
	 * 
	 */
	public Client() {
		this("N/A", 0, 5);
		numOfClients += 1;
	}
	
	
	/**
	 * Copy constructor. Makes the values of the client's name, age and maximum amount of items equals to
	 * the given Client object.			
	 * 																																																																																																																																																																																																																																																																													
	 * @param otherClient The client which will be copied.
	 */
	public Client(Client otherClient) {
		this.name = otherClient.name;
		this.age = otherClient.age;
		this.maxItems = otherClient.maxItems;
		this.items = new Library[maxItems];
		numOfClients += 1;
	}
	
	
	/**
	 * A setter method that sets the name of the client to the variable newName.
	 * 
	 * @param newName The new name of the client, String.
	 */
	public void setName(String newName) {
		this.name = newName;
	}
	
	
	/**
	 * A setter method that sets the age of the client to the variable newAge.
	 * 
	 * @param newAge The new age of the client, int.
	 */
	public void setAge(int newAge) {
		this.age = newAge;
	}
	
	
	/**
	 * A getter methods that returns the name of the client.
	 * 
	 * @return Returns a String, the name of the client.
	 */
	public String getName() {
		return this.name;
	}
	
	
	/**
	 * A getter method that returns the age of the client.
	 * 
	 * @return Returns an int, the age of the client.
	 */
	public int getAge() {
		return this.age;
	}
	
	
	/**
	 * The toString method that shows all the clients info.
	 * 
	 * @return Returns a String containing all the client's information.
	 */
	public String toString() {
		return "Client's name: "+this.name+"\nClient's age: "+this.age+"\nThis client can lease "+this.maxItems+" items.";
	}
	/**
	 * This method leases an item to the client. It makes sure that he can lease an item.
	 * It adds that item to the items array.
	 * It adds 1 to itemsLeased.
	 * 
	 * @param item The item (Library class) which is leased to the client, Library.
	 */
	public void leaseAnItem(Library item) {
		boolean leasingItem = false;
		if(itemsLeased != 0) {
			for(int i = 0; i< this.itemsLeased; i++) {
				if(item.equals(this.items[i]))
					leasingItem = true;
			}
		}
		
		if(itemsLeased >= maxItems) {
			System.out.println("Cannot lease you an item.");
		}
		else if(leasingItem)
			System.out.println("This client is already leasing this item.");
		else {
			this.items[itemsLeased++] = item;
		}
	}
	
	
	/**
	 * This method returns an item from a client. It makes sure that the client has an item.
	 * If the client doesn't have any items, it stops. If he has the maximum amount of items or one less, it deletes that item from
	 * his items by making it equal to null. If it's anything else, it replaces the current item with the item in the next position
	 * and sets the item in the next position to null. Continue this until the item in the next position is not null.
	 * It removes 1 from itemsLeased.
	 * 
	 * @param itemIndex The index of the item that the client is returning, int.
	 */
	public void returnItem(int itemIndex) {
		if(itemIndex < 0 || itemIndex >= maxItems || this.items[itemIndex] == null) {
			System.out.println("That item does not exist");
		}
		else {
			if(itemIndex == maxItems-1 || items[itemIndex+1] == null) {
				items[itemIndex] = null;
				this.itemsLeased -= 1;
			}
			else {
				for(int i = itemIndex; i+1<maxItems && this.items[i+1] != null; i++) {
					items[i] = items[i+1];
					items[i+1] = null;
				}
				this.itemsLeased -= 1;
			}
		}
	}
	
	
	/**
	 * This method prints out all the items that a client has leased.
	 */
	public void showItemLeasedByOneClient() {
		for(int i = 0; i < this.maxItems; i++) {
			if(this.items[i] != null) {
				System.out.println("Item #"+i+":\n"+this.items[i]);
				System.out.println();
			}
		}
	}
	
	/**
	 * This static getter method shows how many clients have been created.
	 * 
	 * @return Returns an int, the static variable numOfClients, which is how many clients have been created.
	 */
	public static int getNumOfClients() {
		return numOfClients;
	}
	
	
	/**
	 * This static setter method sets the amount o clients that have been created.
	 * Used for when a client is deleted.
	 * 
	 * @param newValue The new value of numOfClients, int.
	 */
	public static void setNumOfClients(int newValue) {
		numOfClients = newValue;
	}
	
	
	/**
	 * This getter method shows how many items have been leased by a client.
	 * 
	 * @return Returns an int which is how many items that have been leased by the client.
	 */
	public int getNumOfItems() {
		return this.itemsLeased;
	}
}
