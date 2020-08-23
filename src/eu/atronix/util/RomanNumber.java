package eu.atronix.util;

import java.util.Arrays;
import java.util.List;

public class RomanNumber {
	//Steps for roman digits
	static int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
	//roman digits
    static String[] romanLiterals = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    static List<String> romanArrayList = Arrays.asList(romanLiterals);
    static List<String> romanDigits = Arrays.asList("M","D","C","L","X","V","I");
    static List<Integer> values2 = Arrays.asList(1000,500,100,50,10,5,1);
    
    /**
     * Converts a number to a roman digit
     * @author Atronix
     * @param num int - a number which should get converted to Roman number
     * @return String - Roman Number
     */
    public static String convertToRoman(int num) {
    	//roman is result-container for roman digits
    	StringBuilder roman = new StringBuilder();
    	
    	//for the whole values array
	    for(int i = 0; i < values.length; i++) {
	    	//as long as the num is greater or same as the i of values
	        while(num >= values[i]) {
	        	//subtracts used amount
	            num -= values[i];
	            //appends converted amount to roman
	            roman.append(romanLiterals[i]);
	        }
	    }
	    //returns the roman result as String
		return roman.toString();
    }
    
    /**
     * Converts a number to a roman digit
     * @author Atronix
     * @param num Integer - a number which should get converted to Roman number
     * @return String - Roman Number
     */
    public static String convertToRoman(Integer num) {
    	//roman is result-container for roman digits
    	StringBuilder roman = new StringBuilder();
    	
    	//for the whole values array
	    for(int i = 0; i < values.length; i++) {
	    	//as long as the num is greater or same as the i of values
	        while(num >= values[i]) {
	        	//subtracts used amount
	            num -= values[i];
	          //appends converted amount to roman
	            roman.append(romanLiterals[i]);
	        }
	    }
	    //returns the roman result as String
		return roman.toString();
    }
    
	public static int convertToInt(String roman) {
    	int value = 0;
    	
    	StringBuilder safeRoman = new StringBuilder();
    	
    	for(int i = 0; i < roman.length(); i++) {
    		String test = String.valueOf(roman.charAt(i));
    		if(romanArrayList.contains(test)) {
    			safeRoman.append(test);
    		} else {
    			return 0;
    		}
    	}
    	
    	String safedRoman = safeRoman.toString();
    	System.out.println(safedRoman);
    	
    	for(int j = 0; j < safedRoman.length(); j++) {
    		int indexJ;
    		int indexJp;
    		int cArrL = safedRoman.length();
    		if(j + 2 > cArrL) {
    			char c = safedRoman.charAt(j);
    			indexJ = romanDigits.indexOf(String.valueOf(c));
    			indexJp = 9999;
    		} else {
    			char c = safedRoman.charAt(j);
    			char cp = safedRoman.charAt(j + 1);
    			indexJ = romanDigits.indexOf(String.valueOf(c));
    			indexJp = romanDigits.indexOf(String.valueOf(cp));
    		}
			if(indexJ > indexJp) {
				value -= values2.get(indexJ);
				safedRoman = safedRoman.replaceFirst(romanDigits.get(indexJ), "");
			} else {
    			value += values2.get(indexJ);
    			safedRoman = safedRoman.replaceFirst(romanDigits.get(indexJ), "");
			}
		}
		return value;
    }
}
