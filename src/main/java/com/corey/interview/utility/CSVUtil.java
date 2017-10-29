package com.corey.interview.utility;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;


public class CSVUtil {

	/**
	 * Finds the total of an array of {@link Integers} 
	 * 
	 * @return {@link Integer}
	 */
	public static int total(int[] randomArray) {
		int total = 0;
		for (int index = 0; index < randomArray.length; index++) {
			total += randomArray[index];
		}

		return total;
	}
	
	/**
	 * Finds the mean of an array of {@link Integers} 
	 * 
	 * @return {@link String}
	 */
	public static String mean(int[] randomArray) {
		DecimalFormat df = new DecimalFormat("#.###");
		df.setRoundingMode(RoundingMode.HALF_UP);
		Double mean = (double) (total(randomArray)) / randomArray.length;

		return df.format(mean);
	}

	
	/**
	 * Searches an array of {@link Integers} and returns the highest int in the array
	 * 
	 * @return {@link Integer}
	 */
	public static int[] highestPerLine(List<Integer[]> randomArray){
		int[] ret = new int[randomArray.size()];
		for(int index = 0; index < randomArray.size(); index++){
			ret[index] = highest(randomArray.get(index));
		}
		return ret;
	}
	
	/**
	 * Sorts an array of {@link Integers} and returns the most highest in the array
	 * 
	 * @return {@link Integer}
	 */
	public static int highest(Integer[] randomArray) {
		int highest = randomArray[0];
		for (int index = 1; index < randomArray.length; index++) {
			if (randomArray[index] > highest) {
				highest = randomArray[index];
			}
		}

		return highest;
	}

	/**
	 * Sorts an array of {@link Integers} and returns the most common number in the array
	 * 
	 * @return {@link String}
	 */
	public static String mostCommon(int[] randomArray) {
		Arrays.sort(randomArray);
		int highestInteger = 0;
		int maxCount = 0;
		int index = 0;
		int duplicateMax=0;
		
		while (index < randomArray.length) {
			int current = randomArray[index];
			int currentCount = 0;
			while (index < randomArray.length && randomArray[index] == current) {
				currentCount++;
				index++;
			}
			if (currentCount > maxCount) {
				maxCount = currentCount;
				highestInteger = current;
			} else if (currentCount == maxCount){
				duplicateMax = currentCount;
			}
		}
		
		if (maxCount != duplicateMax){
			return String.valueOf(highestInteger);
		} else {
			return "No modal value";
		}

	}
	/**
	 * Sorts a {@link List} of an array of{@link Integers} and returns the most number of integers on the longest line
	 * 
	 * @return {@link String}
	 */
	public static String LongestLine(List<Integer[]> csvLineIntegers) {
		int lineCount=0;
		int maxLineCount=0;

		for (int lineIndex=0; lineIndex < csvLineIntegers.size();lineIndex++){
			for(int intIndex =0; intIndex < csvLineIntegers.get(lineIndex).length; intIndex ++){
				lineCount++;

				if(lineCount > maxLineCount){
					maxLineCount = lineCount ;
				}
			}
			lineCount =0;
		}

		return String.valueOf(maxLineCount);

	}
}

