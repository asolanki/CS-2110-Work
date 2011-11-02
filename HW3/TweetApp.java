/*
 * 
 * Brittany Fuller- brf5hc 
 * Adarsh Solanki- as5nr
 * Homework 3: Tweet Tweet
 * Lab Section: 101
 * 
 */

package edu.virginia.cs2110;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class TweetApp {

	/**
	 * @param args
	 */
	private static TweetStore byAuthor = new TweetStore("author");
	private static TweetStore byHashtag = new TweetStore("hashtag");
	TreeMap<String, Integer> wordFreq = new TreeMap<String, Integer>();
	TreeMap<String, Integer> hashFreq = new TreeMap<String, Integer>();
	Scanner myKeyboard = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner myKeyboard = new Scanner(System.in);
		System.out.println("Enter the name of file");
		String filename = myKeyboard.nextLine();

		TweetApp twitter = new TweetApp();

		twitter.loadTweets(filename);

		twitter.tweetsByAuthor().report();
		// print a list of tweets grouped by author, with groups sorted by
		// author

		twitter.tweetsByHashTag().report();
		// print a list of tweets grouped by hashtag, with groups sorted by
		// hashtag

		System.out.println("Most frequent HashTags:");
		
		Map<String, Integer> hashMap = twitter.topHash();
		int i = 0;
		for (Map.Entry<String, Integer> hashEntry : hashMap.entrySet()) {
			i++;
			String key = hashEntry.getKey();
			Integer value = hashEntry.getValue();
			System.out.println("  " + i + ". " + key + " : " + value);

		}
		
		
		
		
		
//		int size = twitter.topHash().size();
//		for (int i = 1; i <= size; i++) {
//			System.out.println("  " + i + ". " + twitter.topHash().get(i - 1));
//			// print a list of top 10 hashtags, highest frequency
//		}

		System.out.println("Most frequently occuring words:");

		Map<String, Integer> freqMap = twitter.mostFreq();
		i = 0;
		for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
			i++;
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println("  " + i + ". " + key + " : " + value);

		}

		//
		// for (int i = 0; i < size; i++)
		// System.out.println("  " + i+1 + ". " + twitter.mostFreq().);
		// print a list of 10 most frequent words

		// twitter.wordFreq.subMap(twitter.wordFreq.firstKey(),
		// twitter.wordFreq.);

		// Show two similar tweets

	}

	private LinkedHashMap<String, Integer> mostFreq() {

		Set<String> words = wordFreq.keySet();
		ArrayList<StringCount> sorter = new ArrayList<StringCount>();
		for (String word : words) {
			int freq = wordFreq.get(word);
			StringCount sc = new StringCount(word, freq);
			sorter.add(sc);
		}

		Collections.sort(sorter, compare);
		LinkedHashMap<String, Integer> result = new LinkedHashMap<String, Integer>();

		// makes sure its only 10 words max displayed
		int size;
		if (sorter.size() < 10) {
			size = sorter.size();
		} else {
			size = 10;
		}

		// populates result Map with words and counts
		for (int i = 0; i < size; i++) {
			result.put(sorter.get(i).getWord(), sorter.get(i).getCount());
			// result.add(i, sorter.get(i).getWord());
		}

		return result;

	}

	private LinkedHashMap<String, Integer> topHash(){
		Set<String> words = hashFreq.keySet();
		ArrayList<StringCount> sorter = new ArrayList<StringCount>();
		for (String word : words) {
			int freq = hashFreq.get(word);
			StringCount sc = new StringCount(word, freq);
			sorter.add(sc);
		}

		Collections.sort(sorter, compare);
		LinkedHashMap<String, Integer> result = new LinkedHashMap<String, Integer>();

		// makes sure its only 10 words max displayed
		int size;
		if (sorter.size() < 10) {
			size = sorter.size();
		} else {
			size = 10;
		}

		// populates result Map with words and counts
		for (int i = 0; i < size; i++) {
			result.put(sorter.get(i).getWord(), sorter.get(i).getCount());
			// result.add(i, sorter.get(i).getWord());
		}

		return result;
	}
	
	
	
//	private ArrayList<String> topHash() {
//		ArrayList<String> hashFreq = (ArrayList<String>) this.tweetsByHashTag()
//				.getKeysByFrequency();
//		ArrayList<String> result = new ArrayList<String>();
//		int i;
//		int size = hashFreq.size();
//		if (size < 10) {
//			i = size;
//		} else {
//			i = 10;
//		}
//		;
//
//		for (int j = 0; j < i; j++) {
//			result.add(j, hashFreq.get(j));
//		}
//
//		return result;
//	}

	public final Comparator<StringCount> compare = new Comparator<StringCount>() {
		public int compare(StringCount s1, StringCount s2) {
			return s2.getCount() - s1.getCount();
		}
	};

	public boolean loadTweets(String fileName) {
		File sfile = new File(fileName);
		// call the scanner one
		Scanner tweetdata;
		try {
			tweetdata = new Scanner(sfile);
			return loadTweets(tweetdata);
		} catch (FileNotFoundException e) {
			System.out.println("No such file, run program again.");
			System.exit(0);
			return false;
		}
	}

	public boolean loadTweets(Scanner scnr) {

		if (!scnr.hasNext()) {return false;}
		
		while (scnr.hasNext()) {
			String author = "";
			String date = "";
			String text = "";
			String line;

			if (author.isEmpty()) {
				author = scnr.nextLine().trim();

			}
			if (date.isEmpty()) {
				date = scnr.nextLine().trim();
			}

			while (scnr.hasNext()) {
				line = scnr.nextLine();
				if (!line.trim().isEmpty()) {
					if (text.isEmpty()) {
						text = line;
					} else {
						text = text + " " + line;
					}
				} else {
					break;
				}
			}

			Tweet t0 = new Tweet(author, date, text);

			ArrayList<String> words = (ArrayList<String>) t0.extractWords();
			
			int value = 0;
			
			
			
			
			//maybe
			for (String s : words) {
				if (s.charAt(0) == '#') {
					s = s.substring(1);
					if (hashFreq.containsKey(s)) {
						value = hashFreq.get(s) + 1;
					} else {
						value = 1;
					}
					hashFreq.put(s, value);
					byHashtag.addTweet(s, t0);		
				}
					
					
					
					
				

			}

			value = 0;
			// get the top ten most freqent words
			// not sure if this works
			for (int i = 0; i < words.size(); i++) {

				if (wordFreq.containsKey(words.get(i))) {
					value = wordFreq.get(words.get(i)) + 1;
				} else {
					value = 1;
				}
				wordFreq.put(words.get(i), value);

			}
			byAuthor.addTweet(author, t0);

		}
		return true;
	}

	public TweetStore tweetsByAuthor() {
		return byAuthor;

	}

	public TweetStore tweetsByHashTag() {

		return byHashtag;
	}

	/*
	 * public List<String> getTopWordFreq() {
	 * 
	 * List<String> listWords = new ArrayList<String>(wordFreq.keySet());
	 * 
	 * Collections.sort(listWords, new Comparator<String>() { public int
	 * compare(String s1, String s2) { return ((String) s1).length() - ((String)
	 * s2).length(); } });
	 * 
	 * return listWords;
	 * 
	 * }
	 */
}
