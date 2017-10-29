package com.corey.interview.utility;

import static org.junit.Assert.assertArrayEquals;

import java.io.FileNotFoundException;

import org.junit.Test;

public class CSVReaderTest {
	CSVReader underTest = new CSVReader();
	
	
//	@Test
//	public void shouldCreateListFromCSVFile() throws FileNotFoundException{
//		 new ArrayList<Integer[]>();
//		List<Integer[]> expected = new ArrayList<Integer>(Arrays.asList());
//		
//		List<Integer[]> result = underTest.readCSVReturnLines("src/test/resources/RandomIntegers.csv");
//		
//		assertArrayEquals(expected.get(1),result.get(1));
//	}
//	
	@Test
	public void shouldCreateArrayFromCSVFile() throws FileNotFoundException{
		int[] expected = {1,2,3,4,5,6,7,8,9,10,10};
		
		int[] result = underTest.readCSV("src/test/resources/RandomIntegers.csv");
		
		assertArrayEquals(expected,result);
	}
	
	
}
