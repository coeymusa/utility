package com.corey.interview.utility;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

public class CSVUtil {
	
	public static int total(int[] randomArray) {
		int total = 0;
		for (int index = 0; index < randomArray.length; index++) {
			total += randomArray[index];
		}

		return total;
	}

	public static String mean(int[] randomArray) {
		
		DecimalFormat df = new DecimalFormat("#.###");
		df.setRoundingMode(RoundingMode.HALF_UP);
		Double mean = (double) (total(randomArray)) / randomArray.length;
		
		return df.format(mean);
	}

	public static int[] highestPerLine(List<Integer[]> randomArray){
		int[] ret = new int[randomArray.size()];
		for(int index = 0; index < randomArray.size(); index++){
			ret[index] = highest(randomArray.get(index));
		}
		return ret;
	}

	public static int highest(Integer[] randomArray) {
		int highest = randomArray[0];
		for (int index = 1; index < randomArray.length; index++) {
			if (randomArray[index] > highest) {
				highest = randomArray[index];
			}
		}

		return highest;
	}

	// O(nlogn) solution using initial sort
	public static int mostCommon(int[] randomArray) {
		Arrays.sort(randomArray);
		int pop = 0;
		int popCount = 0;
		int index = 0;
		while (index < randomArray.length) {
			int current = randomArray[index];
			int currentCount = 0;
			while (index < randomArray.length && randomArray[index] == current) {
				currentCount++;
				index++;
			}
			if (currentCount > popCount) {
				popCount = currentCount;
				pop = current;
			}
		}
		return pop;
	}
}

