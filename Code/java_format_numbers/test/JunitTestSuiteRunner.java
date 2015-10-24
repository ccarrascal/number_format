import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import org.crossover.util.NumberPrettifierTestSuite;


public class JunitTestSuiteRunner {

	public static void main(String[] args) {

		Result result = JUnitCore.runClasses(NumberPrettifierTestSuite.class);
		for (Failure fail : result.getFailures()) {
			System.out.println(fail.toString());
		}
		if (result.wasSuccessful()) {
			System.out.println("All tests finished successfully...");
		}
	}
} 
