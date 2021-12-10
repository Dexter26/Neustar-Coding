package com.neustar.app;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Test Suite to test business logic with various types of input
 * @author anuplingaraj
 *
 */
class BusinessLogicTest {

	//Instance under test
	NeustarCategoryApplication app; 

	@BeforeEach
	public void beforeEach() {
		app = new NeustarCategoryApplication();
	}

	@Test
	@DisplayName("Passing valid input should give proper/valid output")   
	void testValidInput() {
		String validOutput = "CATEGORY COUNT\n"
				+ "PERSON 2\n"
				+ "PLACE 2\n"
				+ "ANIMAL 2\n"
				+ "COMPUTER 1\n"
				+ "OTHER 1\n"
				+ "PERSON Bob Jones\n"
				+ "PLACE Washington\n"
				+ "PERSON Mary\n"
				+ "COMPUTER Mac\n"
				+ "OTHER Tree\n"
				+ "ANIMAL Dog\n"
				+ "PLACE Texas\n"
				+ "ANIMAL Cat";
		String inputTestFile[] = {"src/test/java/validInputTest.txt"};
		assertEquals(validOutput, app.processCounter(inputTestFile));
	}

	@Test
	@DisplayName("Passing valid input should give proper/valid output")   
	void testBlankLinesAndSubCategory() {
		String validOutput = "CATEGORY COUNT\n"
				+ "PERSON 2\n"
				+ "PLACE 3\n"
				+ "ANIMAL 1\n"
				+ "COMPUTER 1\n"
				+ "OTHER 1\n"
				+ "PERSON Bob Jones\n"
				+ "PLACE Washington\n"
				+ "PERSON Mary\n"
				+ "COMPUTER Mac\n"
				+ "OTHER Tree\n"
				+ "ANIMAL Dog\n"
				+ "PlACE Texas\n"
				+ "PLACE New Mexico";
		String inputTestFile[] = {"src/test/java/blankLinesAndSubCategoryTest.txt"};
		assertEquals(validOutput, app.processCounter(inputTestFile));
	}

	@Test
	@DisplayName("Passing valid input should give proper/valid output")   
	void testUserFriendlyCaseSensitivity() {
		String validOutput = 	"CATEGORY COUNT\n"
				+ "PERSON 2\n"
				+ "PLACE 3\n"
				+ "ANIMAL 2\n"
				+ "COMPUTER 1\n"
				+ "OTHER 1\n"
				+ "PERSON Bob Jones\n"
				+ "PLACE Washington\n"
				+ "ANIMAL Elon\n"
				+ "person Mary\n"
				+ "COMPUTER Mac\n"
				+ "OTHER Tree\n"
				+ "ANIMAL Dog\n"
				+ "place Texas\n"
				+ "place New Mexico";
		String inputTestFile[] = {"src/test/java/userFriendlyCaseSensitivityTest.txt"};
		assertEquals(validOutput, app.processCounter(inputTestFile));
	}
	
	@Test
	@DisplayName("Passing empty input should give proper/valid output")   
	void testEmptyFile() {
		String validOutput = 	"CATEGORY COUNT\n"
				+ "PERSON 0\n"
				+ "PLACE 0\n"
				+ "ANIMAL 0\n"
				+ "COMPUTER 0\n"
				+ "OTHER 0";
		
		String inputTestFile[] = {"src/test/java/emptyFileTest.txt"};
		assertEquals(validOutput, app.processCounter(inputTestFile));
	}

}
