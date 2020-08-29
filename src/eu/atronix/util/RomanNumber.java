package eu.atronix.util;

import java.util.Arrays;
import java.util.List;

/**
 * Provides some functions for RomanNumbers
 * <br>such as converting to and from int
 * @author Atronix
 * @version 1.0
 */
public class RomanNumber {
	private int iValue = 0; //value of instance of Object
	private String romanValue = ""; //value of instance of Object as roman
	
	//values of roman digits
	private static int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
	private static List<Integer> values2 = Arrays.asList(1000,500,100,50,10,5,1);
	//roman digits
    private static List<String> romanLiterals = Arrays.asList("M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I");
    private static List<String> romanDigits = Arrays.asList("M","D","C","L","X","V","I");
    
    /**
     * Converts a number to a roman digit
     * @author Atronix
     * @param num int - a number which should get converted to Roman number
     * @return String - Roman Number
     */
    public static String convertToRoman(int num) {
    	StringBuilder roman = new StringBuilder(); //roman is result-container for roman digits
    	
    	//as often as the lenth of values array
	    for(int i = 0; i < values.length; i++) {
	    	//as long as the num is greater or same as the i of values
	        while(num >= values[i]) {
	            num -= values[i]; //subtracts used amount
	            roman.append(romanLiterals.get(i)); //appends converted amount to roman
	        }
	    }
		return roman.toString(); //returns the roman result as String
    }
    
    
    
    
    
    /**
     * Converts a number to a roman-digit string
     * @author Atronix
     * @param num Integer - a number which should get converted to Roman number
     * @return String - Roman Number
     */
    public static String convertToRoman(Integer num) {
    	StringBuilder roman = new StringBuilder(); //roman is result-container for roman digits
    	
    	//as often as the lenth of values array
	    for(int i = 0; i < values.length; i++) {
	    	//as long as the num is greater or same as the i of values
	        while(num >= values[i]) {
	            num -= values[i]; //subtracts used amount
	            roman.append(romanLiterals.get(i)); //appends converted amount to roman
	        }
	    }
		return roman.toString(); //returns the roman result as String
    }
    
    
    
    
    
    /**
     * Converts a roman-digit string to an int
     * @author Atronix
     * @param roman String - the string which contains roman digits
     * @return Int - the value of the roman 
     */
	public static int convertToInt(String roman) {
    	int value = 0; //value is the finish value of the roman string it begins at 0
    	StringBuilder safeRoman = new StringBuilder(); //safeRoman is a container for checking the roman on faults
    	
    	//as often as the amount of chars in roman
    	for(int i = 0; i < roman.length(); i++) {
    		String s = String.valueOf(roman.charAt(i)); //s is a container for an single char, cause we have an String List we need a string
    		
    		/* if the list of roman digits contains the given character
    		 * checks that to be sure its a known roman digit
    		 */
    		if(romanLiterals.contains(s)) {
    			safeRoman.append(s); //given character will be appended to the safeRoman
    		} else {
    			System.out.println("[RomanNumber.convertToInt()] Invalid Roman"); //Errormessage
    			return 0; //returns no value
    		}
    	}
    	
    	String safedRoman = safeRoman.toString(); //safedRoman is the finished safeRoman
		int cArrL = safedRoman.length(); //cArrL is the amount of chars in safedRoman
    	
		//as often as the amount of chars in safedRoman
    	for(int j = 0; j < cArrL; j++) {
    		int indexJ; //indexJ is the index of the given character in the romandDigits list 
    		int indexJp; //indexJp is the index given character +1 in the romandDigits list
    		
    		/* if the current turn + 2 is greater than the length of safedRoman
    		 * must be + cause the length is already + 1 than the highest index
    		 */
    		if(j + 2 > cArrL) {
    			char c = safedRoman.charAt(j); //c is the given char
    			indexJ = romanDigits.indexOf(String.valueOf(c)); //initializes indexJ
    			indexJp = 9999; //initializes indexJp
    		} else {
    			char c = safedRoman.charAt(j); //c is the given char
    			char cp = safedRoman.charAt(j + 1); //cp is the given char +1
    			indexJ = romanDigits.indexOf(String.valueOf(c)); //initializes indexJ
    			indexJp = romanDigits.indexOf(String.valueOf(cp)); //initializes indexJp
    		}
    		
    		//if the indexJ ist greater than the indexJp
			if(indexJ > indexJp) {
				value -= values2.get(indexJ); //subtracts the value of the given char from current value
			} else {
    			value += values2.get(indexJ); //adds the value of the given char to current value
			}
		}
		return value;
    }
	
	
	
	
	/**
	 * Constructs a RomanNumber Object with given value
	 * @type Constructor
	 * @author Atronix
	 * @param iValue int - the value the RomanNumber should contain
	 */
	public RomanNumber(int iValue) {
		this.romanValue = convertToRoman(iValue);
		this.iValue = iValue;
	}
	
	/**
	 * Constructs a RomanNumber Object with given roman value
	 * @type Constructor
	 * @author Atronix
	 * @param romanValue String - the value the RomanNumber should contain as roman
	 */
	public RomanNumber(String romanValue) {
		this.romanValue = romanValue;
		this.iValue = convertToInt(romanValue);
	}
	
	/**
	 * Constructs a RomanNumber Object with standard value 0
	 * @type Constructor
	 * @author Atronix
	 */
	public RomanNumber() {
		this(0);
	}
	
	
	
	
	/**
	 * Sets the value of this object as decimal int
	 * @author Atronix
	 * @param iValue int - the value this object should contain
	 */
	public void setValue(int iValue) {
		this.iValue = iValue;
		this.romanValue = convertToRoman(iValue);
	}
	
	
	
	
	/**
	 * Gets the value of this object as int
	 * @author Atronix
	 * @return int - value this object contains
	 */
	public int getValue() {
		return this.iValue;
	}
	
	
	
	
	/**
	 * Sets the roman-value of this object as String
	 * @author Atronix
	 * @param romanValue String - the value this object should contain as roman
	 */
	public void setRoman(String romanValue) {
		this.romanValue = romanValue;
		this.iValue = convertToInt(romanValue);
	}
	
	
	
	/**
	 * Gets the roman-value of this object as String
	 * @author Atronix
	 */
	public String getRoman() {
		return this.romanValue;
	}
}
