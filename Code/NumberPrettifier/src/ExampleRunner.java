
import org.crossover.util.NumberPrettifier;

/**
* 
* @author Carlos
*/
public class ExampleRunner {

	/**
	* Static main method to te able to excute this class from the command line.
	*
	* This method expects a number parameter as input for the format() function.
	* 
	* Anyway a number of examples will be executed to demostrate all functionality
	* of NumberPrettifier class.
	*
	* Example (run from the base dir, where the file build.xml is located):
	* 
	* <pre>java -cp bin ExampleRunner 250000</pre>
	*
	*/
	public static void main(String[] args) {


		NumberPrettifier prettifier = new NumberPrettifier();

		if (args.length > 0) {
			System.out.println("Input [" + args[0] + "] - Result [" + prettifier.format(args[0]) +"]");
		} else {
			System.out.println("Input [none] - A number should be passed as a parameter.");
		}

		// Run some examples

		System.out.println(new String());
		System.out.println("Formatting [0] - Result [" + prettifier.format(0) + "]");
		System.out.println("Formatting [1000000] - Result [" + prettifier.format(1000000) + "]");
		System.out.println("Formatting [2500000.34] - Result [" + prettifier.format(2500000.34) + "]");
		System.out.println("Formatting [532] - Result [" + prettifier.format(532) + "]");
		System.out.println("Formatting [1123456789] - Result [" + prettifier.format(1123456789) + "]");
		System.out.println("Formatting [23000000000] - Result [" + prettifier.format(23000000000d) + "]");
		System.out.println("Formatting [31900000.0342] - Result [" + prettifier.format(31900000.0342d) + "]");


		// Example of static calling
		System.out.println(new String());
		System.out.println("Static call: NumberPrettifier.formatDouble(8800000d)");
		System.out.println("Formatting [8800000] - Result [" + NumberPrettifier.formatDouble(8800000d) + "]");


		System.out.println(new String());
		System.out.println("Static call: NumberPrettifier.formatFloat(8800000f)");
		System.out.println("Formatting [8800000] - Result [" + NumberPrettifier.formatFloat(8800000f) + "]");

		System.out.println(new String());
		System.out.println("Static call: NumberPrettifier.formatInt(8800000)");
		System.out.println("Formatting [8800000] - Result [" + NumberPrettifier.formatInt(8800000) + "]");

		return;
	}	
} 
