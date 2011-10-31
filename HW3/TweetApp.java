import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;




public class TweetApp {

	/**
	 * @param args
	 */
	private TweetStore byAuthor;
	private TweetStore byHashtag;
	TreeMap<String, Integer> wordFreq;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TweetApp twitter=new TweetApp();
		twitter.start();
	}
	public boolean loadTweets(String fileName){
		File sfile = new File(fileName);
		//call the scanner one
		
		if (sfile.exists()) {
			Scanner songdata;
			try {
				songdata = new Scanner(sfile);
			String author;
			String date;
			String text;
			String line;
			
			
			while (songdata.hasNext()) {
				line = songdata.nextLine();
				author=line;
				line=songdata.nextLine();
				date=line;
				
				//populating all the collections
				//intialize fields of different tweet stores
				
				
			}
			} catch (Exception e) {
				return false;
			}
		} else {
			//System.out.println("Error: File cannot be found.");
			return false;
		}
		return false;

}
	
	public boolean loadTweets(Scanner scnr){
		
		return false;
	}
	public TweetStore tweetsByAuthor(){
		//sort authors
		
		return null;
	}
	public TweetStore tweetsByHashTag(){
		//sort hashtags
		return null;
	}
	private void start(){
		boolean b = true;
		while (b == true) {

			Scanner myKeyboard = new Scanner(System.in);
		System.out.println("Enter the number you wish to execute:\n" +
				"1: Store collection of tweets\n" +
				"2: Print a list of tweets grouped by author\n" +
				"3: Print a list of tweets grouped by hashtag\n" +
				"4: Print a list of top 10 hashtags\n" +
				"5: Print a list of 10 most frequent words found\n" +
				" in tweets with each words frequency and how many\n" +
				" tweets contain each word\n" +
				"6: Show two most similar tweets\n" +
				"7: Exit Application");
		
			String counter = myKeyboard.nextLine();
			
			try {
				int num = Integer.parseInt(counter);
				
				if (num == 1) {
					System.out.println("1: Store collection of tweets");
					
					//load tweets
					System.out.println("Enter the name of the file you wish to load");
					String fname=myKeyboard.nextLine();
					loadTweets(fname);
					
					//store tweets
					
					
					

				} else if (num == 2) {
					System.out.println("2: Print a list of tweets grouped by author");
					//to sort just get key set and put it into a list and call collections.sort
					//have a constructor that takes another constructor
				} else if (num == 3) {
					System.out.println("3: Print a list of tweets grouped by hashtag");

				} else if (num == 4) {
					System.out.println("4: Print a list of top 10 hashtags");
					//tweetstore hash tag, get keys loops over the keys
					//find each hashtag then get the list and the size of the list
					//sort to find the top ten things--(String, int) sort by count

					
				} else if (num == 5) {
					System.out.println("5: Print a list of 10 most frequent words found\n" +
				" in tweets with each words frequency and how many\n" +
				" tweets contain each word");
					//get keys for this within the map you create in loadTweets
					//create a list of somthing with the string int pair
					//make a class to make an object for the (String, int) pair
					//class String count really simple two fields a constructor implement comparable compare by the number
					
					//second part how many tweets contain each word
					//store either a list of tweets or a number of tweets one more variable in other class or just another int value
				} else if (num == 6) {
					System.out.println("6: Show two most similar tweets");

					
				} else if (num == 7) {
					System.out.println("7: Exit the application");
					System.out
							.println("You have successfully quit the application");
					b = false;
					
				} 
							
			} catch (Exception e) {
				System.out
						.println("Invalid Entry: Please enter a number 1-7.\n");
			}
	
			}
		
		}
	

}
