
# Crossover Technical Trial 
#
# Carlos Carrascal Sanchez
# 10/24/2015


# Task to perform


	Write tested code (any language) that accepts a numeric type and returns a truncated, "prettified" string version. The prettified version should include one number after the decimal when the truncated number is not an integer. It should prettify numbers greater than 6 digits and support millions, billions and trillions. You should use short scale numbers to output the prettified number.

	Examples:

	input: 1000000 output: 1M

	input: 2500000.34 output: 2.5M

	input: 532 output: 532

	input: 1123456789 output: 1.1B

	Please provide with your code any supporting information once you are done. Include a brief overview describing your approach, assumptions, design decisions, requirements questions, or anything you think needs clarification. Be prepared to discuss in more detail and iterate on the problem.



# How to install

	Windows Systems

		Download and install Java JDK 7 (at least versión 7)

		http://www.oracle.com/technetwork/es/java/javase/downloads/jdk7-downloads-1880260.html (Oracle version)

		Download and install Apache Ant 

		http://ant.apache.org/manual/install.html

		Download and install ConEmu  (Optional but recommended)

		http://sourceforge.net/projects/conemu/


	GNU / Linux system (Debian based), as root

		apt-get install ant openjdk-7-jdk



	Extract ZIP in desired folder. ZIP base folder will be refered to as $BASE
	Use a terminal and navigate to the $BASE folder using cd 

		cd $BASE


# How to configure

	

	Compile:

		Use Ant to compile sources, run JUnit tests, and create Javadoc entries.
		Go to the base code folder, where the file build.xml is located.

			cd Code/NumberPrettifier
			ant

		The Ant build file will do:
			* Clean binaries
			* Compile binaries
			* Execute JUnit tests
			* Generate Javadoc docuementation

		If everything its correct you should see some information and the message:

			BUILD SUCCESSFUL

		Also, an alternative method without Ant is provided to compile:

			sh ./compile.sh

		NOTE: This method will not run JUnit tests

	Run:
		
		A simple ExampleRunner class has been included. This class has a main method
		that can be called from command line, and will show some use examples.
		A parameter can be passed from the command line to prettify it.


			java -cp bin ExampleRunner <number>

		There is also a small bash script that can be used to run the project:

			sh ./run.sh




# Assumptions

Development and testing where made using a Debian GNU / Linux machine.
Instalation and running instructions are provided for Windows systems, 
but is recomended to use a Debian box or derivatives.

The code is using standar rounding mode HALF_EVEN to present the results.




# Issues

Regional settings in the system can affect the results, because of the use
of different characters to represent the decimal separator.

This has been taken into account forcing the use of a US locale, and allowing
the use of a custom locale by a dedicated Class contructor.


