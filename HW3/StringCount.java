/*
 * /**
	 * Brittany Fuller- brf5hc 
	 * Adarsh Solanki- as5nr
	 * Homework 3: Tweet Tweet
	 * Lab Section: 101
	 * 
 */

package edu.virginia.cs2110;
import java.util.List;


public class StringCount implements Comparable<StringCount> {

	/**
	 * @param args
	 */
	private String word;
	private int wordCounter;
	private List<Tweet> tweetList;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public StringCount(String w, int wC, List<Tweet> tL){
		word=w;
		wordCounter=wC;
		tweetList=tL;
	}
	
	public StringCount(String w, int wC){
		word=w;
		wordCounter=wC;
		this.tweetList=null;
	}
	
	@Override
	public int compareTo(StringCount o) {		
		return this.wordCounter-o.wordCounter;
	}
	
	public int getCount(){
		return wordCounter;
		}
	
	public String getWord(){
		return word;
		}

}
