package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;

public class ArgumentParserTest
{
    @Test
    public void TestInitialLabelArrayIsEmpty()
	{
		ArgumentParser p = new ArgumentParser();
        
        assertEquals(0, p.getNumberOfArguments())
    }
	
	@Test
    public void TestAddArgFillsLabelArray()
	{
		ArgumentParser p = new ArgumentParser();
		
        String[] argumentNames = {"Length", "Width", "Height"};        
		p.addArgumentNames(argumentNames);
		
		assertEquals("Length", p.getName(0));
		assertEquals("Width", p.getName(1));
		assertEquals("Height", p.getName(2)); 
    }
	
	@Test
    public void testGetValueReturnsCorrectValue()
	{
		ArgumentParser p = new ArgumentParser();
		
        String[] argumentNames = {"Length", "Width", "Height"};        
		p.addArgumentNames(argumentNames);
				
		String[] args = {"1", "2", "3"};
		p.parse(args);
		
		assertEquals("1", p.getValue("Length"));
		assertEquals("2", p.getValue("Width"));
		assertEquals("3", p.getValue("Height"));
	}
	
	@Test(expected=SomeException.class)
	public void testGetValueOfUnknownArgumentThrowsException()
	{
		ArgumentParser p = new ArgumentParser();
		
        String[] argumentNames = {"something"};        
		p.addArgumentNames(argumentNames);
        
		String[] args = {"7"};
		p.parse(args);
		p.getValue("other");
	}

}