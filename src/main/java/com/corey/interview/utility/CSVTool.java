package com.corey.interview.utility;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

class CSVTool {

	public static void main(String[] args) throws IOException {
		if (args.length == 1 && args[0].toLowerCase().equals("help")) {
			System.out.println(
					"Commands: \n"
							+"'t' : total number of integers \n"
							+"'m' : mean value of integers \n"
							+"'h' : highest number of integers in a single line \n"
							+"'c' : most common integer \n"
							+"'l' : amount of integers on the longest line \n"
							+"'all' : all statistic commands \n"
							+"\n"
							+"For statistic services pass the location of file and a character");
		} else if (args.length != 2) {
			System.out.println(
					"Please pass in the location of the file as a string and the operation, pass help to find out possible operations");
		} else {
			try {

				List<Integer[]> csvLineIntegers = CSVReader.readCSVReturnLines(args[0]);
				int[] csvIntegers = CSVReader.readCSV(args[0]);

				if (csvIntegers == null || csvIntegers.length == 0) {

					System.out.println("No elements were given");

				} else {
					switch (args[1]) {					
					case "t":
						System.out.println("Total of all integers: " + CSVUtil.total(csvIntegers));
						break;
					case "m":
						System.out.println("Mean of values: " + CSVUtil.mean(csvIntegers));
					break;
					case "h":
						System.out.println("Highest value on each single line: " + Arrays.toString(CSVUtil.highestPerLine(csvLineIntegers)));
						break;
					case "c":
						System.out.println("Most common integer: " + CSVUtil.mostCommon(csvIntegers));
						break;
					case "l":
						System.out.println("Largest amount of integers on a single line: " + CSVUtil.LongestLine(csvLineIntegers));
						break;
					case "all":
						System.out.println("Most common integer: " + CSVUtil.mostCommon(csvIntegers));
						System.out.println("Highest value on each single line: " + Arrays.toString(CSVUtil.highestPerLine(csvLineIntegers)));
						System.out.println("Number of integers on the longest line: " + CSVUtil.LongestLine(csvLineIntegers));
						System.out.println("Mean of values: " + CSVUtil.mean(csvIntegers));
						System.out.println("Total of all integers: " + CSVUtil.total(csvIntegers));
						break;
					default:
						System.out.println(
								"The command you entered is not recognised. Try using help to find a list of commands");
						break;
					}
				}
			} catch (FileNotFoundException fnfe) {
				System.out.println(
						"Unable to read CSV file, Please check it exists and the program has permission to read from it");
				System.exit(1);
			}
		}

	}

}
