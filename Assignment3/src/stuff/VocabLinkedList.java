// -----------------------------------------------------
// Assignment (3)
// Question: (3, Doubly linked list)
// Written by: Fred
// -----------------------------------------------------

// This is the doubly linked list containing all the vocab.

package stuff;

import java.util.ArrayList;
import java.util.Collections;
import java.io.*;

public class VocabLinkedList {
	private Node head; // The head node of the list.
    private Node tail; // The tail node of the list.
    private int counter; // The counter int to keep track of the size.
    
    /**
     * The default constructor for the linked list.
     */
    public VocabLinkedList() {
        head = null;
        tail = null;
        counter = 0;
    }

    /**
     * Add at head: a method that adds a node at the head.
     * @param vocab, the vocab value of the node.
     */
    public void addAtHead(String vocab) {
        Node temp = head;
        head = new Node(vocab, null, head);

        if (tail == null) {
            tail = head;
        } else {
            temp.before = head;
        }

        counter++;
    }

    /**
     * Add at tail: a method that adds a node at the tail.
     * @param vocab, the vocab value of the node.
     */
    public void addAtTail(String vocab) {
        Node temp = tail;
        tail = new Node(vocab, tail, null);
        if (head == null) {
            head = tail;
        } else {
            temp.after = tail;
        }

        counter++;
    }

    /**
     * Add after: a method that adds a node after the mentioned node.
     * @param refVocab, the vocab value of the reference node.
     * @param newVocab, the vocab value of the node.
     */
    public void addAfter(String newVocab, String refVocab) {
        Node position = head;
        while (position != null && !position.vocab.equals(refVocab)) {
            position = position.after;
        }
        if (position != null && position.vocab.equals(refVocab)) {
            // if the ref value is the last element
            if (position.after == null) {
                addAtTail(newVocab);
            } else {
                Node n = new Node(newVocab, null, null);
                n.after = position.after;
                n.before = position;
                position.after.before = n;
                position.after = n;
                counter++;
            }
        }
    }
    
    /**
     * Add before: adds a new node with the given vocab before the reference vocab.
     * @param refVocab, the reference vocab.
     * @param newVocab, the new vocab.
     */
    public void addBefore(String newVocab, String refVocab) {
    	if(head == null) {
    		System.out.println("List is empty");
    		return;
    	}
    	else if(head.vocab.equals(refVocab)) {
    		this.addAtHead(newVocab);
    		counter++;
    		return;
    	}
    	Node position = head;
    	while(position.after != null && !position.after.vocab.equals(refVocab)) {
    		position = position.after;
    	}
    	if(position.after != null && position.after.vocab.equals(refVocab)) {
    		Node tempNode = new Node(newVocab, position, position.after);
    		position.after.before = tempNode;
    		position.after = tempNode;
    		counter++;
    	}
    }

    /**
     * Remove head: a method that removes the head.
     * @return, returns the vocab of the removed node.
     */
    public String removeHead() {
        if (head == null) {
            return "";
        } else if (head == tail) {
            Node temp = head;
            head = null;
            tail = null;
            counter--;
            return temp.vocab;
        } else {
            Node temp = head;
            head = head.after;
            head.before = null;
            counter--;
            return temp.vocab;
        }
    }

    /**
     * Remove tail: a method that removes the tail.
     * @return, returns the vocab of the removed node.
     */
    public String removeTail() {
        if (tail == null) {
            return "";
        } else if (head == tail) {
            Node temp = head;
            head = null;
            tail = null;
            counter--;
            return temp.vocab;
        } else {
            Node temp = tail;
            tail = tail.before;
            tail.after = null;
            counter--;
            return temp.vocab;
        }
    }
    
    /**
     * Remove vocab: a method that removes the head of the node of the referenced vocab.
     * @param refVocab, the reference vocab of the node which is going to be removed.
     */
    public void removeVocab(String refVocab) {
    	if(head == null) {
    		System.out.println("List is empty");
    	}
    	else if(head.vocab.equals(refVocab)) {
    		this.removeHead();
    	}
    	else if(tail.vocab.equals(refVocab)) {
    		this.removeTail();
    	}
    	else {
    		Node position = head;
    		while(position != null && !position.vocab.equals(refVocab)) {
    			position = position.after;
    		}
    		if(position != null && position.vocab.equals(refVocab)) {
    			position.before.after = position.after;
    			position.after.before = position.before;
    			position.after = null;
    			position.before = null;
    			counter--;
    		}
    	}
    }

 

    /**
     * Display from head to tail: a method that displays the nodes from head to tail.
     */
    public void displayFromHeadToTail() {
        if (head == null) {
            System.out.println("0 Exit");
        } else {
        	int num = 1;
            Node position = head;

            while (position != null) {
                System.out.println(num++ + " " +position.vocab);
                position = position.after;
            }
            System.out.println("0 Exit");
        }
    }
    
    /**
     * Display from tail to head: a method that displays the nodes from tail to head.
     */
    public void displayFromTailToHead() {
        if (tail == null) {
            System.out.println("The list is empty.");
        } else {
            System.out.println("Displaying from Tail to Head " + counter + " element(s).");
            Node position = tail;
            while (position != null) {
                System.out.println(position.vocab);
                position = position.before;
            }
        }
    }
    
    /**
     * Check if the word is in the list: a method that checks if the word is in a topic from the list.
     * @param vocab, the value of the topic.
     * @param word, the word we want to look at.
     * @return, returns if the word is in the linked list.
     */
    public boolean checkIfInWordList(String vocab, String word) {
    	return this.getWords(vocab).inWords(word);
    }
    
    /**
     * Length: a method that shows the length of the list.
     * @return, return the length of the list.
     */
    public int length() {
    	return counter;
    }
    
    /**
     * Search for a word: a method that searches for a word in the linked list.
     * @param refWord, the word we are looking for.
     * @return, returns the word.
     */
    public String searchWord(String refWord) {
    	if(head == null) {
    		return "";
    	}
    	Node position = head;
    	while(position!= null) {
    		ArrayList<String> tempList = position.words.allWords();
    		for(String x: tempList) {
    			if(x.equals(refWord)) {
    				return position.vocab;
    			}
    		}
    		position = position.after;
    	}
    	return "";
    }
    
    /**
     * Check if in list: a method that checks if the vocab is in the list.
     * @param refVocab, the vocab we want to see if its in the list.
     * @return, returns if the vocab is in the list.
     */
    public boolean inList(String refVocab) {
    	if(head == null) {
    		return false;
    	}
    	Node position = head;
    	while (position != null) {
            if(position.getVocab().equals(refVocab)) {
            	return true;
            }
            position = position.after;
        }
    	return false;
    }
    
    /**
     * Get the words: a method that gives the list of words of a topic.
     * @param refVocab, the vocab we want the words from.
     * @return, a WordLinkedList, which is the list of words of the vocab.
     */
    public WordLinkedList getWords(String refVocab) {
    	if(head == null) {
    		return null;
    	}
    	Node position = head;
    	while(position != null) {
    		if(position != null && position.vocab.equals(refVocab)) {
    			return position.getWordList();
    		}
    		position = position.after;
    	}
    	return null;
    }
    
    /**
     * Getting a vocab from an index: a method that will find the vocab node from the index.
     * @param index, the index of the vocab node we want.
     * @return, returns the vocab String.
     */
    public String getVocabFromIndex(int index) {
    	if(head == null) {
    		return "";
    	}
    	Node position = head;
    	for(int i = 1; i!=index; i++) {
    		position = position.after;
    	}
    	return position.vocab;
    }
    
    /**
     * Display words: a method that display all the words of a node.
     * @param nodeIndex, the index of the wanted vocab node.
     */
    public void wordsDisplay(int nodeIndex) {
    	if(head == null) {
    		return;
    	}
    	Node position = head;
    	for(int i = 1; i!=nodeIndex;i++) {
    		position = position.after;
    	}
    	System.out.println("Topic: "+position.vocab);
    	position.getWordList().display();
    	System.out.println("\n");
    }
    
    /**
     * Write on file: a method that writes down all the information of the linked list on a file.
     * @param file, the file name.
     */
    public void writingOnFile(String file) {
    	PrintWriter myWriter = null;
    	try {
    		if(head == null) {
    			return;
    		}
    		myWriter = new PrintWriter(new FileOutputStream(file+".txt"));

    		Node position = head;
    		while(position != null) {
    			myWriter.write("#"+position.vocab+"\n");
    			ArrayList<String> wordList = position.getWordList().allWords();
    			for(String x:wordList) {
    				myWriter.write(x+"\n");
    			}
    			position = position.after;
    		}
    		myWriter.close();
    	}
    	catch(IOException e) {
    		
    	}
    }
    
    /**
     * All words that start with a letter: a method that returns all the words in the list that starts with a certain letter.
     * @param startLetter, the letter.
     * @return, returns an ArrayList that is sorted that contains all the words that start with the letter.
     */
    public ArrayList<String> wordsWithStartingLetter(char startLetter){
    	ArrayList<String> wordList = new ArrayList<String>();
    	if(head == null) {
    		return null;
    	}
    	Node position = head;
    	while(position != null) {
    		wordList.addAll(position.getWordList().wordArrayList(startLetter));
    		position = position.after;
    	}
    	Collections.sort(wordList);
    	return wordList;
    }
    
    /**
     * The node for the linked list, inner class.
     */
    private class Node {

    	// The data of the node, the vocab word (String) and the words (WordLinkedList).
        private String vocab;
        private WordLinkedList words;
        // The before and after node.
        private Node after;
        private Node before;
        
        /**
         * The constructor method of the node.
         * @param vocab, the vocab word.
         * @param before, the node that comes before in the list.
         * @param after, the node that comes after in the list.
         */
        public Node(String vocab, Node before, Node after) {
            this.vocab = vocab;
            this.before = before;
            this.after = after;
            this.words = new WordLinkedList();
        }
        
        /**
         * The get method of the vocab word.
         * @return, returns the String of the vocab of the node.
         */
        public String getVocab() {
        	return this.vocab;
        }
        
        /**
         * The get method of the words.
         * @return, returns the WordLinkedList of the words of the node.
         */
        public WordLinkedList getWordList() {
        	return this.words;
        }
    }
}
