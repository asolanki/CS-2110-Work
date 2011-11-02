import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner myKeyboard=new Scanner(System.in);
		System.out.println("Enter the name of file");
		String filename=myKeyboard.nextLine();
		
		
		TweetApp twitter=new TweetApp();
		
		//store a collection of tweets, getting them from a file or input source
		twitter.loadTweets(filename);
		
		
		
		//twitter.tweetsByAuthor().report();
			//print a list of tweets grouped by author, with groups sorted by author
	
		
		//twitter.tweetsByHashTag().report();
			//print a list of tweets grouped by hashtag, with groups sorted by hashtag
		
		
		
		
		//twitter.topHash();
			//print a list of top 10 hashtags, highest frequency
		
		
		
			
	//DOES CASE MATTER?  If so, we need to change the population of wordfreq and perhaps other sets
		//twitter.mostFreq();
			//print a list of 10 most frequent words
		//twitter.wordFreq.subMap(twitter.wordFreq.firstKey(), twitter.wordFreq.);
		
		//Show two similar tweets
		
		
		
	}
	
	private void mostFreq() {
		
		Set<String> words = wordFreq.keySet();
		ArrayList<StringCount> sorter = new ArrayList<StringCount>();
		for (String word : words) {
			int freq = wordFreq.get(word);
			StringCount sc = new StringCount(word, freq);
			sorter.add(sc);
		}
		
		
		Collections.sort(sorter, compare);
		String[] result = new String[10];
		for (int i = 0; i<11; i++) {
			System.out.println(sorter.get(i).getWord());
		}
		
//		Set<String> keys = TMap.keySet();
//		List<StringCount> sorter = new ArrayList<StringCount>();
//		for (String key : keys) {
//			List<Tweet> tList = TMap.get(key);
//			int size = tList.size();
//			StringCount sc = new StringCount(key, size, tList);
//			sorter.add(sc);
//			}
//		Collections.sort(sorter, compare);
//			List<String> result = new ArrayList<String>();
//			for (StringCount sc : sorter) {
//				result.add(sc.getWord());
//		}		
//		return result;
		
//		
//		for (int j = 0; j < i; j++) {
//			System.out.println(wordFreq.subMap(wordFreq.firstKey(), wordFreq.)
//		}
//		wordFreq.
//		Iterator<String> iter = wordFreq.descendingKeySet().iterator();
//		int i = 11;
//	
//		
//		
//		for (int j = 0; j < i; j++) {
//			System.out.println(iter.next());
//		}
	}
	
	public final Comparator<StringCount> compare = new Comparator<StringCount>() {
		public int compare(StringCount s1, StringCount s2) {
		return s2.getCount() - s1.getCount();		
		}
		};
	
	private void topHash() {
		ArrayList<String> hashFreq = (ArrayList<String>) this.tweetsByHashTag().getKeysByFrequency();
		int i = 11;
		int size = hashFreq.size();
		if (size < 10) {
			i = size;
		}
		
		for (int j = 0; j < i; j++) {
			System.out.println(hashFreq.get(j));
		}
	}

	public boolean loadTweets(String fileName) {
		File sfile = new File(fileName);
		// call the scanner one
		Scanner tweetdata;
		try {
			tweetdata = new Scanner(sfile);
			return loadTweets(tweetdata);
		} catch (FileNotFoundException e) {
			return false;
		}
	}

	public boolean loadTweets(Scanner scnr) {

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

			for (String s : words) {
				if (s.charAt(0) == '#') {
					byHashtag.addTweet(s, t0);
				}

			}

			int value = 0;
			//get the top ten most freqent words
			//not sure if this works
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
		//should this be true?  should we be returning things elsewhere?
		return false;
	}

	public TweetStore tweetsByAuthor() {
		return byAuthor;
		
	}

	public TweetStore tweetsByHashTag() {
		return byHashtag;
	}
	
	//this is supposed to help sort the words? Andreea had something like it
/*
	public List<String> getTopWordFreq() {

		List<String> listWords = new ArrayList<String>(wordFreq.keySet());

		Collections.sort(listWords, new Comparator<String>() {
			public int compare(String s1, String s2) {
				return ((String) s1).length() - ((String) s2).length();
			}
		});

		return listWords;

	}*/
}
