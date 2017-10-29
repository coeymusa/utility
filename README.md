MyLife Digital Project

A library that creates a CSV file populated with random integers on varying line sizes. The size, range, min and max range of the numbers can be altered.

With the ability to read a CSV file of integers, to produce statisics on the contents.

The statistics currently possible to compute are:

• Total number of integers, 
• Mean value of all integers (to three decimal places),
• Highest number of integers in a single line, 
• Most common integer.

To run:

1.In command line in location of JAR file:
java -cp utility-0.0.1-SNAPSHOT.jar com.interview.utility.CSVTool *paramters*

For help using utility run:
java -cp utility-0.0.1-SNAPSHOT.jar com.interview.utility.CSVTool help

To run all statisic methods on a CSV file:
java -cp utility-0.0.1-SNAPSHOT.jar com.interview.utility.CSVTool *pathToCSV* all

Eclipse:
Import maven project and run CVSTool with runtime arguments of *pathToCSV* *command*