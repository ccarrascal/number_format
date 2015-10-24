package org.crossover.util;

import java.text.DecimalFormat;
import java.util.Hashtable;
import java.util.Enumeration;
import java.util.Locale;
import java.text.DecimalFormatSymbols;

/**
* Prettifier class
*
*/
public class NumberPrettifier {

	private Hashtable<String, Double> supportedFormats;
	private Locale locale;

	public NumberPrettifier() {
		initializeFormats();
		locale = Locale.US;
	}

	public NumberPrettifier(Locale locale) {
		initializeFormats();
		this.locale = locale;
	}


	private void initializeFormats() {
		supportedFormats = new Hashtable <String, Double>();
		supportedFormats.put("T", 1000000000000d);
		supportedFormats.put("B", 1000000000d);
		supportedFormats.put("M", 1000000d);
	}

	public static void main(String[] args) {

		int iValue = 0;
		NumberPrettifier prettifier = new NumberPrettifier();

		if (args.length > 0) {
			System.out.println(prettifier.format(args[0]));
		} else {
			System.out.println("A number must be passed as a paramter.");

		}


		return;
	}


	public String format(String input) {

		return this.format(new Double(input));
	}

	public String format(int input) {

		return this.format(new Double(input));
	}

	public String format(Float input) {

		return this.format(new Float(input));
	}




	public String format(Double input) {

		String result = String.valueOf(input.intValue());

		Enumeration<String> keys = supportedFormats.keys();
		while (keys.hasMoreElements()) {
			String letter = keys.nextElement();
			Double ceiling = supportedFormats.get(letter);

			if ( input >= ceiling || input <= (-1 * ceiling) ) {
				result = setFormat(input, letter, ceiling);
			}

		}

		return result;
	}

	private String setFormat(Double input, String letter, Double ceiling) {

		input = input / ceiling;

		return finalFormat(input, letter);
	}


	private String finalFormat(Double number, String letter) {
	
		String result = new String();

		if ( number % 1 == 0 ) 
			result = String.valueOf(number.intValue());
		else {
			DecimalFormat df = new DecimalFormat("#.#", new DecimalFormatSymbols(this.locale));
			result = df.format(number);
		}

		result = result + letter;

		return result;
	}
}


