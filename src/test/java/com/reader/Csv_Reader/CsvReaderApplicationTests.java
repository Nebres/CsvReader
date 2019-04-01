package com.reader.Csv_Reader;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CsvReaderApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void shouldInitFieldInClassAndReturnTrue() throws IOException {

		//Given
		DataReader reader = new DataReader();
		boolean worked;
		String text;

		//When
		worked = reader.initTempData("C:\\Users\\nebre\\OneDrive\\kodowanie\\Projekty_Eclipse\\SpringBoot" +
				"\\Csv_Reader\\src\\attributes.csv");
		text = reader.getTempData();

		//Then
		Assert.assertTrue(worked);
		Assert.assertNotNull(text);
		Assert.assertTrue(!text.equals(""));
		System.out.println(text);
	}

	@Test
	public void shouldReturnArrayFromReceivedText() throws IOException {

		//Given
		DataReader reader = new DataReader();
		String text;
		String[] result;
		//When
		reader.initTempData("C:\\Users\\nebre\\OneDrive\\kodowanie\\Projekty_Eclipse\\SpringBoot" +
				"\\Csv_Reader\\src\\attributes.csv");
		text = reader.getTempData();
		result = reader.buildArray(text);
		//Then
		Assert.assertNotNull(text);
		Assert.assertTrue(!text.equals(""));
		for (String s : result ) {
			System.out.println(s);
		}
		System.out.println(result.length);
	}


}
