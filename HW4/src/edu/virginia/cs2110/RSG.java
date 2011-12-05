package edu.virginia.cs2110;

/**Brittany Fuller- brf5hc 
 * Adarsh Solanki- as5nr
 * Homework 4: Random Sentence Generator
 */


public class RSG {
	static RandomSentence r;
	
	//written by Adarsh
	public static void main(String[] args) {
		r = new RandomSentence("");
	}
	
	//method created for assignment
	public static String generate(String Filename) {
		r = new RandomSentence(Filename);
	}
}
