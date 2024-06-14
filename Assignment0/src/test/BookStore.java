// ------------------------------------------------------------
// Assignment 0
// Question 2
// Written by: Fred
// ------------------------------------------------------------

package test;
import java.util.Scanner;

public class BookStore {
	
	// These variables and constants are static, since we use them in the passwordTries method
	private static final String PASSWORD = "249"; // The password to access option 1 and 2
	private static String passwordWritten; // The password written by the user
	private static int totalAttempts = 0; // The total amount of wrong attempts the user has attempted for the password
	private static Scanner userInput = new Scanner(System.in); // Scanner object to read the user's keyboard
	

	public static void main(String[] args) {
		
		int userChoice = 0; // The option choice made by the user
		int maxBooks; // The amount of books the user wants in his/her bookstore
		int otherUserChoice; // The user's choice for the options within the main options
		
		System.out.println("Welcome to your book store! \nHow many books do you want in your store?"); // Print out welcome message and how many books the user wants
		
		maxBooks = userInput.nextInt(); // Set the int written by the user as the books in the book store
		
		Book[] bookList = new Book[maxBooks]; // Create an array of Book objects the size of the maxBooks
		
		do {
			do { // We start a do while loop to make sure the user inputs a valid option (1,2,3,4 or 5)
			System.out.print("What do you want to do?\r\n" // Print out the options to the user
					+ "\t1. Enter new books (password required)\r\n"
					+ "\t2. Change information of a book (password required)\r\n"
					+ "\t3. Display all books by a specific author\r\n"
					+ "\t4. Display all books under a certain a price.\r\n"
					+ "\t5. Quit\r\n"
					+ "Please enter your choice > ");
			userChoice = userInput.nextInt(); // Set the user's choice as what the user inputs
			}
			while(userChoice < 1 || userChoice >5);
			
			
			
			if(userChoice == 1) { // If the user's choice is 1
				
				int numOfBooksAdd; // Initialize an int call numOfBooksAdd, this is the number of books the user will want to add
				
				if(passwordTries()) { // Proceed if the user is able to write the correct password in 3 tries or less, call the passwordTries method
					if(Book.findNumberOfCreatedBooks()== maxBooks) { // If he has already as many books as the maximum amount of books
						System.out.println("Sorry but you cannot add more books."); // Tell the user that he can't add any more books
					
					}
					else {
					while(true) { // Start a loop that will ask the user how many books he wants to add
						System.out.print("How many books do you want to enter?: ");
						numOfBooksAdd = userInput.nextInt();
						if(Book.findNumberOfCreatedBooks() + numOfBooksAdd > maxBooks) { // If the user enters an amount bigger than how many books he can add
							// Tell the user how many books he can add and the loop continues
							System.out.println("You can only add up to "+(maxBooks - Book.findNumberOfCreatedBooks())+" books"); 
						}
						else // If he wants to add a correct number of books, break the loop
							break;
						}
					
					for(int i = 0; i < numOfBooksAdd; i++) { // Start a loop that will continue looping until he has added the number of books he wanted to add
						
							
							String junk = userInput.nextLine(); // We create a junk string and give it the value of the next line, since if not we cannot read
																// The next String the user will input
							System.out.print("Please give me the title: "); 
							String newTitle = userInput.nextLine(); // Read the user's title
							
							
							
							System.out.print("Please give me the name of the author: ");
							String newAuthor = userInput.nextLine(); // Read the user's author
							
							System.out.print("Please give me the ISBN number: ");
							long newISBN = userInput.nextLong(); // Read the user's ISBN number
							
							System.out.print("Please give me the price of the book: ");
							double newPrice = userInput.nextDouble(); // Read the user's price
							System.out.println(); // Print a space because if he adds more books, the loop will repeat and it will separate between the books
							bookList[Book.findNumberOfCreatedBooks()] = new Book(newTitle, newAuthor, newISBN, newPrice); // Call the custom constructor of the book
							// class to create a new book using the values inputed by the user, and add it to the array of books at the position of amount of books that has been created
						
					}
				}
				}
			}
			
			else if(userChoice == 2) { // If the user's choice is 2...
				if(passwordTries()) { // Only continue if the user writes the correct password
					if(Book.findNumberOfCreatedBooks() == 0) { // If the user didn't add any books yet, tell them and go back to the main menu
						System.out.println("You do not have any books yet.");
					}
					else { // If he did add books...
						System.out.print("Which book would you like to modify: "); // Ask him which book he wants to modify
						int bookIndex = userInput.nextInt(); // Read the user's input and set it as the variable bookIndex
					
						if(bookIndex < 0 || bookIndex > Book.findNumberOfCreatedBooks() - 1) { // If the index he inputed is not correct
							System.out.println("That index does not exist.\nWould you rather select a new index (1) or return to menu (Anything else)"); //Tell them and give them 2 options
							otherUserChoice = userInput.nextInt();
						
							if(otherUserChoice == 1) { // If the user inputed 1, ask him to select another index
								System.out.print("Which book would you like to modify: ");
								bookIndex = userInput.nextInt();
								if(bookIndex < 0 || bookIndex > Book.findNumberOfCreatedBooks()-1) { // If that index is not correct again, go back to the main menu
									System.out.println("That book does not exist, going back to the menu.");
									continue;
							}
						}
						else // Go back to main menu
							continue;
						
				
					}
					
					System.out.println("Book #"+bookIndex); // Give him the book number and all the books information using the toString method
					System.out.println(bookList[bookIndex]);
					do {
						System.out.print("What information would you like to change?\n\t1. author\r\n\t2. title\n\t3. ISBN\n\t4. price\n\t5. Quit\n\tEnter your choice > ");
						otherUserChoice = userInput.nextInt(); // Ask him what information he would like to chose, continue this until he inputed a correct choice
					}
					while(otherUserChoice < 1 || otherUserChoice >5);
					
					if(otherUserChoice == 1) { // If he selected option 1
						String junk = userInput.nextLine(); // Doing this to be able to read the users next String
						System.out.print("Enter the name of the new author: ");
						String newAuthor = userInput.nextLine();
						bookList[bookIndex].setAuthor(newAuthor); // Use setAuthor method to set the author of the book to what the user inputed
					}
					
					else if(otherUserChoice == 2) { // If he selected option 2
						String junk = userInput.nextLine(); // Doing this to be able to read the users next String
						System.out.print("Enter the name of the new title: ");
						String newTitle = userInput.nextLine();
						bookList[bookIndex].setTitle(newTitle); // Use setTitle method to set the title of the book to what the user inputed
					}
					
					else if(otherUserChoice == 3) { // If he selects option 3
						System.out.print("Enter the new ISBN number: ");
						int newISBN = userInput.nextInt();
						bookList[bookIndex].setISBN(newISBN); // Set the new ISBN number of the book to the user's input
					}
					
					else if(otherUserChoice == 4) { // If he selects option 4
						System.out.print("Enter the new price: ");
						int newPrice = userInput.nextInt();
						bookList[bookIndex].setPrice(newPrice); // Set the new price of the book to the user's input
					}
					// We do not need anything for option 5, since the do while loops will assure that the user's input is between 1 and 5
					// If he selects 5 nothing will happen and the program will go back to the main menu
				}
				}
			}
			
			else if(userChoice == 3) { // If the user's choice is 3
				String junk = userInput.nextLine(); // Do this to be able to read the user's next String input
				System.out.print("Please enter the author's name: "); // We ask the user for an author
				String authorName = userInput.nextLine();
				System.out.println();
				for(int i = 0; i < Book.findNumberOfCreatedBooks(); i++) { // Start a loop to go through all the books in our book array
					if(bookList[i].getAuthor().equals(authorName)) // If the current book in the array has the same author as the author given by the user
						System.out.println(bookList[i] +"\n"); // We print out that book using toString method
				}
			}
			
					
			else if(userChoice == 4) { // If the option is 4
				System.out.println("Please enter the price: "); // Ask the user for a price
				int priceCheck = userInput.nextInt();
				
				for(int i = 0; i<Book.findNumberOfCreatedBooks();i++) { // We go through all the books in our array
					if(bookList[i].getPrice() < priceCheck) // If the current book's price is under the mentioned price
						System.out.println(bookList[i] + "\n"); // We print out that book
				}
			}
				
			// We do not need to account for option 5, because we have a do while loop that assures the option is 1,2,3,4 or 5, and if it's 5
			// we have another do while loop that will end the program.
			
			if(totalAttempts == 12) { // If the total amount of attempts for the password is 12
				System.out.print("Program detected suspicious activities and will terminate immediately!");
				break; // We stop the program
			}
			
		System.out.println("Thank you very much for you contribution in the book business!"); // Print out an exiting message
		}
		while(userChoice != 5);

	}
	/**
	 * This static method is to check if the password the user enters is correct. It gives the user three tries.
	 * Was made into a static method to shorten the code, since this feature is used twice in the code.
	 * 
	 * @return a boolean, false if it takes more than 3 tries, true if it takes less or equal than 3.
	 */
	public static boolean passwordTries() {
		int attempts = 0; // When we start checking for a password we set the attempts to 0
		do {
			System.out.print("Please give me your password: "); // Ask for the password
			passwordWritten = userInput.next();
			if(!passwordWritten.equals(PASSWORD)) { // If the password is not correct..
				attempts +=1; // We add 1 to the attempts
				totalAttempts +=1; // We add 1 to the total attempts
			}
		}
		while(!passwordWritten.equals(PASSWORD) && !(attempts >= 3)); // This loop continues while the password is not correct and the attempts doesn't pass 3
		
		if(attempts >= 3) // If the attempts are bigger or equal than 3
			return false; // We return false
		else // If not, we return true
			return true;
					
	}

}
