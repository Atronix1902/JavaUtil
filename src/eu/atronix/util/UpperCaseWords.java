package eu.atronix.util;

import java.util.Arrays;
import java.util.List;

public class UpperCaseWords{
	
	//List of words to ignore
	private static List<String> ignore = Arrays.asList(
			/*"in",
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
			"were"*/
	);
	
	/**
	 * Adds words to Ignore list
	 * @author Atronix
	 * @param words String Array - word which should be added to ignore-list
	 * @return void
	 */
	public static void addIgnore(String[] words) {
		//for every word in words
		for (String word : words) {
			//adds word to ignore
			ignore.add(word);
		}
	}
	
	/**
	 * Sets first letter of every word to uppercase 
	 * <br>example:
	 * <ul>
	 * <li>This cat is sweet and will get more fish!</li>
	 * <li>becomes</li>
	 * <li>This Cat Is Sweet And will Get More Fish!</li>
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

		//trims the given string and set it to lowercase
		String str = sentence.trim().toLowerCase();

		//split in words
		String[] words = str.split("\\s");

		//container for result
		StringBuilder result = new StringBuilder();

		//for every word of original string
		for (String word : words) {
			//ignores given words
			if(ignore.contains(word)) {
				result.append(word);
			} else {
				//sets first char of every word to uppercase and appends it to result
				result.append(Character.toUpperCase(word.charAt(0)));

				//append remaining chars if existing
				if (word.length() > 1) {
					result.append(word.substring(1));
				}
			}

			//append space after word
			result.append(' ');
		}

		//removes the last unused space 
		if (result.length() > 0) {
			result.setLength(result.length() - 1);
		}

		//return result as String
		return result.toString();
	}
}
