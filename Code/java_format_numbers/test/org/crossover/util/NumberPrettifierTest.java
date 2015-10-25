package org.crossover.util;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.Locale;


/**
* JUnit test class
*
* This class contains all the test cases developed for NumberPrettifier
* This test are included in the <pre>build.xml</pre> file, so will be 
* executed each time the project is compiled.
*
* @author Carlos Carrascal Sanchez
*
*/
public class NumberPrettifierTest {

	/**
	* Check output values supplied as examples 
	*/
	@Test
	public void exampleEntriesShouldReturnAsExpected() {

	    NumberPrettifier tester = new NumberPrettifier();

	    // assert statements
	    assertEquals("input: 0 should output: 0", "0", tester.format(0));
	    assertEquals("input: 1000000 should output: 1M", "1M", tester.format(1000000));
	    assertEquals("input: 2500000.34 should output: 2.5M", "2.5M", tester.format(2500000.34));
	    assertEquals("input: 532 should output: 532", "532", tester.format(532));
	    assertEquals("input: 1123456789 should output: 1.1B", "1.1B", tester.format(1123456789));
	    assertEquals("input: 23000000000 should output: 23B", "23B", tester.format(23000000000d));

	}

	/**
	* Check output values supplied as examples in negative values
	*/
	@Test
	public void exampleEntriesWithNegativeValuesShouldReturnAsExpected() {

	    NumberPrettifier tester = new NumberPrettifier();

	    // assert statements
	    assertEquals("input: -1000000 should output: -1M", "-1M", tester.format(-1000000));
	    assertEquals("input: -2500000.34 should output: -2.5M", "-2.5M", tester.format(-2500000.34));
	    assertEquals("input: -532 should output: -532", "-532", tester.format(-532));
	    assertEquals("input: -1123456789 should output: -1.1B", "-1.1B", tester.format(-1123456789));
	    assertEquals("input: 23000000000 should output: 23B", "23B", tester.format(23000000000d));

	}

	/**
	* Check output values supplied as examples in Spanish locale. 
	* Decimal character is expected to be "," instead of "."
	*/
	@Test
	public void exampleEntriesInLocaleSpanishShouldReturnAsExpected() {

	    // Contructed with another locale
	    NumberPrettifier tester = new NumberPrettifier(new Locale("es", "ES"));

	    // assert statements
	    assertEquals("input: 1000000 should output: 1M", "1M", tester.format(1000000));
	    assertEquals("input: 2500000.34 should output: 2,5M", "2,5M", tester.format(2500000.34));
	    assertEquals("input: 532 should output: 532", "532", tester.format(532));
	    assertEquals("input: 1123456789 should output: 1,1B", "1,1B", tester.format(1123456789));
	    assertEquals("input: 23000000000 should output: 23B", "23B", tester.format(23000000000d));

	}

	/**
	* Check output values supplied as examples when a wrong locale is supplied
	* Results should be the same as using Locale.US (default).
	* No errors should be produced.
	*/
	@Test
	public void exampleEntriesInWrongLocaleShouldReturnAsExpected() {

	    // Contructed with wrong locale
	    NumberPrettifier tester = new NumberPrettifier(new Locale("XX", "ZZ"));

	    // assert statements
	    assertEquals("input: 1000000 should output: 1M", "1M", tester.format(1000000));
	    assertEquals("input: 2500000.34 should output: 2.5M", "2.5M", tester.format(2500000.34));
	    assertEquals("input: 532 should output: 532", "532", tester.format(532));
	    assertEquals("input: 1123456789 should output: 1.1B", "1.1B", tester.format(1123456789));
	    assertEquals("input: 23000000000 should output: 23B", "23B", tester.format(23000000000d));

	}

	/**
	* Check output values for wrong input values.
	* Expected results are blank strings.
	* No errors should be produced.
	*/
	@Test
	public void wrongValuesShouldReturnAsExpected() {

	    NumberPrettifier tester = new NumberPrettifier();

	    // assert statements
	    assertEquals("input: ZADSADSAD should output: ", "", tester.format("ZADSADSAD"));

	}
}


