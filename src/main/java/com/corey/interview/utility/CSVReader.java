package com.corey.interview.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVReader {

	public static List<Integer[]> readCSVReturnLines(String filename) throws FileNotFoundException {
		List<Integer[]> csvLineIntegers = new ArrayList<Integer[]>();
		Scanner scanner = new Scanner(new File(filename));
		scanner.useDelimiter("\n");
		List<String> lines = new ArrayList<String>();
		
		//add values to list of string, line per list entry
		while (scanner.hasNext()) {
			lines.add(scanner.next());
		}

		//turn List<String> to List<Integer> read line by line
		for (String line : lines) {
			Scanner scanner2 = new Scanner(line);
			scanner2.useDelimiter(",");
			List<Integer> tempLine = new ArrayList<Integer>();
			while (scanner2.hasNext()) {
				String currentInt = scanner2.next();
				try {
					tempLine.add(Integer.parseInt(currentInt.replaceAll("\"", "").trim()));
				} catch (NumberFormatException e) {

				}
			}
			
			//add the current line of integers to the array
			Integer[] tempLineArr = new Integer[tempLine.size()];
			for (int index = 0; index < tempLineArr.length; index++) {
				tempLineArr[index] = tempLine.get(index);
			}
			csvLineIntegers.add(tempLineArr);
		}
		scanner.close();
		return csvLineIntegers;
	}

	public static int[] readCSV(String filename) throws FileNotFoundException{
		List<Integer[]> csvLineIntegers = readCSVReturnLines(filename);

		int totalNumInts = 0; 
		for(int index = 0; index < csvLineIntegers.size();index++){
			totalNumInts += csvLineIntegers.get(index).length;
		}

		int[] csvIntegers = new int[totalNumInts];
		int csvIntegersIndex = 0; 

		//read each line, converting lines into one single array
		for(int lineIndex = 0; lineIndex < csvLineIntegers.size();lineIndex++){
			for(int intIndex = 0; intIndex < csvLineIntegers.get(lineIndex).length; intIndex++){
				csvIntegers[csvIntegersIndex] = csvLineIntegers.get(lineIndex)[intIndex]; 
				csvIntegersIndex++;
			}
		}
		return csvIntegers;
	}

}