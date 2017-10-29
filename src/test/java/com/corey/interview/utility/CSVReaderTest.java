package com.corey.interview.utility;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class CSVReaderTest {
	CSVReader underTest = new CSVReader();
	
	
	@Test
	public void shouldCreateListFromCSVFile() throws FileNotFoundException{

		List<Integer[]> expected = new ArrayList(Arrays.asList(1,2,3,4,5,6,7,8,9,10,10));
		
		List<Integer[]> result = underTest.readCSVReturnLines("src/test/resources/ReadTest.csv");
		
		for (int index =0; index < result.get(0).length; index++){
			assertEquals(result.get(0)[index],expected.get(index));
		}
	
	}
	
	
	@Test
	public void shouldCreateArrayFromCSVFile() throws FileNotFoundException{
		int[] expected = {1,2,3,4,5,6,7,8,9,10,10};
		
		int[] result = underTest.readCSV("src/test/resources/ReadTest.csv");
		
		assertArrayEquals(expected,result);
	}
	
	
}
