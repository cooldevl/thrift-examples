package com.asksunny.cli;

import static org.junit.Assert.*;

import org.junit.Test;

public class CLIParserTest {

	@Test
	public void testParse1() {
		String[]  test = new String[]{};		
		CLIParameters params = CLIParser.parse(test);		
		assertFalse(params.hasParameter("test"));	
	}
	
	
	@Test
	public void testParse2() {
		String[]  test = new String[]{"My test Value"};		
		CLIParameters params = CLIParser.parse(test);		
		assertTrue(params.hasParameterValue("0"));	
	}
	
	
	
	@Test
	public void testParse3() {
		String[]  test = new String[]{"--test", "My test Value"};		
		CLIParameters params = CLIParser.parse(test);		
		assertEquals("My test Value", params.getStringParameter("test"));	
	}
	
	
	@Test
	public void testParse4() {
		String[]  test = new String[]{"--test", "-anotherArg"};		
		CLIParameters params = CLIParser.parse(test);
		assertFalse(params.hasParameterValue("test"));	
	}
	
	
	@Test
	public void testParse5() {
		String[]  test = new String[]{"--test", "\\-anotherArg"};		
		CLIParameters params = CLIParser.parse(test);		
		assertEquals("-anotherArg", params.getStringParameter("test"));	
	}
	

}
