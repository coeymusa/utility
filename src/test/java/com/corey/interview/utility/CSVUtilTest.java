package com.corey.interview.utility;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;


public class CSVUtilTest {
	CSVUtil underTest = new CSVUtil();

	int[] intList = {1,2,3,4,5,6,7,8,9,10,10};


	@Test
	public void shouldFindMeanFromList(){

		String expected = "5.909";

		String result =underTest.mean(intList);

		assertEquals(expected,result);
	}

	@Test
	public void shouldFindSumFromList(){

		int expected = 65;

		int result =underTest.total(intList);

		assertEquals(expected,result);
	}

	@Test
	public void shouldFindMostCommonIntegerList(){

		String expected = "10";

		String result =underTest.mostCommon(intList);

		assertEquals(expected,result);
	}

	@Test
	public void shouldFindLongestLine() throws FileNotFoundException{
		String expected = "19";

		String result = underTest.LongestLine(CSVReader.readCSVReturnLines("src/main/resources/RandomInteger.csv"));

		assertEquals(expected, result);
	}


	@Test(expected = FileNotFoundException.class)
	public void shouldThrowFileNotFoundException() throws FileNotFoundException{
		String expected = "19";

		String result = underTest.LongestLine(CSVReader.readCSVReturnLines("src/main/resources/failedTest.csv"));
	}

	@Test
	public void shouldNotFindMostCommonInteger(){
		int[] intList = {1,2,3,4,5,6,7,8,9,10};

		String expected = "No modal value";

		String result =underTest.mostCommon(intList);

		assertEquals(expected,result);
	}
}
