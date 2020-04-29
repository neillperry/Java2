/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.catalog;

import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

// OF COURSE THIS CLASS DOESN'T COMPILE
// Your first job is to fulfill the contract that this class has signed.
public class InMemoryCatalog implements Catalog {
	
	private List<MusicItem> catalogData = new ArrayList(Arrays.asList(
	             /* id    title                        artist                       releaseDate  price  musicCategory */
	  new MusicItem(1L,  "Diva",                      "Annie Lennox",              "1992-01-04", 13.99, MusicCategory.POP),
	  new MusicItem(2L,  "Dream of the Blue Turtles", "Sting",                     "1985-02-05", 14.99, MusicCategory.POP),
	  new MusicItem(3L,  "Trouble is...",             "Kenny Wayne Shepherd Band", "1997-08-08", 14.99, MusicCategory.BLUES),
	  new MusicItem(4L,  "Lie to Me",                 "Jonny Lang",                "1997-08-26", 17.97, MusicCategory.BLUES),
	  new MusicItem(5L,  "Little Earthquakes",        "Tori Amos",                 "1992-01-18", 14.99, MusicCategory.ALTERNATIVE),
	  new MusicItem(6L,  "Seal",                      "Seal",                      "1991-08-18", 17.97, MusicCategory.POP),
	  new MusicItem(7L,  "Ian Moore",                 "Ian Moore",                 "1993-12-05",  9.97, MusicCategory.CLASSICAL),
	  new MusicItem(8L,  "So Much for the Afterglow", "Everclear",                 "1997-01-19", 13.99, MusicCategory.ROCK),
	  new MusicItem(9L,  "Surfacing",                 "Sarah McLachlan",           "1997-12-04", 17.97, MusicCategory.ALTERNATIVE),
	  new MusicItem(10L, "Hysteria",                  "Def Leppard",               "1987-06-20", 17.97, MusicCategory.ROCK),
	  new MusicItem(11L, "A Life of Saturdays",       "Dexter Freebish",           "2000-12-06", 16.97, MusicCategory.RAP),
	  new MusicItem(12L, "Human Clay",                "Creed",                     "1999-10-21", 18.97, MusicCategory.ROCK),
	  new MusicItem(13L, "My, I'm Large",             "Bobs",                      "1987-02-20", 11.97, MusicCategory.COUNTRY),
	  new MusicItem(14L, "So",                        "Peter Gabriel",             "1986-10-03", 17.97, MusicCategory.POP),
	  new MusicItem(15L, "Big Ones",                  "Aerosmith",                 "1994-05-08", 18.97, MusicCategory.ROCK),
	  new MusicItem(16L, "90125",                     "Yes",                       "1983-10-16", 11.97, MusicCategory.ROCK),
	  new MusicItem(17L, "1984",                      "Van Halen",                 "1984-08-19", 11.97, MusicCategory.ROCK),
	  new MusicItem(18L, "Escape",                    "Journey",                   "1981-02-25", 11.97, MusicCategory.CLASSIC_ROCK))
	);

	public int size(){
		return catalogData.size();
	}


	public MusicItem findById(Long id) {
		// create a for-each loop iterates over the entire array
		for (MusicItem m: catalogData){
			// if statement to check if it is the music item I am looking for
			if (m.getId().equals(id)) {
				return m;
			}
		}
		return null;
	}

	public Collection<MusicItem> findByKeyword(String keyword){

		//create a blank array that we will return
		List<MusicItem> subArray = new ArrayList();

		// change search keyword to lowercase
		String lowerKeyword = keyword.toLowerCase();

		//iterate over the entire catalogData array
		for (MusicItem m: catalogData){

			// for each element in the array, check to see if it's title or artist contain the keyword
			if (m.getArtist().toLowerCase().contains(lowerKeyword) || m.getTitle().toLowerCase().contains(lowerKeyword)) {

				// if there is a match, add that MusicItem m to the subArray that is returned at hte end of the method
				subArray.add(m);
			}
		}

		// after iterating over the array, return the subArray created at the beginning of the method
		return subArray;
	}

	public Collection<MusicItem> findByCategory(MusicCategory category){

		//create a blank array that we will return
		List<MusicItem> subArray = new ArrayList();

		//iterate over the entire catalogData array
		for (MusicItem m: catalogData){
			// for each element in the array, check to see if it's category matches the one the method is searching for
			if (m.getMusicCategory().equals(category)) {
				// if there is a match, add that MusicItem m to the subArray that is returned at hte end of the method
				subArray.add(m);
			}
		}
		// after iterating over the array, return the subArray created at the beginning of the method
		return subArray;
	}

	public Collection<MusicItem> getAll(){
		return Collections.checkedList(catalogData, MusicItem.class);
	}


	// AFTER YOU'VE SATISFIED YOUR CONTRACTUAL OBLIGATIONS ABOVE, DO THESE ADDITIONAL TASKS.
	// NOTES:

	// 0. You can tackle them in any order, each one is independent of the others.

	// 1. None of these methods should print to stdout! (the console).  Instead, return a value.
	//    Each one should be tested by client-side code
	//    (and there you *can* print your results, to verify that your code works as it should).
	//    Be smart here: don't write a single giant main() method, figure out a better way.
	//    Next week, we'll do unit testing with JUnit, but until that time, figure something else out.

	// 2. You may need to research a few things, that's to be expected.  Life Is Open-Book...
	//    The Javadoc is a good first place to look.

	// 3. Keep a lookout for redundant code.  There is a high probability that you will write a chunk
	//    of code more than once.  When you see that, you should strongly consider refactoring that
	//    repeated code into a private method, and then calling that method from where it's needed.
	//    IntelliJ helps a lot here.  Select the repeated code in question, then right-click -> Refactor ->
	//    Extract Method.
	//    It's not just about removing redundancies - it will make the more complicated methods easier to write!

	/**
	 * TASK: find all MusicItems where title is same as artist.
	 * For example, Madonna's first album is simply titled, "Madonna."
	 */
	public Collection<MusicItem> sameArtistTitle(){

		//create a blank array that we will return
		ArrayList<MusicItem> subArray = new ArrayList();

		//iterate over the entire catalogData array
		for (MusicItem m: catalogData){
			// for each element in the array, check to see if it's title is the saem as it's artist
			if (m.getArtist().toLowerCase().equals(m.getTitle().toLowerCase())) {

				// if there is a match, add that MusicItem m to the subArray that is returned at hte end of the method
				subArray.add(m);
			}
		}
		// after iterating over the array, return the subArray created at the beginning of the method
		return subArray;
	}


	/**
	 * TASK: find all "rock" items whose price is less than or equal to the specified price.
	 */
	public Collection<MusicItem> rockItemsAtPrice(double price){

		//create a blank array that we will return
		ArrayList<MusicItem> subArray = new ArrayList();

		//iterate over the entire catalogData array
		for (MusicItem m: catalogData){
			// for each element in the array, check to see if it's title is the same as it's artist
			if (m.getMusicCategory().equals(MusicCategory.ROCK) && m.getPrice() <= price) {

				// if there is a match, add that MusicItem m to the subArray that is returned at hte end of the method
				subArray.add(m);
			}
		}
		// after iterating over the array, return the subArray created at the beginning of the method
		return subArray;
	}


	/**
	 * TASK: how many items of the specified genre do we sell?
	 */
    public int howManySold(MusicCategory genre) {
		//
    	Collection<MusicItem> genreList = findByCategory(genre);

    	return genreList.size();

	}

	/**
	 * TASK: determine average price of our low-cost, extensive catalog of music.
	 */
	public double averagePrice(){

		double sumPrices = 0.0;

		//iterate over the entire catalogData array
		for (MusicItem m: catalogData){
			sumPrices = m.getPrice() + sumPrices;
		}
		// after iterating over the array, return the subArray created at the beginning of the method
		return sumPrices / size();
	}


	/**
	 * TASK: find the cheapest item with the specified genre.
	 */
	public MusicItem cheapestInGenre(MusicCategory category) {
		// current variable pointers and set them both to null
		Double lowestPrice = null;
		MusicItem cheapestMusicItem = null;

		//iterate over the entire catalogData array
		for (MusicItem m: catalogData) {
			// if lowestPrice is null
			if (lowestPrice == null && m.getMusicCategory().equals(category)) {
				// then set the variable pointers to the first item that matches the category
				lowestPrice = m.getPrice();
				cheapestMusicItem = m;
			}
			if (m.getMusicCategory().equals(category) && m.getPrice() < lowestPrice) {
				lowestPrice = m.getPrice();
				cheapestMusicItem = m;
			}
		}

		// at the end of the for loop, return the cheapest item
		return cheapestMusicItem;
	}



	/**
	 * TASK: find the average price of items in the specified genre.
	 */
	public double averagePriceInGenre(MusicCategory category) {
		// current cheap price
		double sumPrice = 0.0;
		int genreSize = 0;

		//iterate over the entire catalogData array
		for (MusicItem m: catalogData) {
			if (m.getMusicCategory().equals(category)) {
				sumPrice = m.getPrice() + sumPrice;
				genreSize++;
			}
		}
		// return the average
		return sumPrice / genreSize;
	}


	/**
	 * TASK: are all items priced at least $10?
	 * This is a yes/no answer.
	 */
	public boolean allLowerThan() {

		//iterate over the entire catalogData array
		for (MusicItem m: catalogData) {

			// if individual MusicItem m is less than $10.00
			if (m.getPrice() < 10.00) {
				// then return false
				return false;
			}
		}
		// otherwise, if no MusicItem is less than $10, return true
		return true;
	}


	/**
	 * TASK: do we sell any items with the specified genre?
	 * Another yes/no answer.
	 */
	public boolean sellAnyOfType(MusicCategory genre) {

		//iterate over the entire catalogData array
		for (MusicItem m: catalogData) {

			// if individual MusicItem m is less than $10.00
			if (m.getMusicCategory().equals(genre)) {
				// then return false
				return false;
			}
		}
		// otherwise, if no MusicItem is less than $10, return true
		return true;
	}

	/**
	 * TASK: determine the titles of all "pop" items, sorted by natural order.
	 * Just the titles!
	 */
	public Collection<String> sortPopTitles() {
		//create a blank array that we will return
		List<String> subArray = Arrays.asList();

		//iterate over the entire catalogData array
		for (MusicItem m: catalogData) {
			// if MusicItem m is of the Pop genre
			if (m.getMusicCategory().equals(MusicCategory.POP)) {
				// then add its title to the String array subArray
				subArray.add(m.getTitle());
			}
		}
		// sort the subArray
		Collections.sort(subArray);

		// return the sorted subArray
		return subArray;
	}


	/**
	 * TASK: find all items released in the 80s whose price is less than or equal to the specified price.
	 */
	public Collection<MusicItem> EightiesMusicAtPrice (double price) {

		//create a blank array that we will return
		ArrayList<MusicItem> subArray = new ArrayList();

		//iterate over the entire catalogData array
		for (MusicItem m: catalogData) {
			// if MusicItem m is less than or equal to price and was releaesd before Jan 1, 1990
			if (m.getPrice() <= price && m.getReleaseDate().before(Date.valueOf("1990-01-01"))) {
				// then add it to the subArray
				subArray.add(m);
			}
		}
		// return the subArray
		return subArray;
	}


	/**
	 * TASK: return a map whose keys are all the genres (categories), and each key's associated value
	 * is a collection of items in that genre.  If there is a genre that we don't currently
	 * sell, that key's associated value should be an empty collection, not null.
	 */
    public Map<MusicCategory, Collection<MusicItem>> genres() {

		//create a blank Map that we will store our sorted results
		Map<MusicCategory, Collection<MusicItem>> returnMap = new HashMap<MusicCategory, Collection<MusicItem>>();

		// iterate over the types of Musical genres, creating an empty collection for each music genre
		for (MusicCategory m : MusicCategory.values()){
			returnMap.put(m, new ArrayList<>());
		}

		//iterate over the entire catalogData array
		for (MusicItem m: catalogData) {
			    // call up the current value (array) associated with the key of the current MusicItem (genre)
				Collection<MusicItem> oldValue = returnMap.get(m.getMusicCategory());

				// modify that variable by passing in the object of the current MusicItem
				oldValue.add(m);

				// now replace the oldValue with the updated one with the current item
				returnMap.replace(m.getMusicCategory(), oldValue);
		}

		// return the map
		return returnMap;
	}



	@Override
	public String toString() {
		return getClass().getSimpleName() + ": " + catalogData;
	}	
}