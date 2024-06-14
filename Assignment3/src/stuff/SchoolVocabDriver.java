// -----------------------------------------------------
// Assignment (3)
// Question: (1, Driver)
// Written by: Fred
// -----------------------------------------------------

// This is the driver method that will allow you to work with the doubly linked vocab list. You have different options
// like browsing topics, inserting before or after topics, remove or modify topics, search topics for a word, load a file,
// show all words starting with a given letter, save to file or exit.

package stuff;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;

public class SchoolVocabDriver {
	private static Scanner userInput = new Scanner(System.in); // User's input
	private static VocabLinkedList vocabList = new VocabLinkedList(); // Topics doubly linked list
	private static int userChoice = 0; // User's choice int
	private static String userChoiceChar = ""; // User's choice String
	
	
	
	// *****Main method*****
	public static void main(String[] args) {
		int tempChoice = 0;
		do {
			System.out.println("-----------------------------\nVocabulary Control Center\n-----------------------------");
			System.out.println("1 browse a topic\r\n"
					+ "2 insert a new topic before another one\r\n"
					+ "3 insert a new topic after another one\r\n"
					+ "4 remove a topic\r\n"
					+ "5 modify a topic\r\n"
					+ "6 search topics for a word\r\n"
					+ "7 load from a file\r\n"
					+ "8 show all words starting with a given letter\r\n"
					+ "9 save to file\r\n"
					+ "0 exit\r\n");
			checkUserChoice(0,9);
			tempChoice = userChoice;
			
			switch(userChoice) {
			case 1:
				browse();
				break;
			case 2:
				addTopic();
				break;
			case 3:
				addTopic();
				break;
			case 4:
				removeTopic();
				break;
			case 5:
				modifyTopic();
				break;
			case 6:
				searchTopicsForWord();
				break;
			case 7:
				openFile();
				break;
			case 8:
				allWordsWithLetter();
				break;
			case 9:
				saveOnFile();
				break;
			default:
				System.out.println("Have a nice day!");
			}
		}
		while(tempChoice != 0);
	}
	
	
	
	
	
	// *****Option methods*****
	/**
	 * Opening a file: This method open the files the user gives and adds the values in the doubly linked list.
	 */
	public static void openFile() {
		userInput.nextLine(); // Junk line
		System.out.println("Enter the name of the input file:");
		String file = userInput.nextLine(); // Text file name
		Scanner myReader = null; // Reads
		String currentVocab = null; // Keeps track of the vocab
		try { // Does the thing to read the files and adds it to the linked list
			myReader = new Scanner(new FileInputStream(file));
			
			while(myReader.hasNextLine()) {
				String line = myReader.nextLine().trim();
				if(line.equals("")) {
				}
				else if(line.charAt(0) == '#') {
					currentVocab = line.substring(1,line.length());
					if(!vocabList.inList(currentVocab)) {
						vocabList.addAtHead(currentVocab);
					}
				}
				else {
					vocabList.getWords(currentVocab).addAtHead(line);
				}	
			}
			myReader.close();
			System.out.println("Done loading");
		}
		catch(FileNotFoundException e) {
			System.out.println("The mentioned file was not found");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	/**
	 * Browse topics: method used to browse the topics of the vocab list.
	 */
	public static void browse() {
		topicSelection();
		if(userChoice == 0) {
			return;
		}
		else {
			vocabList.wordsDisplay(userChoice);
		}
	}
	
	
	/**
	 * Add before or after: a method that adds a new topic before or after a topic
	 */
	public static void addTopic() {
		String newTopic;
		if(vocabList.length() == 0) {
			System.out.println("No topic in memory");
			return;
		}
		int bef_af = userChoice;
		topicSelection();
		if(userChoice == 0) {
			return;
		}
		userInput.nextLine();
		if(bef_af == 2) { // Before (bef)
			System.out.println("Enter topic name: ");
			newTopic = userInput.nextLine().trim();
			if(vocabList.inList(newTopic)) {
				System.out.println("This topic already exists.");
				return;
			}
			vocabList.addBefore(newTopic, vocabList.getVocabFromIndex(userChoice));
			addTopicsToNewVocab(newTopic);
		}
		if(bef_af == 3) { // After (af)
			System.out.println("Enter topic name:");
			newTopic = userInput.nextLine().trim();
			if(vocabList.inList(newTopic)) {
				System.out.println("This topic already exists.");
				return;
			}
			vocabList.addAfter(newTopic,vocabList.getVocabFromIndex(userChoice));
			addTopicsToNewVocab(newTopic);
		}
	}
	
	
	/**
	 * Remove topic: method that removes the selected topic.
	 */
	public static void removeTopic() {
		topicSelection();
		vocabList.removeVocab(vocabList.getVocabFromIndex(userChoice));
	}
	
	
	/**
	 * Modify a topic: a method that allows the user to add a word, remove a word or modify a word from a topic.
	 */
	public static void modifyTopic() {
		if(vocabList.length() == 0) {
			System.out.println("No topic in memory");
			return;
		}
		topicSelection();
		if(userChoice == 0) {
			return;
		}
		userInput.nextLine();
		System.out.println("-----------------------------\nModify Topics Menu\n-----------------------------");
		System.out.println("a\tadd a word\nr\tremove a word\nc\tchange a word\n0\tExit");
		while(true) {
			System.out.print("-----------------------------\nEnter Your Choice: ");
			userChoiceChar = userInput.next();
			if(userChoiceChar.length() == 1) {
				if((userChoiceChar.charAt(0) == 'a'|| userChoiceChar.charAt(0) == 'r' || userChoiceChar.charAt(0) == 'c' || userChoiceChar.charAt(0) == '0')){
					break;
				}
			}
		}
		userInput.nextLine();
		char charChoice = userChoiceChar.charAt(0);
		if(charChoice == '0') {
			return;
		}
		else if(charChoice == 'a') {
			System.out.println("Type a word and press Enter, or press Enter to end input");
			String newWord = userInput.nextLine().trim();
			if(newWord.isEmpty()) {
				return;
			}
			else if(vocabList.checkIfInWordList(vocabList.getVocabFromIndex(userChoice), newWord)) {
				System.out.println("sorry, the word: '"+newWord+"' is alreay listed");
			}
			else {
				vocabList.getWords(vocabList.getVocabFromIndex(userChoice)).addAtHead(newWord);
			}
		}
		else if(charChoice == 'r') {
			System.out.println("Enter a word");
			String newWord = userInput.nextLine().trim();
			if(newWord.isEmpty()) {
				return;
			}
			else if(!vocabList.checkIfInWordList(vocabList.getVocabFromIndex(userChoice), newWord)) {
				System.out.println("sorry, there is no word: '"+newWord+"'");
			}
			else {
				vocabList.getWords(vocabList.getVocabFromIndex(userChoice)).removeWord(newWord);
			}
		}
		else {
			System.out.println("Which word would you like to change?");
			String changeWord = userInput.nextLine().trim();
			if(changeWord.isEmpty()) {
				return;
			}
			if(!vocabList.checkIfInWordList(vocabList.getVocabFromIndex(userChoice), changeWord)) {
				System.out.println("sorry, there is no word: '"+changeWord+"'");
				return;
			}
			System.out.println("Enter a word");
			String newWord = userInput.nextLine().trim();
			if(newWord.isEmpty()) {
				return;
			}
			else if(vocabList.checkIfInWordList(vocabList.getVocabFromIndex(userChoice), newWord)) {
				System.out.println("sorry, the word: '"+newWord+"' is alreay listed");
			}
			else {
				vocabList.getWords(vocabList.getVocabFromIndex(userChoice)).setWordInList(changeWord, newWord);
			}
		}
	}
	
	
	/**
	 * Words starting with a letter: a method that shows all the words that start with a certain letter.
	 */
	public static void allWordsWithLetter() {
		if(vocabList.length() == 0) {
			System.out.println("No topic in memory");
			return;
		}
		char let = 'a';
		while(true) {
			System.out.println("------------------------------\nEnter letter");
			String letter = userInput.next();
			if(letter.length() == 1) {
				let = letter.charAt(0);
				break;
			}
		}
		ArrayList<String> tempList = vocabList.wordsWithStartingLetter(let);
		for(String x:tempList) {
			System.out.println(x);
		}	
	}
	
	/**
	 * Search topic for a word: a method that lets the user search for a words in a topic.
	 */
	public static void searchTopicsForWord() {
		System.out.println("------------------------------\nEnter word");
		String searchWord = userInput.next();
		String topic = vocabList.searchWord(searchWord);
		if(topic.equals("")) {
			System.out.println("The word '"+searchWord+"' is not in any topic");
			return;
		}
		System.out.println("The word '"+searchWord+"' is in topic '"+topic+"'");
	}
	
	/**
	 * Save on file: a method that saves the current linked list on a file.
	 */
	public static void saveOnFile() {
		System.out.println("------------------------------\nEnter file name");
		String file = userInput.next();
		vocabList.writingOnFile(file);
	}
	
	
	// *****Code shortening methods*****
	
	/**
	 * Select a topic: a method for when the user needs to select a topic.
	 */
	public static void topicSelection() {
		System.out.println("------------------------------\r\nPick a topic\r\n------------------------------");
		vocabList.displayFromHeadToTail();
		checkUserChoice(0,vocabList.length());
	}
	
	/**
	 * Adding a topic: a method to add a word to a newly created topic.
	 * 
	 * @param newTopic, the new topic that has been adding.
	 */
	public static void addTopicsToNewVocab(String newTopic) {
		String newWords;
		System.out.println("Enter a word - to quit press Enter:");
		do {
		    newWords = userInput.nextLine().trim();
		    if (!newWords.isBlank()) {
		        vocabList.getWords(newTopic).addAtEnd(newWords);
		    }
		} while (!newWords.isEmpty());
	}
	
	/**
	 * Checking the user's choice: a method that makes sure the user's choice is valid.
	 * @param initialVal, the minimal value the user has to select.
	 * @param finalVal, the maximum value the user has to select.
	 */
	public static void checkUserChoice(int initialVal, int finalVal) {
		while(true) {
			try {
				
				System.out.print("------------------------------\nEnter choice: ");
				userChoice = userInput.nextInt();
				if(userChoice < initialVal || userChoice > finalVal) {
					throw new InputMismatchException();
				}
				break;
			}
			catch(InputMismatchException e) {
				userInput.nextLine();
			}
			
		}
	}
	
	

}
