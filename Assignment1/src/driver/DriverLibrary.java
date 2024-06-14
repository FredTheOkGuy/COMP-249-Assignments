// ------------------------------------------------------------
// Assignment: 1
// Question: Driver class including getBiggestBook and copyBooks methods.
// Written by: Fred
// ------------------------------------------------------------

/* This class contains the main method. It first asks the user if they want to go to the main menu or run a predefined code.
 * If the user selects the main menu, it gives them 15 options; Add an item, delete an item, change info of an item, list all
 * items of a specific category, print all items, add a client, delete a client, edit a client, lease an item to a client, return
 * an item from a client, show all items leased by a client, show all items leased by all clients, display the biggest book, make
 * a copy of the book array or exit.
 * The predefined code creates clients, and items and uses methods to test out certain functions. */


// We import the packages to get access to the Library, Book, Journal, Media and Client classes. As well the Scanner.
package driver;
import other.*;
import client.*;
import java.util.Scanner;

public class DriverLibrary {
	
	// All these variables are static since we have to use them inside static methods outside the main method.
	static Scanner userInput = new Scanner(System.in); // Scanner object to read the user's input.
	static int userChoice; // The choice of the user
	static final int MAX_ITEMS = 20; // The maximum amount of items we can have of each.
	static Book[] allBooks = new Book[MAX_ITEMS]; // An array holding all the book objects.
	static Journal[] allJournals = new Journal[MAX_ITEMS]; // An array holding all the journal objects.
	static Media[] allMedia = new Media[MAX_ITEMS]; // An array holding all the media objects.
	static final int MAX_CLIENTS = 10; // The maximum amount of clients we can have.
	static Client[] clientList = new Client[MAX_CLIENTS]; //An array holding all the clients.
	
	

	public static void main(String[] args) {
		System.out.println("Welcome to Frederic Gagne's library!!!");
		System.out.println("Would you rather open the menu (0) or run a predefined scenario (1)?");
		checkUserChoice(0,1); // Call checkUserChoice method to assure the user selected a correct option.
		
		if(userChoice == 0) { // If the user selects to open the menu.
			do { // Start a do while loop.
			System.out.println("Please chose an option listed below.\n\t1. Add an item\n\t2. Delete an item\n\t3. Change information of an item"
					+ "\n\t4. List all items in a specific category\n\t5. Print all items\n\t6. Add a client"
					+ "\n\t7. Edit a client\n\t8. Delete a client\n\t9. Lease an item to a client\n\t10. Return an item from a client"
					+ "\n\t11. Show all items leased by a client\n\t12. Show all items leased by all clients\n\t13. Display the biggest book"
					+ "\n\t14. Make a copy of the book array\n\t15. Exit"); // Display all the possible options.
			
			checkUserChoice(1,15); // Makes sure the user inputs an option between 1 and 15.
			
			switch(userChoice) { // Start a switch using the userChoice variable.
			
				// Case 1, if userChoice == 1. Adding an item
				case 1: // Ask user which type of item he wants to add.
					System.out.println("Do you want to add a book (1), a journal (2) or a media (3)?");
					checkUserChoice(1,3); // Check his choice.
					if(checkIfYouCanDo(MAX_ITEMS)) // Look if he can add that type of item, if not go back to menu
						break;
					// Ask for all the information of the item the user wants to create.
					System.out.print("Please give me the name: ");
					userInput.nextLine();
					String newName = userInput.nextLine();
					System.out.print("Please give me the name of the author: ");
					String newAuthor = userInput.nextLine();
					System.out.print("Please give me the year of publication: ");
					int newYearPub = userInput.nextInt();
					// If he wanted to add a book...
					if(userChoice == 1) { // Ask for the number of pages and use custom constructor of the book class to create a book object.
						System.out.print("Please give me the number of pages of your book: ");
						int newNumOfPages = userInput.nextInt();
						allBooks[Book.getNumOfBooks()] = new Book(newName, newAuthor, newYearPub, newNumOfPages); 
						System.out.println("\nBook created successfully!");
					}
					// If he wanted to add a journal...
					else if(userChoice == 2) { // Ask the user for the number of volumes and use custom constructor the the journal class to create a journal object.
						System.out.print("Please give me the number of volumes of your journal: ");
						int newNumOfVol = userInput.nextInt();
						allJournals[Journal.getNumOfJournals()] = new Journal(newName, newAuthor, newYearPub, newNumOfVol);
						System.out.println("\nJournal created successfully!");
					}
					// If he wanted to add a media...
					else { // Ask the user for the media type and user custom constructor of the media class to create a media object.
						System.out.print("Please give me the type of media: ");
						String newMediaType = userInput.nextLine();
						allMedia[Media.getNumOfMedias()] = new Media(newName, newAuthor, newYearPub, newMediaType);
						System.out.println("\nMedia created successfully!");
					}
					System.out.println();
					break; // Break the case so that it stops there.
					
				// Case 2, if the user's choice is equal to 2. Deleting an item.
				case 2:
					System.out.println("Do you want to delete a book (1), a journal (2) or a media (3)?");
					checkUserChoice(1,3); // Ask what type of item the user wants to delete and make sure his input is valid.
					if(checkIfYouCanDo(0)) // Make sure he can delete that type of item.
						break;
					if(userChoice == 1 && checkUserChoice(0, Book.getNumOfBooks()-1)){ // See which book the user wants to delete
							if(userChoice == MAX_ITEMS-1 || allBooks[userChoice + 1] == null) { //If it's the last or second to last book
								allBooks[userChoice] = null; // Make that book null (delete it)
							}
							else {
								for(int i = userChoice; i+1<MAX_ITEMS && allBooks[i+1] != null; i++) { // If its any other book
									allBooks[i] = allBooks[i+1]; // Delete that book and make sure to move all the books in the array to the left by one
									allBooks[i+1] = null;
								}
							}
							Book.setNumOfBook(Book.getNumOfBooks() - 1); // Make sure that the numBook variable is one less
							System.out.println("\nBook deleted successfully");
					}
					else if(userChoice == 2 && checkUserChoice(0, Journal.getNumOfJournals()-1)){ // Does the same thing as the books but for journals
						if(userChoice == MAX_ITEMS-1 || allJournals[userChoice + 1] == null) {
							allJournals[userChoice] = null;
						}
						else {
							for(int i = userChoice; i+1<MAX_ITEMS && allJournals[i+1] != null; i++) {
								allJournals[i] = allJournals[i+1];
								allJournals[i+1] = null;
							}
						}
						Journal.setNumOfJournal(Journal.getNumOfJournals() - 1);
						System.out.println("\nJournal deleted successfully");
					}
					else{
						checkUserChoice(0,Media.getNumOfMedias() -1); // Does the same thing as the books but for the media
						if(userChoice == MAX_ITEMS-1 || allMedia[userChoice + 1] == null) {
							allMedia[userChoice] = null;
						}
						else {
							for(int i = userChoice; i+1<MAX_ITEMS && allMedia[i+1] != null; i++) {
								allMedia[i] = allMedia[i+1];
								allMedia[i+1] = null;
							}
						}
						Media.setNumOfMedia(Media.getNumOfMedias() - 1);
						System.out.println("\nMedia deleted successfully");
					}
					System.out.println();
					break;
				
				//Case 3, if userChoice == 3. Editing an item
				case 3:
					int secondUserChoice; // Create a new variable to keep in memory one of the user's choice
					System.out.println("Do you want to modify a book (1), a journal (2) or a media (3)");
					checkUserChoice(1,3); // Validate the user's choice
					if(checkIfYouCanDo(0)) // Make sure there exist an item that the user can edit
						break;
					
					secondUserChoice = userChoice;
					System.out.print("Do you want to modify the name (1), the author (2), the year of publication (3), ");
					if(userChoice == 1) { // If he wants to modify a book, give him this extra option
						System.out.println("or the number of pages (4)?");
					}
					else if(userChoice == 2) { // If he wants to modify a journal give him this extra option
						System.out.println("or the number of volumes (4)?");
					}
					else { // If he wants to modify a media give him this extra option
						System.out.println("or the type of media (4)?");
					}
					checkUserChoice(1,4); // CHeck the user's choice
					
					int optionChoice = userChoice; // New variable to keep in memory another of user's choice
					
					if(secondUserChoice == 1) { // If he wanted to modify a book...
						System.out.println("Which book do you want to modify?");
						checkUserChoice(0, Book.getNumOfBooks()-1); // Get which book he wants to modify
						System.out.println("Please give me the new value: ");
						userInput.nextLine(); // Junk line
						switch(optionChoice) { 
						case 1: // Change the name of the book
							newName = userInput.nextLine();
							allBooks[userChoice].setName(newName);
							break;
						case 2: // Change the author's name
							newAuthor = userInput.nextLine();
							allBooks[userChoice].setAuthor(newAuthor);
							break;
						case 3: // Change the year of publication
							newYearPub = userInput.nextInt();
							allBooks[userChoice].setYearPub(newYearPub);
							break;
						case 4: // Change the number of pages
							int newNumOfPages = userInput.nextInt();
							allBooks[userChoice].setNumOfPages(newNumOfPages);
							break;
							
						}
						System.out.println("\nBook modified successfully!");
					}
					else if(secondUserChoice == 2) { // If he wanted to modify a journal
						System.out.println("Which journal do you want to modify?");
						checkUserChoice(0, Journal.getNumOfJournals()-1); // Get which journal the user wants to modify
						System.out.println("Please give me the new value: ");
						userInput.nextLine(); // Junk line
						switch(optionChoice) {
						case 1: // Change the journal's name
							newName = userInput.nextLine();
							allJournals[userChoice].setName(newName);
							break;
						case 2: // Change the author's name
							newAuthor = userInput.nextLine();
							allJournals[userChoice].setAuthor(newAuthor);
							break;
						case 3: // Change the year of publication
							newYearPub = userInput.nextInt();
							allJournals[userChoice].setYearPub(newYearPub);
							break;
						case 4: // Change the number of volumes
							int newNumOfVol = userInput.nextInt();
							allJournals[userChoice].setNumOfVol(newNumOfVol);
							break;
							
						}
						System.out.println("\nJournal modified successfully!");
					}
					else { // if the user wants to modify a media
						System.out.println("Which media do you want to modify?");
						checkUserChoice(0, Media.getNumOfMedias()-1); // Get which media
						System.out.println("Please give me the new value: ");
						userInput.nextLine(); // Junk line
						switch(optionChoice) {
						case 1: // Change the media's name
							newName = userInput.nextLine();
							allMedia[userChoice].setName(newName);
							break;
						case 2: // Change the author's name
							newAuthor = userInput.nextLine();
							allMedia[userChoice].setAuthor(newAuthor);
							break;
						case 3: // Change the year of publication
							newYearPub = userInput.nextInt();
							allMedia[userChoice].setYearPub(newYearPub);
							break;
						case 4: // Change the media type
							String newMediaType = userInput.next();
							allMedia[userChoice].setMediaType(newMediaType);
							break;
						}
						System.out.println("\nMedia modified successfully!");
					}
					System.out.println();
					break;
					
				
				// Case 4, is userChoice == 4. List all items in a specific category.
				case 4:
					System.out.println("Do you want to see all books (1), journals (2) or medias (3)?");
					checkUserChoice(1,3); // Get which items the user wants to see
					Library[] temporaryArray;
					if(userChoice == 1) // Set the chosen array to a temporary array so we don't have to have 3 different for loops
						temporaryArray = allBooks;
					else if(userChoice == 2)
						temporaryArray = allJournals;
					else
						temporaryArray = allMedia;
					
					if(checkIfYouCanDo(0)) // If there is no item of that type
						break;
					
					for(int i = 0; i<temporaryArray.length; i++) { // For loop to print out all of the items of the certain type
						if(temporaryArray[i] != null)
							System.out.println(temporaryArray[i]+"\n");
					}
					break;
					
					
				// Case 5, if userChoice == 5. List all items.
				case 5: 
					if(Book.getNumOfBooks() != 0)
						System.out.println("***Books***"); // Use for loop to go through all books of the book array and print each of them
					for(int i = 0; i<allBooks.length; i++) {
						if(allBooks[i] != null) // Make sure that we print out an actual book and not null
							System.out.println(allBooks[i]+"\n"); // Using toString method
					}
					
					if(Journal.getNumOfJournals() != 0)
						System.out.println("***Journals***"); // Use for loop to go through all journals in the journal array and print each of them
					for(int i = 0; i<allJournals.length; i++) {
						if(allJournals[i] != null) // Make sure that we print out an actual journal and not null
							System.out.println(allJournals[i]+"\n"); // Using toString method
					}
					
					if(Media.getNumOfMedias() != 0)
						System.out.println("***Medias***"); // Use for loop to go through all media in the media array and print each of them
					for(int i = 0; i<allMedia.length; i++) {
						if(allMedia[i] != null) // Make sure that we print out an actual media and not null
							System.out.println(allMedia[i]+"\n"); // Using toString method
					}
					
					break;
					
				// Case 6, if userChoice == 6. Adding a client.
				case 6:
					if(Client.getNumOfClients() == MAX_CLIENTS) { // Make sure that it is possible to add a client
						System.out.println("Sorry you cannot do this action.");
						break;
					} // Ask the user for all the client's information, using our Scanner object to read his keyboard
					System.out.print("Please give me the name of the client: ");
					userInput.nextLine(); // Junk line
					newName = userInput.nextLine();
					System.out.print("Please give me the age of the client: ");
					int newAge = userInput.nextInt();
					System.out.print("Please give me the maximum amount of items this client can lease: ");
					int newNumOfItemsLease = userInput.nextInt();
					clientList[Client.getNumOfClients()] = new Client(newName, newAge, newNumOfItemsLease); // Create a new client using the given
																											// information and adding him to the client list
					System.out.println("\nClient created successfully!");
					break;
					
				
				// Case 7, is userChoice == 7. Modifying a client
				case 7:
					if(Client.getNumOfClients() == 0) { // If there is no client that can be modify.
						System.out.println("Sorry you cannot do this action.");
						break;
					}
					System.out.println("Which client to you wish to modify?");
					checkUserChoice(0, Client.getNumOfClients() - 1); // Get which client the user wants to modify.
					optionChoice = userChoice;
					System.out.println("Do you which to modify the name (1) or the age (2)?");
					checkUserChoice(1,2); // Which parameter the user wants to modify.
					if(userChoice == 1) { // If the user wants to change the name, ask for the name and use setName method to change name
						System.out.print("Please give me the new name: ");
						userInput.nextLine();
						newName = userInput.nextLine();
						clientList[optionChoice].setName(newName);
					}
					else { // If the user wants to change the age, get the age and use setAge to change age.
						System.out.println("Please give me the new age: ");
						newAge = userInput.nextInt();
						clientList[optionChoice].setAge(newAge);
					}
					break;
					
					
				// Case 8, if userChoice == 8. Deleting a client.
				case 8:
					if(Client.getNumOfClients() == 0) { // Make sure there is a client that can be deleted.
						System.out.println("Sorry you cannot do this action.");
						break;
					}
					System.out.println("Which client do you wish to delete?");
					checkUserChoice(0, Client.getNumOfClients() - 1); // Get which client the user wants to delete.
					if(userChoice == MAX_CLIENTS-1 || clientList[userChoice + 1] == null) { // If its the last client of the list of the second last.
						clientList[userChoice] = null; // Replace that client by null
					}
					else { // If its at any other place in the list
						for(int i = userChoice; i+1<MAX_CLIENTS && clientList[i+1] != null; i++) { // Start a loop
							clientList[i] = clientList[i+1]; // Make the current position the same as the position after
							clientList[i+1] = null; // Set the next position to null
						}
					}
					Client.setNumOfClients(Client.getNumOfClients() - 1); // Remove 1 from numOfClients
					System.out.println("\nClient deleted successfully");
					break;
					
					
				// Case 9, if userChoice == 9. Lease an item to a client
				case 9:
					if(Client.getNumOfClients() == 0) { // Make sure there is a client
						System.out.println("Sorry you cannot do this action.");
						break;
					}
					System.out.println("Which client do you want to lease an item too?");
					checkUserChoice(0, Client.getNumOfClients() - 1); // Get which client the user wants to lease an item to.
					optionChoice = userChoice;
					
					System.out.println("Do you wish to lease him a book (1), a journal (2) or a media (3)?"); 
					checkUserChoice(1,3); // Get which type of item that wants to be leased
					
					if(checkIfYouCanDo(0)) // Make sure that there exist that type of item to be leased.
						break;
					
					if(userChoice == 1) { // If he wants to lease a book
						System.out.println("Which book do you want to lease to the client?");
						checkUserChoice(0, Book.getNumOfBooks() - 1); // Get which book to be leased
						clientList[optionChoice].leaseAnItem(allBooks[userChoice]); // Use leaseAnItem method to lease the book to the client
					}
					else if(userChoice == 2) { // Same thing as books but for journals
						System.out.println("Which journal do you want to lease to the client?");
						checkUserChoice(0, Journal.getNumOfJournals() - 1);
						clientList[optionChoice].leaseAnItem(allJournals[userChoice]);
					}
					else { // Same thing as books and journals but for media
						System.out.println("Which media do you want to lease to the client?");
						checkUserChoice(0, Media.getNumOfMedias() - 1);
						clientList[optionChoice].leaseAnItem(allMedia[userChoice]);
					}
					System.out.println("\nItem leased successfully!");
					break;
					
					
				// Case 10, if userChoice == 10. Returning an item
				case 10:
					if(Client.getNumOfClients() == 0) { // if there is no clients
						System.out.println("Sorry you cannot do this action.");
						break;
					}
					System.out.println("From which client do you want to return an item from?");
					checkUserChoice(0, Client.getNumOfClients() - 1); // Get which client is returning an item
					
					if(clientList[userChoice].getNumOfItems() == 0) { // If that client has no items
						System.out.println("Sorry you cannot do this action.");
						break;
					}
					
					int clientIndex = userChoice; // New variable of the client's index
					
					System.out.println("Which item do you want returned?");
					checkUserChoice(0, clientList[userChoice].getNumOfItems()-1); // Get which item the user wants returned
					
					clientList[clientIndex].returnItem(userChoice); // Call returnItem method to return item.
					System.out.println("\nItem returned successfully!");
					break;
					
					
				// Case 11, if userChoice == 11. Display all items from a client
				case 11:
					if(Client.getNumOfClients() == 0) { // Make sure that there is at least one client
						System.out.println("Sorry you cannot do this action.");
						break;
					}
					System.out.println("Which client do you wish to see items?"); 
					checkUserChoice(0, Client.getNumOfClients() - 1); // Get which client the user wants to see
					
					clientList[userChoice].showItemLeasedByOneClient(); // Call the showItemLeasedByOneClient method to display all items leased by that client
					break;
					
					
				// Case 12, if userChoice == 12. Display all leased items
				case 12:
					for(int i = 0; i<Client.getNumOfClients(); i++) { // For loop that will go through all clients in client list and
						// call showItemLeasedByOneClient method to display items leased by the client
						clientList[i].showItemLeasedByOneClient();
						System.out.println(); // Space between each client
					}
					break;
					
					
				// Case 13, if userChoice == 13. Get the biggest book
				case 13:
					if(Book.getNumOfBooks() == 0) {
						System.out.println("You do not have any books.\n");
						break;
					}
					System.out.println(getBiggestBook(allBooks)+"\n"); // Call getBiggestBook method to return the biggest book
					break;
					
					
				// Case 14, if userChoice == 14. Copying all the books.
				case 14:
					if(Book.getNumOfBooks() == 0) {
						System.out.println("No books can be copied.\n");
						break;
					}
					Library[] copiedBookArray = copyBooks(allBooks); // Call copiedBookArray to copy all the books of the book array.
					System.out.println("Copy successful!\n");
					break;
					
				default: // If userChoice == 15. Exit.
					System.out.println("Thank you very much!");
				}
			}
			while(userChoice !=15); // Do this loop while choice is not equal to 15, when it is, stop the loop (exit)
		}
		
		
		else { // If the user wanted the predefined text.
			System.out.println("Predefine option selected: \n");
			
			// Creating 4 different clients using constructor.
			Client client1 = new Client("Jhon", 23, 9);
			Client client2 = new Client("Jenna", 37, 8);
			Client client3 = new Client("Paul", 19, 5);
			Client client4 = new Client(client1);
			
			// Array of clients with all the clients created above.
			Client clientList[] = {client1, client2, client3, client4};
			
			// Creating 3 books using Book constructors.
			Book book1 = new Book("Great Stories 1", "Percy Parking", 2001, 220);
			Book book2 = new Book("Life of Pi", "Yann Martel", 2002, 368);
			Book book3 = new Book(book2);
			
			// Creating 3 journals using journal constructors
			Journal journal1 = new Journal();
			Journal journal2 = new Journal("Diary", "Unknown", 2020, 10);
			Journal journal3 = new Journal(journal2);
			
			// Creating 3 media using media constructors
			Media media1 = new Media("Kung Fu Pada", "Jack Black", 2008, "DVD");
			Media media2 = new Media("Secret Tape", "Unknown", 2010, "DVD");
			Media media3 = new Media();
			
			// Creating an array for all the books, all the journals, all the media and one for all the items.
			Book allBooks[] = {book1, book2, book3};
			Journal allJournals[] = {journal1, journal2};
			Media allMedia[] = {media1, media2, media3};
			Library allItems[] = {book1, book2, book3, journal1, journal2, journal3, media1, media2, media3};
			
			// Change the values of journal 1.
			journal1.setAuthor("Pearson Man");
			journal1.setName("Secret Journal!");
			journal1.setYearPub(2005);
			
			// Testing out equals method
			System.out.println("Are book 1 and book 2 the same?: "+book1.equals(book2)+"\n");
			System.out.println("Are book 1 and media 1 the same?: "+book1.equals(media1)+"\n");
			System.out.println("Are journal 2 and journal 3 the same?: "+journal2.equals(journal3)+"\n");
			
			// Looping trough to print all clients
			for(int i = 0; i<clientList.length; i++) {
				System.out.println(clientList[i]);
				System.out.println();
			}
			
			// Looping through to print out all items
			for(int i = 0; i<allItems.length; i++) {
				System.out.println(allItems[i]);
				System.out.println();
				}
			
			
			// Lease items to clients
			client1.leaseAnItem(book1);
			client1.leaseAnItem(book3);
			client3.leaseAnItem(journal1);
			client2.leaseAnItem(book2);
			client4.leaseAnItem(media1);
			
			// Show the items leased by all clients
			System.out.println("Client 1:");
			client1.showItemLeasedByOneClient();
			System.out.println("\nClient 2:");
			client2.showItemLeasedByOneClient();
			System.out.println("\nClient 3:");
			client3.showItemLeasedByOneClient();
			System.out.println("\nClient 4:");
			client4.showItemLeasedByOneClient();
			
			// Return an item from a client and print out his item leased
			client1.returnItem(0);
			System.out.println("New items of Client 1:");
			client1.showItemLeasedByOneClient();
			System.out.println();
			
			// Print out the biggest book
			System.out.println("The biggest book is: \n"+getBiggestBook(allBooks)+"\n\n");
			
			// Make sure the copyBooks method works
			Library[] copiedBooks = copyBooks(allMedia);
			
			// Printing out the books in the copied book array.
			for(int i = 0; i<copiedBooks.length; i++)
				System.out.println(copiedBooks[i]+"\n");
			
			System.out.println((media1 instanceof Library) + "\n");
			
			Library hello = new Media();
			System.out.println(hello.getID()+"\n");
			
			Library lib = new Journal();
			System.out.println(lib.getClass() +"\n");
			
			Media med = new Media();
			lib = med;
			System.out.println((lib instanceof Library) + "\n");
			
			System.out.println(lib.getClass() + "\n");	
			
			Library[] newBookArray = copyBooks(allBooks);	
			
			for(int i = 0; i<newBookArray.length; i++) {
				System.out.println(newBookArray[i] + "\n");
			}
			

		}
	}
	
	
	/**
	 * The checkBiggestBook method will look through all the created book objects and return
	 * the one with the most amount of pages. Return new Book for privacy.
	 * 
	 * @param arrayOfBooks An array of book objects containing all the created books.
	 * @return Returns a Book object with the most amount of pages.
	 */
	static Book getBiggestBook(Book[] arrayOfBooks) {
		int biggestBookIndex = 0;
		for(int i = 1; i<arrayOfBooks.length && arrayOfBooks[i] != null; i++) {
			if(arrayOfBooks[i].getNumOfPages() > arrayOfBooks[biggestBookIndex].getNumOfPages())
				biggestBookIndex = i;
		}
		return new Book(arrayOfBooks[biggestBookIndex]);
	}
	
	
	/**
	 * The copyBooks method copies all the library items of the given array into a new array and returns it, only
	 * copies book object.
	 * 
	 * @param arrayOfBooks Takes in an array of Book objects.
	 * @return Returns an array of Books, includes the same books as the array taken in.
	 */
	static Library[] copyBooks(Library[] arrayOfBooks) {
		Book[] newArrayOfBooks = new Book[arrayOfBooks.length];
		for(int i = 0; i<arrayOfBooks.length; i++) {
			if(arrayOfBooks[i] instanceof Book) {
				Book copyBook = (Book)arrayOfBooks[i];
				newArrayOfBooks[i] = new Book(copyBook);
			}
		}
		return newArrayOfBooks;
			
	}
	
	
	/**
	 * The checkUserChoice method will make sure that the option selected by the user is valid.
	 * When the user selects a valid option, it sets userChoice to that value.
	 * 
	 * @param minimumValue The minimum value the user can select, int.
	 * @param maximumValue The maximum value the user can select, int.
	 * @return Returns a boolean, returns true when the user selected a valid option.
	 */
	static boolean checkUserChoice(int minimumValue, int maximumValue) {
		int currentUserChoice = 0;
		do {
			System.out.print("Please select an option ("+minimumValue+"-"+maximumValue+"): ");
			currentUserChoice = userInput.nextInt();
			System.out.println();
		}
		while(currentUserChoice < minimumValue || currentUserChoice > maximumValue);
		userChoice = currentUserChoice;
		return true;
	}
	
	
	/**
	 * The checkIfYouCanDo method makes sure the user can make an action.
	 * This is used when the user wants to add an item (make sure he can), remove an item (makes sure he can remove an item), etc.
	 * 
	 * @param valueToCheck The value that has to be checked (adding item => MAX_ITEMS, removing/editing items => 0), int.
	 * @return Returns a boolean of if the user can do that action.
	 */
	static boolean checkIfYouCanDo(int valueToCheck) {
		if((userChoice == 1 && Book.getNumOfBooks() == valueToCheck) || (userChoice == 2 && Journal.getNumOfJournals() == valueToCheck) || (userChoice == 3 && Media.getNumOfMedias() == valueToCheck) || (Client.getNumOfClients() == valueToCheck)) {
			System.out.println("Sorry, you cannot do that action");
			return true;
		}
		else {
			return false;
		}
	}

}
