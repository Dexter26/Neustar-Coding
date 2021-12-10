package com.neustar.app;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Test suite to perform input and exception handling
 * @author anuplingaraj
 *
 */
class InputArgsTest{

	//instance under test
	NeustarCategoryApplication app; 

	@BeforeEach
	public void beforeEach() {
		app = new NeustarCategoryApplication();
	}

	@Test
	@DisplayName("Passing empty argument should not fail with exception/error")   
	void testEmptyArg() {
		assertEquals("Please provide the fullpath of the input file as argument", app.processCounter(new String[0]));
	}

	@Test
	@DisplayName("Passing null as argument should not fail with exception/error")   
	void testNullArg() {
		assertEquals("Input argument cannot be null", app.processCounter(null));
	}

	@Test
	@DisplayName("Passing wrong file path as argument should not fail with exception/error")   
	void testWrongPath() {
		String wrongPath[] = {"test.txt"};
		assertEquals("Exception at File Loading. Please check the file path again. !!!. Given: test.txt", app.processCounter(wrongPath));
	}

	//	@Test
	//	public void exceptionTesting() {
	//	    Throwable exception = assertThrows(NullPointerException.class, () -> app.processCounter(null));
	//	    assertEquals("", exception.getMessage());
	//	}
}
