package eu.atronix.util;

import java.util.Arrays;
import java.util.List;

/**
 * Provides some functions for Words
 * <br>such as setting the first letter of every word to uppercase
 * @author Atronix
 * @version 1.0
 *
 */
public class UpperCaseWords{
	
	private static List<String> ignore = Arrays.asList( //List of words to ignore
			/*
			"in",
			"am",
			"an",
			"der",
			"vor",
			"vorm",
			"of",
			"from",
			"with",
			"on",
			"the",
			"front",
			"and",
			"is",
			"are",
			"was",
			"be",
			"am",
			"were"
			*/
	);
	
	
	
	
	
	/**
	 * Returns the current ignores as List
	 * @author Atronix
	 * @return String-List
	 */
	public static List<String> getIgnore() {
		return ignore;
	}
	
	
	
	
	
	/**
	 * Adds words to Ignore list
	 * @author Atronix
	 * @param words String Array - word/s that should be added to ignore-list
	 * @return void
	 */
	public static void addIgnore(String[] words) {
		//for every word in words
		for (String word : words) {
			ignore.add(word); //adds word to ignore
		}
	}
	
	
	
	
	/**
	 * Removes words from Ignore list
	 * @author Atronix
	 * @param words String Array - word/s that should be removed from ignore-list
	 * @return void
	 */
	public static void remIgnore(String[] words) {
		//for every word in words
		for (String word : words) {
			ignore.remove(word); //removes word from ignore
		}
	}
	
	
	
	
	
	/**
	 * Sets first letter of every word to uppercase 
	 * <br>example:
	 * <ul>
	 * <li>This cat is sweet and will get more fish!</li>
	 * <li>becomes</li>
	 * <li>This Cat Is Sweet And Will Get More Fish!</li>
	 * </ul>
	 * word exceptions can be added by addIgnore(String[] words)
	 * @author Atronix
	 * @param sentence String - Sentence where to uppercase first letter of every word
	 * @return String - formatted String
	 */
	public static String ucWords(String sentence) {
		//protection for null-strings
		if (sentence == null) {
			return null;
		}

		String str = sentence.trim().toLowerCase(); //trims the given string and set it to lowercase
		String[] words = str.split("\\s"); //split in words
		StringBuilder result = new StringBuilder(); //container for result

		//for every word of original string
		for (String word : words) {
			//ignores given words if its on ignore list
			if(ignore.contains(word)) {
				result.append(word);
			} else {
				result.append(Character.toUpperCase(word.charAt(0))); //sets first char of every word to uppercase and appends it to result

				//append remaining chars if existing
				if (word.length() > 1) {
					result.append(word.substring(1));
				}
			}
			result.append(' '); //append space after word
		}

		//removes the last unused space if the length is greater than 0 
		if (result.length() > 0) {
			result.setLength(result.length() - 1);
		}

		return result.toString(); //return result as String
	}
}
