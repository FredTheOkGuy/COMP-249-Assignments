// -----------------------------------------------------
// Assignment (2)
// Question: (1,2 & 3)
// Written by: Fred
// -----------------------------------------------------


// This program takes in a text file that contains the cvs files of movies, it then goes through all those movie files and takes the movies and put them in
// their own cvs file depending on their genre or if their badly written. Then we take in a text file with all the genre cvs files, go through all the movies
// add them to an array of their own genre and adds that array to a ser file. Then you can navigate through all those movies.

package stuff;

import java.io.*; // Input all the IO stuff
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;


public class Movie implements Serializable{

	private int year; // Int, year of the movie.
	private String title; // String, title of the movie.
	private int duration; // Int, duration of the movie.
	private String genres; // String, genre of the movie.
	private String rating; //String, rating of the movie.
	private double score; // Double, score of the movie.
	private String director; // String, director of the movie.
	private String actor1; // String, the first actor of the movie.
	private String actor2; // String, the second actor of the movie.
	private String actor3; // String, the third actor of the movie.
	
	// String array containing all the valid genres for movies.
	final static String[] validGenres = {"musical","comedy", "animation", "adventure", "drama", "crime", "biography","horror", "action", "documentary", "fantasy", "mystery", "sci-fi", "family", "romance", "thriller","western"};
	final static String[] validRatings = {"PG", "Unrated","G","R","PG-13","NC-17"}; // String array of all the valid ratings of movies.
	static PrintWriter[] genresWriters = new PrintWriter[validGenres.length]; // A PrintWriter array containing all the print writers to write genre files.
	static Scanner myReader = null; // Scanner, to read files.
	static ObjectInputStream myObjectReader = null; // ObjectInputStream to read objects.
	static int[] numMoviesGenres = new int[validGenres.length]; // Int array used to count ho many movies an array has.
	
	/**
	 * Customized Movie constructor
	 * 
	 * @param y The year
	 * @param t the title
	 * @param d the duration
	 * @param g the genre
	 * @param r the rating
	 * @param s the score
	 * @param di the director
	 * @param a1 actor 1
	 * @param a2 actor 2
	 * @param a3 actor 3
	 */
	public Movie(int y, String t, int d, String g, String r, double s, String di, String a1, String a2, String a3) {
		year = y;
		title = t;
		duration = d;
		genres = g;
		rating = r;
		score = s;
		director = di;
		actor1 = a1;
		actor2 = a2;
		actor3 = a3;
	}
	
	/**
	 * Accessor for the year of the movie.
	 *
	 * @return The year of the movie.
	 */
	public int getYear() {
		return year;
	}
	/**
	 * Mutator to set the year of the movie.
	 *
	 * @param year The year of the movie to set.
	 */
	public void setYear(int year) {
		this.year = year;
	}
	/**
	 * Accessor for the title of the movie.
	 *
	 * @return The title of the movie.
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * Mutator to set the title of the movie.
	 *
	 * @param title The title of the movie to set.
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * Accessor for the duration of the movie.
	 *
	 * @return The duration of the movie.
	 */
	public int getDuration() {
		return duration;
	}
	/**
	 * Mutator to set the duration of the movie.
	 *
	 * @param duration The duration of the movie to set.
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}
	/**
	 * Accessor for the genres of the movie.
	 *
	 * @return The genres of the movie.
	 */
	public String getGenres() {
		return genres;
	}
	/**
	 * Mutator to set the genres of the movie.
	 *
	 * @param genres The genres of the movie to set.
	 */
	public void setGenres(String genres) {
		this.genres = genres;
	}
	/**
	 * Accessor for the rating of the movie.
	 *
	 * @return The rating of the movie.
	 */
	public String getRating() {
		return rating;
	}
	/**
	 * Mutator to set the rating of the movie.
	 *
	 * @param rating The rating of the movie to set.
	 */
	public void setRating(String rating) {
		this.rating = rating;
	}
	/**
	 * Accessor for the score of the movie.
	 *
	 * @return The score of the movie.
	 */
	public double getScore() {
		return score;
	}
	/**
	 * Mutator to set the score of the movie.
	 *
	 * @param score The score of the movie to set.
	 */
	public void setScore(double score) {
		this.score = score;
	}
	/**
	 * Accessor for the director of the movie.
	 *
	 * @return The director of the movie.
	 */
	public String getDirector() {
		return director;
	}
	/**
	 * Mutator to set the director of the movie.
	 *
	 * @param director The director of the movie to set.
	 */
	public void setDirector(String director) {
		this.director = director;
	}
	/**
	 * Accessor for the first actor of the movie.
	 *
	 * @return The first actor of the movie.
	 */
	public String getActor1() {
		return actor1;
	}
	/**
	 * Mutator to set the first actor of the movie.
	 *
	 * @param actor1 The first actor of the movie to set.
	 */
	public void setActor1(String actor1) {
		this.actor1 = actor1;
	}
	/**
	 * Accessor for the second actor of the movie.
	 *
	 * @return The second actor of the movie.
	 */
	public String getActor2() {
		return actor2;
	}
	/**
	 * Mutator to set the second actor of the movie.
	 *
	 * @param actor2 The second actor of the movie to set.
	 */
	public void setActor2(String actor2) {
		this.actor2 = actor2;
	}
	/**
	 * Accessor for the third actor of the movie.
	 *
	 * @return The third actor of the movie.
	 */
	public String getActor3() {
		return actor3;
	}
	/**
	 * Mutator to set the third actor of the movie.
	 *
	 * @param actor3 The third actor of the movie to set.
	 */
	public void setActor3(String actor3) {
		this.actor3 = actor3;
	}
	
	/**
	 * To string returns a string containing all the movies information
	 * 
	 * @return String containing the movie's information
	 */
	@Override
	public String toString() {
		return this.year+","+this.title+","+this.genres+","+this.rating+","+this.score+","+this.director+","+this.actor1+","+this.actor2+","+this.actor3;
	}
	
	/**
	 * Equals method makes sure the two objects are equals
	 * 
	 * @return a boolean of if they're equal
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return Objects.equals(actor1, other.actor1) && Objects.equals(actor2, other.actor2)
				&& Objects.equals(actor3, other.actor3) && Objects.equals(director, other.director)
				&& duration == other.duration && Objects.equals(genres, other.genres)
				&& Objects.equals(rating, other.rating)
				&& Double.doubleToLongBits(score) == Double.doubleToLongBits(other.score)
				&& Objects.equals(title, other.title) && year == other.year;
	}

	/**
	 * class do part1, basically try to see if an movie does'nt throw an exception, then use the constructor of movie to create a movie object with those values
	 * if there is an exception that is thrown, create an object either way, but add in the invalid value and it d the bad movie text file, using the
	 * thing that lets you add objects to a text file.
	 * 
	 * @param manifestFile a String of the name of the first manifest file.
	 */
	public static void do_part1(String manifestFile){
		Scanner manifestReader = null; // Initialize the scanner
		PrintWriter badMovieWriter = null; // Initialize the PrintWriter
		try {
		manifestReader = new Scanner(new FileInputStream(manifestFile)); // Try to open the file to read it
		while(manifestReader.hasNextLine()) { // While there is lines in the file
			
			String file = manifestReader.nextLine(); // Read the line and assign it to a String, this is the file of the movies of a specific year.
			int fileLine = 0; // Keep track of which line a movie is on (for the bad movies record)
			try { // Try to create a new scanner to help read lines of text
				myReader = new Scanner(new FileInputStream(file)); // User our reader to read the file of the movies
				
				String line = ""; // Create a string for the line
				while(myReader.hasNextLine()) { // While there are more lines in the file
					Boolean badMovie = false; // Variable to see if we add it to the bad movie file
					String exceptionMessage ="";
					fileLine +=1;
					try { // Try because we can throw exceptions
						line = myReader.nextLine();
						String[] lineFields = line.trim().split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1); // Split the line into sections, making sure 
						// that if there is a comma in between quotation marks, it doesn't see it as a place to split
						// Each thing under are the throw for each exceptions
						
						// Fields **************************************//
						if(lineFields.length > 10) {
							throw new ExcessFieldException("There is too many fields in this line. Syntax Error");
						}
						else if(lineFields.length < 10) {
							throw new MissingFieldException("There is some missing fields in this line. Syntax Error");
						}
						// ****************************************//
					
					
						// Year **************************************//
						if(lineFields[0].equals("")) {
							throw new MissingYearException("Missing year. Semantic Error");
						}
					
						// Try to see if it is possible to turn the year into an int, if not it is a missing year
						try {
							Integer.parseInt(lineFields[0]);
						}
						catch(NumberFormatException nfe) {
							throw new InvalidYearException("Invalid year. Semantic Error");
						}
					
							// If the year isin't valid
						if(Integer.parseInt(lineFields[0]) < 1990 || Integer.parseInt(lineFields[0]) > 1999) {
							throw new InvalidYearException("Invalid year. Semantic Error");
						}
						// ****************************************************//
					
					
						// Title ************************************************//
						if(lineFields[1].equals("")) {
							throw new MissingTitleException("Missing title. Semantic Error");
						}
						// If there is some missing quotes
						if((lineFields[1].charAt(0) == '"' && lineFields[1].charAt(lineFields[1].length()-1) != '"') || (lineFields[1].charAt(0) != '"' && lineFields[1].charAt(lineFields[1].length()-1) == '"') ) {
							throw new MissingQuoteException("Missing quote. Syntax Error");
						}
						// ******************************************************//
					
					
						// Duration *********************************************//
						if(lineFields[2].equals("")) {
							throw new MissingDurationException("Missing duration. Semantic Error");
						}
						try {
							Integer.parseInt(lineFields[2]);
						}
						catch(NumberFormatException nfe) {
							throw new InvalidDurationException("Invalid Duration. Semantic Error");
						}
					
						if(Integer.parseInt(lineFields[2]) < 30 || Integer.parseInt(lineFields[2]) > 400) {
							throw new InvalidDurationException("Invalid duration. Semantic Error");
						}
						//***************************************************//
					
						// To continue fred, write a for loop that will look if the genre is inside the acceptable genre array, if not throw exception, basically write
						// code to throw exceptions for every exception and the rest well figure it out later.
						// Genre ***********************************************//
						if(lineFields[3].equals("")) {
							throw new MissingGenreException("Missing Genre. Semantic Error");
						}
					
						boolean validMovieGenre = false;
						for(int i = 0; i<validGenres.length; i++) {
							if(lineFields[3].toLowerCase().equals(validGenres[i].toLowerCase())) {
								validMovieGenre = true;
								break;
							}	
						}
						if(!validMovieGenre) {
							throw new InvalidGenreException("Invalid genre. Semantic Error");
						}
						//*************************************************//
					
					
						// Ratings ***********************************************//
						if(lineFields[4].equals("")) {
							throw new MissingRatingException("Missing Rating. Semantic Error");
						}
					
						boolean validMovieRating = false;
						for(int i = 0; i<validRatings.length; i++) {
							if(lineFields[4].toLowerCase().equals(validRatings[i].toLowerCase())) {
								validMovieRating = true;
								break;
							}	
						}
						if(!validMovieRating) {
							throw new InvalidRatingException("Invalid Rating. Semantic Error");
						}
						//*************************************************//
					
						
						// Score *********************************************//
						if(lineFields[5].equals("")) {
							throw new MissingScoreException("Missing Score. Semantic Error");
						}
						try {
							Double.parseDouble(lineFields[5]);
						}
						catch(NumberFormatException nfe) {
							throw new InvalidScoreException("Invalid Score. Semantic Error");
						}
						
						if(Double.parseDouble(lineFields[5]) < 0 || Double.parseDouble(lineFields[5]) > 10) {
							throw new InvalidScoreException("Invalid Score. Semantic Error");
						}
						//***************************************************//
					
						if(lineFields[6].equals("") || lineFields[7].equals("") || lineFields[8].equals("") || lineFields[9].equals("")) {
							throw new MissingNameException("Missing name. Semantic Error");
						}
						//*****************************************************//
					
					
						// If it reaches this point, no exception has been thrown, so the movie has no mistake
						// So we assign each of the fields to a variable
						// Write movie in .cvs file *************************//
						int year = Integer.parseInt(lineFields[0]);
						String title =lineFields[1];
						int duration =Integer.parseInt(lineFields[2]);
						String genres =lineFields[3];
						String rating =lineFields[4];
						double score = Double.parseDouble(lineFields[5]);
						String director =lineFields[6];
						String actor1 =lineFields[7];
						String actor2 =lineFields[8];
						String actor3 = lineFields[9];
						
						// We go through our PrintWriters for genres, if its null, then we create a new file which is the name
						// Of the current movie's genre + .cvs.
						// Then we write the movie line of that file
						// We also add 1 to the number of movies of that genre.
						for(int i = 0; i<validGenres.length; i++) {
							if(genres.equalsIgnoreCase(validGenres[i])) {
								if(genresWriters[i] == null) {
									genresWriters[i] = new PrintWriter(new FileOutputStream(genres+".cvs"));
								}
								genresWriters[i].write(line+"\n");
								numMoviesGenres[i] += 1;
							}
						}
						//***********************************************//
						
					
					}
					// We catch all the exception that can be thrown, this means that the movie is bad (true), we assign exceptionMessage to the message
					// that was given by the thrown exception.
					catch(MovieMistakeException e) {
						badMovie = true;
						exceptionMessage = e.getMessage();
					}
					catch(FileNotFoundException e) {
						System.out.println("A file has not been found!");
					}
					catch(Exception e) {
						
					}
					finally { // Finally block, if its true that the current movie is bad, then, if the badMovieWriter is null, we make it create a bad movie text
							  // Then we add that movie and extra information on the text file.
						if(badMovie) {
							if(badMovieWriter == null) {
								badMovieWriter = new PrintWriter(new FileOutputStream("bad_movie_records.txt"));
								badMovieWriter.write("Error: "+exceptionMessage +"\nMovie Record: "+ line+"\nInput File: "+ file+"\nLine: "+fileLine+"\n");
							}
							else {
								badMovieWriter.write("Error: "+exceptionMessage +"\nMovie Record: "+ line+"\nInput File: "+ file+"\nLine: "+fileLine+"\n");
							}
							
						}
					}

				}
			} // If the file isn't found
			catch(FileNotFoundException fnfe) {
				System.out.println("The file was not found");
			}
			}
		} // If the file isn't found
		catch(FileNotFoundException fnfe) {
			System.out.println("File not found!");
		}
		finally { // At the end of all of this, we have to close all the readers and writers.
			manifestReader.close();
			badMovieWriter.close();
			for(int i =0; i<genresWriters.length; i++) {
				if(genresWriters[i] != null) {
					genresWriters[i].close();
				}
			}
		}
	}
	
	
	/**
	 * 
	 * This method takes all the cvs files written in the manifest part 2 file, makes arrays of movies using the movies in each
	 * CVS file and puts them into an array, then puts the array in a ser file.
	 * 
	 * @param part2Manifest a String of the name of the part 2 manifest file
	 */
	public static void do_part2(String part2Manifest) {
		ObjectOutputStream genreSer = null;
		try {
		for(int i = 0; i<validGenres.length; i++) { // Start a loop for the amount of genres there is
			int movieArrayIndex = 0;
			myReader = new Scanner(new FileInputStream(validGenres[i]+".cvs")); // Read the cvs file of the current genre
			genreSer = new ObjectOutputStream(new FileOutputStream(validGenres[i]+".ser")); // create a ser file of the current genre
			
			
			Movie[] tempMovieArray = new Movie[numMoviesGenres[i]]; // Create an array of the good length using the numMoviesGenres array to know how many
																	// movies a specific genre has.
			while(myReader.hasNextLine()) { // while loop until there is no more lines in the file
				String lineFields[] = myReader.nextLine().trim().split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1); // An array containing each field of the line
				// Then using that array add a new Movie object to the array of movies
				tempMovieArray[movieArrayIndex] = new Movie(Integer.parseInt(lineFields[0]),lineFields[1],Integer.parseInt(lineFields[2]),lineFields[3],lineFields[4],Double.parseDouble(lineFields[5]),lineFields[6],lineFields[7],lineFields[8],lineFields[9]);
				movieArrayIndex += 1; // +1 for the movie array index
			}
			genreSer.writeObject(tempMovieArray); // Write that array of movies to the ser file
			genreSer.close(); // Close that writer
			}
		myReader.close(); // Close the reader
			
		}
		catch(FileNotFoundException e) {
			
		}
		catch(IOException e) {
			
		}
	
	}
	
	
	
	
	/**\
	 * This method will open the part 3 manifest file which contains the name of the movie genres .ser files, it will
	 * take each of those ser files and  deserialize them, getting an array of Movie objects, it will
	 * then add that array of movie objects into an array of movie objects array (2d array), it returns that 2d array.
	 * 
	 * @param part3Manifest a String of the name of the part 3 manifest file.
	 * @return returns a 2d Movie array of all the movies organized by their genre.
	 */
	public static Movie[][] do_part3(String part3Manifest) {
		String[] serFiles = new String[validGenres.length]; // An array that will contain all the genre lines as a String
		Movie[][] allMovies = new Movie[validGenres.length][]; //  A 2d Movie array
		int moviesIndex = 0; // To keep track of the current movie index
		try { // Try loop to open the part 3 manifest file
			myReader = new Scanner(new FileInputStream(part3Manifest));
			for(int i = 0; i<serFiles.length; i++){ // Go through all the genres in the part 3 manifest file
				serFiles[i] = myReader.nextLine(); // Ad the line to the String array
			}
			myReader.close(); // Close the reader
		}
		catch(FileNotFoundException fnfe) {
			
		}
		
		for(int j = 0; j<serFiles.length; j++) { // Start a loop that will go through all the Strings in the String array.
			try {
				myObjectReader = new ObjectInputStream(new FileInputStream(serFiles[j])); // Open the current genre file .ser
				allMovies[moviesIndex] = (Movie[])myObjectReader.readObject(); // Read the object that is in the .ser file, and cast it as a Movie array
				moviesIndex++; // Add one to the movie index
			}
			catch(FileNotFoundException e) {
				
			}
			catch(IOException e) {
			}
			catch(ClassNotFoundException e) {
			}
		}
		return allMovies; // Return the 2d movie array
		
		

	}
	
	/**
	 * This method lets you select which movie genre you want to navigate and lets you navigate all the movies of that genre.
	 * 
	 * @param allMovies the 2d movie array containing all the movies organized by their genre.
	 */
	public static void navigateMovies(Movie[][] allMovies) {		System.out.println("Welcome to Frederic's movie navigator!\n");
		int newCurrentPos = 0; // A temporary in for the movie position
		final int numMovieGenres = validGenres.length; // The number of movie genres
		Scanner userInput = new Scanner(System.in); // To be able to read the user's input
		String userChoiceChar = ""; // The choice of the user, when he needs to select a char
		int userChoiceInt = 0; // The choice of the user, when he needs to select an int
		int currentMovieGenre = 0; // The current genre
		int currentGenrePosition[] = new int[numMovieGenres-1]; // An int array to keep tracked which position for a genre
		do { // Star a do while loop
			System.out.println("-----------------------------\nMain Menu\n-----------------------------\ns Select a movie array to navigate"); // Print menu
			if(allMovies[currentMovieGenre] == null) {
				System.out.println("n Navigate "+validGenres[currentMovieGenre] + " movies (0 records)"); // If the movie your navigating has no movies
			} 
			else { // If there is movies
				System.out.println("n Navigate " + validGenres[currentMovieGenre] + " movies ("+allMovies[currentMovieGenre].length+ " records)");
			}
			System.out.println("x Exit\n-----------------------------");
			
			
			do { // Start another do while loop, this will verify that the user inputs a valid option
				System.out.print("\nEnter your choice: ");
				userChoiceChar = userInput.next().toLowerCase();
			}
			while(!(userChoiceChar.equals("x") || userChoiceChar.equals("s") || userChoiceChar.equals("n")));
			
			
			
			if(userChoiceChar.equals("s")){  // If the user inputs s...
				System.out.println("\n------------------------------\r\n"
						+ "Genre Sub-Menu\r\n"
						+ "------------------------------");
				for(int i = 0; i<numMovieGenres; i++) { // Print out all the genres, amount of movies, as well as the number to select
					if(allMovies[i] != null) { // If there is a movie in that genre...
						System.out.printf("%-9d%-16s(%d movies)\n",i+1, validGenres[i] , allMovies[i].length);
					}
					else { // If there is not a movie in that genre...
						System.out.printf("%-9d%-16s(%d movies)\n",i+1, validGenres[i] , 0);
					}
				}
				System.out.print("18\t Exit\n------------------------------\r\n"
						+ "Enter Your Choice: ");
				while(true) { // Start a loop that will make sure that the choice is valid
					try { // Try block, in case the given input is not an int
						userChoiceInt = userInput.nextInt(); // If the user inputs not an int, its going to throw an InputMismatchException
						if(userChoiceInt < 1 || userChoiceInt > 18) // If its not a valid option, throw an InputMismatchException
							throw new InputMismatchException();
						break; // If nothing is thrown, break the while loop.
					}
					catch(InputMismatchException e) {
						userInput.next(); // Junk line
						System.out.print("Enter a valid choice: "); // Ask for a valid choice
					}
				}
				if(userChoiceInt != 18) // If the user's choice is valid and is not 18 (exit0, make the current movie genre = choice - 1 (-1 since index goes from 0 - n-1)
					currentMovieGenre = userChoiceInt - 1;
			}
			
			
			if(userChoiceChar.equals("n")) { // if the user select's n
				if(allMovies[currentMovieGenre] != null) { // If the current genre has movies
					System.out.println("\nNagivating "+validGenres[currentMovieGenre] + " movies ("+currentGenrePosition[currentMovieGenre]+")");
					// Print which genre the suer is navigating as well as the current movie position
					while(true) { // While loop that will make sure that the user inputs an int
						try {
							System.out.print("Enter a valid choice: ");
							userChoiceInt = userInput.nextInt();
							break;
						}
						catch(InputMismatchException e) {
							userInput.next();
						}
					}
						 // If the user's choice is bigger than 0
					if(userChoiceInt > 0) { // This will display all n elements under the current navigating position.
						if(currentGenrePosition[currentMovieGenre] - userChoiceInt < 0) {
							newCurrentPos = 0;
							System.out.println("EOF has been reached"); // If current position - n is smaller than 0, print this
							for(int i = currentGenrePosition[currentMovieGenre]-1; i>=0; i--) {
								System.out.println(allMovies[currentMovieGenre][i]);
							}
						}
						else {
							newCurrentPos = currentGenrePosition[currentMovieGenre] - userChoiceInt;
							for(int i = currentGenrePosition[currentMovieGenre]-1; i>=newCurrentPos;i--) {
								System.out.println(allMovies[currentMovieGenre][i]);
							}
						}
					}
					else if(userChoiceInt < 0) { // If the user's choice is smaller than 0, it will display all movies n elements over the current position
						if((userChoiceInt * -1) + currentGenrePosition[currentMovieGenre] > allMovies[currentMovieGenre].length - 1) {
							newCurrentPos = allMovies[currentMovieGenre].length;
							System.out.println("BOF has been reached"); // If current position + n > amount of movies
							for(int i = currentGenrePosition[currentMovieGenre]; i<allMovies[currentMovieGenre].length; i++) {
								System.out.println(allMovies[currentMovieGenre][i]);
							}
						}
						else {
							newCurrentPos = (userChoiceInt * -1) + currentGenrePosition[currentMovieGenre];
							for(int i = currentGenrePosition[currentMovieGenre]; i<newCurrentPos; i++) {
								System.out.println(allMovies[currentMovieGenre][i]);
							}
						}
						// In a cases, set newCurrentPos
					}
					else {
						// If n = 0, do nothing
					}
					currentGenrePosition[currentMovieGenre] = newCurrentPos; // We set the current position of the genre to the same value as newCurrentPos
				}
				else {
						System.out.println("\nNavigating "+validGenres[currentMovieGenre]+ " movies (0)\nNo movies to navigate!\n");
					}
			}
				
			if(userChoiceChar.equals("x")) {
				System.out.println("Thank you and goodbye!");
			}
			
			
		}
		while(!(userChoiceChar.equals("x"))); // Do all this while the user's choice is not x or X
	}
	
	
	
	
	
	
	
/**
 * Main method, that will call do_part1, do_part2, do_part3 and navigateMovie method.
 * 
 * @param args arguments?
 */
	public static void main(String[] args) {
		
		do_part1("part1_manifest.txt");
		do_part2("part2_manifest.txt");
		Movie[][] movieArray = do_part3("part3_manifest.txt");
		
		navigateMovies(movieArray);
		
	}
	
	
	
	
	
// Exceptions:
/**
* This exception extends MovieMistakeException, when missing quotes.
*/	
}
class MissingQuoteException extends MovieMistakeException{
	public MissingQuoteException(String message) {
		super(message);
	}
}
/**
 * This exception extends MovieMistakeException, when excess fields.
 */
class ExcessFieldException extends MovieMistakeException{
	public ExcessFieldException(String message) {
		super(message);
	}
}
/**
 * This exception extends MovieMistakeException, when missing fields.
 */
class MissingFieldException extends MovieMistakeException{
	public MissingFieldException(String message) {
		super(message);
	}
}
/**
 * This exception extends MovieMistakeException, when missing title.
 */
class MissingTitleException extends MovieMistakeException{
	public MissingTitleException(String message) {
		super(message);
	}
}
/**
 * This exception extends MovieMistakeException, when missing name
 */
class MissingNameException extends MovieMistakeException{
	public MissingNameException(String message) {
		super(message);
	}
}
/**
 * This exception extends MovieMistakeException, when invalid year.
 */
class InvalidYearException extends MovieMistakeException{
	public InvalidYearException(String message) {
		super(message);
	}
}
/**
 * This exception extends MovieMistakeException, when missing year.
 */
class MissingYearException extends MovieMistakeException{
	public MissingYearException(String message) {
		super(message);
	}
}
/**
 * This exception extends MovieMistakeException, when missing duration.
 */
class MissingDurationException extends MovieMistakeException{
	public MissingDurationException(String message) {
		super(message);
	}
}
/**
 * This exception extends MovieMistakeException, when invalid duration.
 */
class InvalidDurationException extends MovieMistakeException{
	public InvalidDurationException(String message) {
		super(message);
	}
}
/**
 * This exception extends MovieMistakeException, when missing genre.
 */
class MissingGenreException extends MovieMistakeException{
	public MissingGenreException(String message) {
		super(message);
	}
}
/**
 * This exception extends MovieMistakeException, when invalid genre.
 */
class InvalidGenreException extends MovieMistakeException{
	public InvalidGenreException(String message) {
		super(message);
	}
}
/**
 * This exception extends MovieMistakeException, when missing rating.
 */
class MissingRatingException extends MovieMistakeException{
	public MissingRatingException(String message) {
		super(message);
	}
}
/**
 * This exception extends MovieMistakeException, hen invalid rating.
 */
class InvalidRatingException extends MovieMistakeException{
	public InvalidRatingException(String message) {
		super(message);
	}
}
/**
 * This exception extends MovieMistakeException, when missing score.
 */
class MissingScoreException extends MovieMistakeException{
	public MissingScoreException(String message) {
		super(message);
	}
}
/**
 * This exception extends MovieMistakeException, when invalid score.
 */
class InvalidScoreException extends MovieMistakeException{
	public InvalidScoreException(String message) {
		super(message);
	}
}

/**
 * This is a exception of when there is a mistake in the movie's information, extends Exception
 */
class MovieMistakeException extends Exception{
	public MovieMistakeException(String message) {
		super(message);
	}
}






