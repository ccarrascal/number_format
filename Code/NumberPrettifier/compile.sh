# Compilation should be done using "ant", but this script will compile 
# only the main class

mkdir -p bin
javac src/org/crossover/util/NumberPrettifier.java  -d bin
javac -cp bin src/ExampleRunner.java  -d bin

