package edu.virginia.cs2110;

/**Brittany Fuller- brf5hc 
 * Adarsh Solanki- as5nr
 * Homework 4: Random Sentence Generator
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Grammar {

	/**
	 * @param args
	 */

	private TreeMap<String, ArrayList<String[]>> gParts;
	private String gName;
	private String nonterminal;

	//written by Brittany
	public Grammar(String grammar) {
		gName = grammar;
		gParts = new TreeMap<String, ArrayList<String[]>>();
	}

	//written by both Brittany and Adarsh
	public void loadGrammar(String s) {
		boolean inBlock;
		nonterminal = null; // <nonterminals> get recursively processed
		ArrayList<String[]> productions = null; // options when processing a
												// nonterminal
												// each string[] is a possible
												// result
		File filename = new File(s);
		Scanner scnr;
		try {
			scnr = new Scanner(filename);

			while (scnr.hasNext()) {
				String line = scnr.nextLine();

				// begin a {block}
				if (line.trim().equals("{")) { // processing a block
					inBlock = true;
					String line2 = scnr.nextLine();
					if (line2.charAt(0) == '<') {

						// this is the 'name' of the block e.g. <adverb>
						nonterminal = line2.substring(1, line2.indexOf('>'));
						productions = new ArrayList<String[]>();

						while (inBlock) {

							line2 = scnr.nextLine();
							if (line2.trim().equals("}")) { // done with this
								inBlock = false;			// block
								break;
							} else {
								String[] symbols = line2.split("\\s+");
								productions.add(symbols); 
								// symbols = the individual words/nonterms in
								// each production
							}
						}
					}
					gParts.put(nonterminal, productions); // add to
															// datastructure
				}
			}
		} catch (FileNotFoundException e) {}
	}

	/*
	 * This exists for testing reasons only to visualize the parsing of
	 * a grammar file
	 */
	
	//written by Adarsh
	@Override
	public String toString() {
		String result = gName + " grammar: \n";

		Set<String> nonterms = gParts.keySet();
		for (String s : nonterms) {
			result = result + " " + s + ": \n";
			ArrayList<String[]> terms = gParts.get(s);
			int counter = 0;
			for (String[] term : terms) {
				result = result + "  " + ++counter + ": ";
				for (String word : term) {
					result = result + word + " ";
				}
			}
			result += "\n";
		}
		return result;
	}

	public TreeMap<String, ArrayList<String[]>> getGParts() {
		return gParts;
	}
}
