// -----------------------------------------------------
// Assignment (3)
// Question: (2, Singly linked list)
// Written by: Fred
// -----------------------------------------------------

// This is the singly linked list that contains all the words of a topic.
package stuff;

import java.util.ArrayList;
public class WordLinkedList {
	
	private class WordNode {
		private WordNode next; // This is the node right after the current one
		
		// The word of the node.
		private String word;
		
		/**
		 * Parameterized constructor of the node.
		 * @param word, the word of the node.
		 * @param next, the node that comes after the created node.
		 */
		public WordNode(String word, WordNode next) {
			this.word = word;
			this.next = next;
		}
		
		/**
		 * Setter method of word.
		 * @param newWord, the new word of the node.
		 */
		public void setWord(String newWord) {
			this.word = newWord;
		}
		
		/**
		 * The getter method of the next Node.
		 * @return, return the WordNode that comes after the current node.
		 */
		public WordNode getNext() {
			return this.next;
		}
		
		/**
		 * Getter method for the word.
		 * @return, returns the String of the word of the current node.
		 */
		public String getWord() {
			return this.word;
		}
		
		/**
		 * Setter method for the next node.
		 * @param next, the new next node.
		 */
		public void setNext(WordNode next) {
			this.next = next;
		}
	}
	
	private WordNode head; // The head of the list.
	
	private int counter = 0; // The length of the list.
	
	/**
	 * Default constructor of the list.
	 */
	public WordLinkedList() {
		this.head = null;
		this.counter = 0;
	}
	
	/**
	 * The length of the list.
	 * @return, returns the length of the list using counter.
	 */
	public int length() {
		return counter;
	}
	
	/**
	 * All words of the list: a method that returns all the words of the list.
	 * @return, returns an ArrayList containing all the words of the list.
	 */
	public ArrayList<String> allWords(){
		ArrayList<String> tempList = new ArrayList<String>();
		if(head == null) {
			return null;
		}
		WordNode position = head;
		while(position !=null) {
			tempList.add(position.word);
			position = position.next;
		}
		return tempList;
	}
	
	/**
	 * Words with starting letter: a method that returns all the words of the list starting with given letter.
	 * @param startLet, the starting letter of the words.
	 * @return, returns an ArrayList containing all the words starting with the reference letter.
	 */
	public ArrayList<String> wordArrayList(char startLet){
		ArrayList<String> tempList = new ArrayList<String>();
		if(head == null) {
			return null;
		}
		WordNode position = head;
		while(position != null) {
			if(position.word.charAt(0) == startLet) {
				tempList.add(position.word);
			}
			position = position.next;
		}
		return tempList;
	}
	
	/**
	 * Getting a word from index: returns the word based on its placement in the list.
	 * @param index, int of the index we are looking for.
	 * @return, returns the word that is placed at the index position.
	 */
	public String getWordFromIndex(int index) {
		if(head == null || index > this.counter) {
			return "";
		}
		WordNode position = head;
		for(int i = 1; i!=index;i++) {
			position = position.next;
		}
		return position.word;
	}
	
	/**
	 * Setting a word: a method that replaces the given word by the new word.
	 * @param refWord, the reference word that we want to replace.
	 * @param newWord, the new word.
	 */
	public void setWordInList(String refWord, String newWord) {
		if(head == null) {
			return;
		}
		WordNode position = head;
		while(position != null && !position.word.equals(refWord)) {
			position = position.next;
		}
		if(position != null && position.word.equals(refWord)) {
			position.setWord(newWord);
		}
	}
	
	/**
	 * Add at head: a method that adds a new node at the head.
	 * @param word, the new word that we want to add.
	 */
	public void addAtHead(String word) {
		head = new WordNode(word, head);
		counter++;
	}
	
	/**
	 * Add at end: a method that adds a new node at the end of the list.
	 * @param word, the new word that we want to add.
	 */
	public void addAtEnd(String word) {
		if(head == null) {
			addAtHead(word);
		}
		else {
			WordNode position = head;
			while(position.getNext()!=null) {
				position = position.getNext();
			}
			position.setNext(new WordNode(word,null));
		}
		counter++;
	}
	
	/**
	 * Add after: a method that adds a new word after a given word.
	 * @param word, the new word we want to add.
	 * @param refWord, the reference word we add after.
	 */
	public void addAfter(String word, String refWord) {
		if(head == null) {
			return;
		}
		WordNode position = head;
		while(position != null && !(position.word.equals(refWord))) {
			position = position.getNext();
		}
		if(position == null) {
			System.out.println("Reference word does not exist");
		}
		else {
			position.setNext(new WordNode(word,position.next));
			counter++;
		}
	}
	
	/**
	 * Add before: a method that adds a new word before the reference word.
	 * @param word, the new word.
	 * @param refWord, the reference word.
	 */
	public void addBefore(String word, String refWord) {
		if(head == null) {
			return;
		}
		if(head.word.equals(refWord)) {
			this.addAtHead(refWord);
		}
		WordNode position = head;
		while(position.next != null && !(position.next.word.equals(refWord))){
			position = position.getNext();
		}
		if(position.next != null && position.next.word.equals(refWord)) {
			WordNode tempNode = new WordNode(word, position.next);
			position.next = tempNode;
			counter++;
		}
	}
	
	/**
	 * Remove word: a method that removes a given word.
	 * @param refWord, the word we want to remove.
	 */
	public String removeWord(String refWord) {
		WordNode position = head;
		if(head == null) {
			return "";
		}
		if(position.word.equals(refWord)) {
			//return this.removeHead();
		}
		
		while(position.next != null && !position.next.word.equals(refWord)) {
			position = position.next;
		}
		
		if(position.next != null && position.next.word.equals(refWord)) {
			WordNode temp = position.next;
			position.next = position.next.next;
			counter--;
			return temp.word;
		}
		return "";
	}
	
	public int getLength() {
		return counter;
	}
	
	/**
	 * In words: a method that checks if the given word is in the list.
	 * @param refWord, the word we want to check.
	 * @return, returns boolean of whether the word is in the list or not.
	 */
	public boolean inWords(String refWord) {
		if(head == null) {
			return false;
		}
		WordNode position = head;
		while(position != null && !position.word.equals(refWord)) {
			position = position.next;
		}
		if(position != null && position.word.equals(refWord)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Display: a method that displays the words of the list.
	 */
	public void display() {
		if(head == null) {
			System.out.print("");
		}
		else {
			int num = 1;
			WordNode position = head;
			while(position != null) {
				if(num%4 != 0) {
					System.out.print(num + ": "+position.getWord()+"\t");
				}
				else {
					System.out.print(num + ": "+position.getWord()+"\n");
				}
				position = position.next;
				num++;
			}
		}
	}
	
}
