package org.crossover.util;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Iterator;

import java.util.Locale;
import java.text.DecimalFormatSymbols;

/**
* NumberPrettifier class
*
* Utility class that accepts a numeric type and returns a truncated, "prettified" string version. 
* <p>
* The prettified version will include one number after the decimal when the truncated number is not an integer. 
* Prettifies numbers greater than 6 digits and support millions, billions and trillions. 
* <p>
* Short scale numbers are used to output the prettified number.
* <p>
* Examples:
* <p>
* <pre>
*	input: 1000000 output: 1M
*
*	input: 2500000.34 output: 2.5M
*
*	input: 532 output: 532
*
*	input: 1123456789 output: 1.1B
*</pre>
*
* @author Carlos Carrascal Sanchez, carlos.carrascal@gmail.com
*
*/
public class NumberPrettifier {

	private Map<String, Double> supportedFormats;
	private Locale locale;

	/**
	* Empty constructor.
	*
	* Defaults to US locale, using "." for decimals
	*/
	public NumberPrettifier() {
		initializeFormats();
		locale = Locale.US;
	}

	/**
	* Constructor using Locale class.
	*
	* Using this constructor the character used for decimal separator
	* will be displayed according the Locale used.
	*
	* Example: <pre>NumberPrettifier prettifier = new NumberPrettifier(new Locale("es", "ES"));</pre>
	* 
	* @param locale Locale class to user for output format
	* @see java.util.Locale
	*/
	public NumberPrettifier(Locale locale) {
		initializeFormats();
		this.locale = locale;
	}


	/**
	* Initialize the internal LinkedHashMap with supported formats.
	*
	* To include a new format, add a new line like this:
	* 
	* <pre>supportedFormats.put("X", XXXXXd);</pre>
	*
	* These lines has to be ordered from bigger to smaller numbers.
	*/
	private void initializeFormats() {

		supportedFormats = Collections.synchronizedMap( new LinkedHashMap<String, Double>() );

		supportedFormats.put("T", 1000000000000d);
		supportedFormats.put("B", 1000000000d);
		supportedFormats.put("M", 1000000d);
	}




	/**
	* Format a number into a truncated, "prettified" string version.
	*
	* Negative numbers are allowed and formated in the same way.
	*
	* @param input Number to be formatted.
	* @return The formatted number in String.
	*/
	public String format(Double input) {

		String result;
		try {

			result = String.valueOf(input.intValue());

			// Get list of supported formats from the hashtable
			Iterator i = supportedFormats.keySet().iterator();

			while (i.hasNext()) {
				String letter = (String) i.next();
				Double ceiling = supportedFormats.get(letter);

				// Check the number against the ceiling value and the negative one
				if ( input >= ceiling || input <= (-1 * ceiling) ) {
					result = setFormat(input, letter, ceiling);
					break;
				}

			}

		} catch (Exception e) {
			// In case of error, an empty string is returned
			result = new String();
		}

		return result;
	}


	/**
	* Private funtion to do the actual formatting.
	*
	* This function truncates the number as determined by <pre>ceiling</pre> parameter,
	* and uses a <pre>DecimalFormat</p> class to format the number if the resulting number
	* is not an integer, to represent it only with one decimal.
	*
	* The decimal separator will be "." by default, unless a specific Locale was used in the constructor.
	*
	* @param input Input number to format
	* @param letter Letter code to use in the format
	* @param ceiling Format range to apply
	* @see DecimalFormat
	*/
	private String setFormat(Double input, String letter, Double ceiling) {

		String result = new String();

		// Truncate the number to the desired range, based on ceiling
		input = input / ceiling;

		if ( input % 1 == 0 ) 
			result = String.valueOf(input.intValue());
		else {
			// For non integers, apply a custom format
			DecimalFormat df = new DecimalFormat("#.#", new DecimalFormatSymbols(this.locale));

			// Rounding mode can be adjusted here. 
			//df.setRoundingMode(java.math.RoundingMode.UP);

			result = df.format(input);
		}

		result = result + letter;

		return result;

	}


	/**
	* Helper function to format() using a String.
	*
	* @param input Number to be formatted.
	* @return The formatted number in String.
	* @see #format(Double input)
	*/
	public String format(String input) {

		String result;
		try {
			result = this.format(Double.parseDouble(input));
		} catch (Exception e) {
			result = new String();
		}
		
		return result;
	}


	/**
	* Helper function to format() using a integer value.
	*
	* @param input Number to be formatted.
	* @return The formatted number in String.
	* @see #format(Double input)
	*/
	public String format(int input) {

		String result;
		try {
			result = this.format(new Double(input));	
		} catch (Exception e) {
			result = new String();
		}
		
		return result;
	}


	/**
	* Static method to format a number.
	* 
	* This method does the same as format(Double) but can be called statically.
	*
	* Example:
	*
	* <pre>String number = NumberPrettifier.formatDouble(1000D);</pre>
	*
	* @param input Number to be formatted.
	* @return The formatted number in String.
	* @see #format(Double input)
	*/
	public static String formatDouble(Double input) {
		NumberPrettifier prettifier = new NumberPrettifier();

		return prettifier.format(input);
	}

	/**
	* Static method to format a number.
	* 
	* This method does the same as format(Double) but can be called statically.
	*
	* Example:
	*
	* <pre>String number = NumberPrettifier.formatFloat(1000D);</pre>
	*
	* @param input Number to be formatted.
	* @return The formatted number in String.
	* @see #format(Double input)
	*/
	public static String formatFloat(Float input) {
		NumberPrettifier prettifier = new NumberPrettifier();

		return prettifier.format(input.doubleValue());
	}

	/**
	* Static method to format a number.
	* 
	* This method does the same as format(Double) but can be called statically.
	*
	* Example:
	*
	* <pre>String number = NumberPrettifier.formatInt(1000D);</pre>
	*
	* @param input Number to be formatted.
	* @return The formatted number in String.
	* @see #format(Double input)
	*/
	public static String formatInt(int input) {
		NumberPrettifier prettifier = new NumberPrettifier();

		return prettifier.format(new Double(input));
	}


	/**
	* Public setter for locale
	* 
	* @param locale Locale to be used
	*/
	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	/**
	* Public getter for locale
	*
	* @return Current locale
	*/
	public Locale getLocale() {
		return this.locale;
	}

}


