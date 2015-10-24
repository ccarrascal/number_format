package org.crossover.util;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.Locale;


public class NumberPrettifierTest {

	@Test
	public void exampleEntriesShouldReturnAsExpected() {

	    // MyClass is tested
	    NumberPrettifier tester = new NumberPrettifier();

	    // assert statements
	    assertEquals("input: 1000000 should output: 1M", "1M", tester.format(1000000));
	    assertEquals("input: 2500000.34 should output: 2.5M", "2.5M", tester.format(2500000.34));
	    assertEquals("input: 532 should output: 532", "532", tester.format(532));
	    assertEquals("input: 1123456789 should output: 1.1B", "1.1B", tester.format(1123456789));

	}

	@Test
	public void exampleEntriesInLocaleSpanishShouldReturnAsExpected() {

	    // MyClass is tested
	    NumberPrettifier tester = new NumberPrettifier(new Locale("es", "ES"));

	    // assert statements
	    assertEquals("input: 1000000 should output: 1M", "1M", tester.format(1000000));
	    assertEquals("input: 2500000.34 should output: 2,5M", "2,5M", tester.format(2500000.34));
	    assertEquals("input: 532 should output: 532", "532", tester.format(532));
	    assertEquals("input: 1123456789 should output: 1,1B", "1,1B", tester.format(1123456789));

	}



}


