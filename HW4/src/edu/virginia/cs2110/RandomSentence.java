package edu.virginia.cs2110;

import java.util.ArrayList;

public class RandomSentence {

	private static Grammar g;

	public static void main(String[] args) {
		g = new Grammar("College-rejection-letter.g");
		g.loadGrammar("College-rejection-letter.g");
		nonTermProcess("start"); // begins the process
	}

	/*
	 * This is the method that is recursively called. It chooses one random
	 * production from the map "gParts"
	 */
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
	public static void process(String[] words) {
		for (String s : words) {
			if (s.charAt(0) == '<') {
				s = s.substring(1, s.indexOf('>'));
				nonTermProcess(s);
			} else {
				System.out.print(s + " ");
			}
		}
	}

}
