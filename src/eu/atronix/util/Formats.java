package eu.atronix.util;

/**
 * Provides some Formatting functions
 * <br>such as formatting to economic Strings
 * @author Atronix
 * @version 1.0
 *
 */
public class Formats {
	/*
	 * IDEAS:
	 * set number of when to set point, dividing char/string via parameter 
	 */
	
	
	
	
	/**
	 * @author Atronix
	 * @param number double - the number that should be converted to an economic number
	 * @return String - the economic number
	 */
	public static String toEconomicString(double number) {
		number = number * 100;
		number = Math.floor(number) / 100;
		System.out.println();
		String strNumber = String.valueOf(number);
		String[] arrInt = strNumber.split("[.]", 2);
		StringBuilder strArr0 = new StringBuilder();
		
		if(arrInt[0].length() > 3) {
			for(int i = 3; i < arrInt[0].length(); i+=3) {
				String extract = arrInt[0].subSequence(arrInt[0].length() - i, arrInt[0].length() - i + 3).toString();
				strArr0.insert(0, '.' + extract);
			}
		} else {
			strArr0.insert(0, arrInt[0].toString());
		}
		
		if(arrInt[1].length() < 2) {
			arrInt[1] = arrInt[1] + "0";
		}
		
		String strFirst = arrInt[0].substring(0, (arrInt[0].length() % 3 == 0)? 3 : (arrInt[0].length() % 3));
		String strSecond = strArr0.toString();
		
		return strFirst + strSecond + ',' + arrInt[1];
	}
}
