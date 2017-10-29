package com.corey.interview.utility;

import static org.junit.Assert.assertEquals;

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

		int expected = 10;

		int result =underTest.mostCommon(intList);

		assertEquals(expected,result);
	}

//	@Test
//	public void shouldNotFindMostCommonInteger(){
//		List<Integer> intList = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
//
//		String expected = "No modal value";
//
//		String result =underTest.mostCommon(intList);
//
//		assertEquals(expected,result);
//	}
}
