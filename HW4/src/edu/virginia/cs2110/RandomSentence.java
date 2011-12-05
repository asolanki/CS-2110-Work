package edu.virginia.cs2110;

/**Brittany Fuller- brf5hc 
 * Adarsh Solanki- as5nr
 * Homework 4: Random Sentence Generator
 */

import java.util.ArrayList;
import java.util.Scanner;

public class RandomSentence {

	private static Grammar g;

	public RandomSentence(String s) {
		//for JUnit test for assignment
		if (s.length() > 0) {
			g = new Grammar(s);
			g.loadGrammar(s);
			generateSentence(1);
		}
		else {init();}
	}
	
	//written by Brittany
	private void init() {
		System.out.println("Welcome to Random Sentence Generator");
		boolean b = true;
		while (b == true) {
			Scanner myKeyboard = new Scanner(System.in);
			System.out.println("\nGrammars include:\n 1: Poem\n 2: Insult\n "
							+ "3: Extension Request\n 4: CS Assignment Handout\n 5: College "
							+ "Rejection Letter\n 6: Cool Story Bro\n 7: CS Nightmare\n 8: "
							+ "Dear John Letter\n 9: Haiku\n 10: How They Met Story\n 11: "
							+ "Star Trek Episode\n");
			System.out.println("Enter the number of the Grammar you wish to use.");
			System.out.println("Enter  0 to repeat or 12 to exit");

			try {
				int counter = myKeyboard.nextInt();
				processInput(counter);
				generateSentence(5);
				
			} catch (Exception e) {System.out.println("The number you entered was not valid");}
		}
	}

	//written by Adarsh
	public static void processInput(int counter){
		if (counter == 1) {
			g = new Grammar("Poem.g");
			g.loadGrammar("Poem.g");
		}
		if (counter == 2) {
			g = new Grammar("Insult.g");
			g.loadGrammar("Insult.g");
		}
		if (counter == 3) {
			g = new Grammar("Extension-request.g");
			g.loadGrammar("Extension-request.g");
		}
		if (counter == 4) {
			g = new Grammar("CS-assignment-handout.g");
			g.loadGrammar("CS-assignment-handout.g");
		}
		if (counter == 5) {
			g = new Grammar("College-rejection-letter.g");
			g.loadGrammar("College-rejection-letter.g");
		}
		if (counter == 6) {
			g = new Grammar("Cool-story-bro.g");
			g.loadGrammar("Cool-story-bro.g");
		}
		if (counter == 7) {
			g = new Grammar("CS-nightmare.g");
			g.loadGrammar("CS-nightmare.g");
		}
		if (counter == 8) {
			g = new Grammar("Dear-john-letter.g");
			g.loadGrammar("Dear-john-letter.g");
		}
		if (counter == 9) {
			g = new Grammar("Haiku.g");
			g.loadGrammar("Haiku.g");
		}
		if (counter == 10) {
			g = new Grammar("How-they-met-story.g");
			g.loadGrammar("How-they-met-story.g");
		}
		if (counter == 11) {
			g = new Grammar("Star-Trek-episode.g");
			g.loadGrammar("Star-Trek-episode.g");
		}
		if (counter == 12) {
			System.out.println("You have successfully exited the application");
			System.exit(1);
		}
		if (counter > 12) {
			System.out.println("The number you entered was not valid");
		}
		
	}
	
	//written by Adarsh
	public static void generateSentence(int num) {
		System.out.println("");
		for (int i = 0; i < num; i++) {
			nonTermProcess("start");
			System.out.println("");
		}
	}

	/*
	 * This is the method that is recursively called on nonterminals. 
	 * It chooses one random production from the map gParts
	 */
	
	//written by Adarsh
	public static void nonTermProcess(String s) {
		ArrayList<String[]> root = g.getGParts().get(s);
		int choice = (int) (Math.random() * (root.size()));
		process(root.get(choice));
	}

	/*
	 * Based on the production string[] chosen, this method begins to generate
	 * the text. Any nonterminals recursively call nonTermProcess() Any other
	 * words are printed to console
	 */
	
	//written by Adarsh
	public static void process(String[] words) {
		for (String s : words) {
			if (s.charAt(0) == '<') {
				s = s.substring(1, s.indexOf('>'));
				nonTermProcess(s);
			} else {System.out.print(s + " ");}
		}
	}

	public static void setG(Grammar g) {
		RandomSentence.g = g;
	}
}
