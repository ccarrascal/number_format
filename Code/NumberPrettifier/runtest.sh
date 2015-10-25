#Test are automatically executed on build, but this script will execute them on demand

java -cp bin:bin/tests:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar JunitTestSuiteRunner

