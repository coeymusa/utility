package com.corey.interview.utility;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class CSVWriter {
	
	public static void createCSV(int arraySize, int minRange, int maxRange, String savePath) throws IOException{
		int[] intArray = new int[arraySize];

		for (int index =0 ; index < arraySize; index++){
			Random rand = new Random();
			intArray[index] =  rand.nextInt(maxRange -minRange) + minRange;
		}

		BufferedWriter writer = new BufferedWriter(new FileWriter(savePath));
		writer.write(applyLines(intArray));

		writer.close();
	}

	private static String applyLines(int[] intArray) {
		String[] numbers = intArray.toString().split(",");

		int newLineCounter = generateLineSpacing(intArray.length);

		//looping through the length of the array counting each integer, and at a randomly generated position insert the new line escape character
		for (int index  =0;index <numbers.length; index++ ,newLineCounter--){
			if (newLineCounter == 0){
				numbers[index] = "\n" + numbers[index];
				newLineCounter = generateLineSpacing(intArray.length);
			}
		}
		return String.join(",", numbers);
	}


	private static int generateLineSpacing(int sizeOfArray) {
		Random random = new Random();

		//odd +1
		if (sizeOfArray % 2 == 1){
			sizeOfArray += 1;
		}

		//create new line in random position within range 1 - half array size
		return random.nextInt(sizeOfArray/2  -1 ) + 1;
	}

}
