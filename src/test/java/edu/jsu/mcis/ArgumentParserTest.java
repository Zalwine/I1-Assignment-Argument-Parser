package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class ArgumentParserTest{       
    ArgumentParser p;
    
    @Before
    public void setUp(){        
        p = new ArgumentParser(); 
    }
    
    @Test
    public void testInitialArgumentMapIsEmpty(){        
        assertEquals(0, p.getNumberOfArguments());
    }   
    
    @Test
    public void testAddArgAndTestDescription(){    
        p.addPositionalArgument("Length", "The length of the box", ArgumentParser.Types.INTEGER);
        p.addPositionalArgument("Width", "The width of the box", ArgumentParser.Types.INTEGER);
        p.addPositionalArgument("Height", "The height of the box", ArgumentParser.Types.INTEGER);
        
        assertEquals("The length of the box", p.getArgumentDescription("Length"));
        assertEquals("The width of the box", p.getArgumentDescription("Width"));
        assertEquals("The height of the box", p.getArgumentDescription("Height")); 
    }   
    
    @Test
    public void testAddArgAndTestType(){
        p.addPositionalArgument("Length", "The length of the box", ArgumentParser.Types.INTEGER);
        p.addPositionalArgument("Width", "The width of the box", ArgumentParser.Types.INTEGER);
        p.addPositionalArgument("Height", "The height of the box", ArgumentParser.Types.INTEGER);
        
        assertEquals(ArgumentParser.Types.INTEGER, p.getArgumentType("Length"));
        assertEquals(ArgumentParser.Types.INTEGER, p.getArgumentType("Width"));
        assertEquals(ArgumentParser.Types.INTEGER, p.getArgumentType("Height"));
    }    
    
    @Test
    public void testAddArgAndTestTypeUsingValueOf(){
        p.addPositionalArgument("Length", "The length of the box", ArgumentParser.Types.valueOf("INTEGER"));
        p.addPositionalArgument("Width", "The width of the box", ArgumentParser.Types.valueOf("INTEGER"));
        p.addPositionalArgument("Height", "The height of the box", ArgumentParser.Types.valueOf("INTEGER"));
        
        assertEquals(ArgumentParser.Types.INTEGER, p.getArgumentType("Length"));
        assertEquals(ArgumentParser.Types.INTEGER, p.getArgumentType("Width"));
        assertEquals(ArgumentParser.Types.INTEGER, p.getArgumentType("Height"));
    }    
    
    @Test
    public void testAddArgAndTestTypeAsString(){
        p.addPositionalArgument("Length", "The length of the box", ArgumentParser.Types.INTEGER);
        p.addPositionalArgument("Width", "The width of the box", ArgumentParser.Types.INTEGER);
        p.addPositionalArgument("Height", "The height of the box", ArgumentParser.Types.INTEGER);
        
        assertEquals("INTEGER", p.getArgumentTypeAsString("Length"));
        assertEquals("INTEGER", p.getArgumentTypeAsString("Width"));
        assertEquals("INTEGER", p.getArgumentTypeAsString("Height"));
    }

    @Test
    public void testInitialOptionalArgumentMapIsEmpty(){
        assertEquals(0, p.getNumberOfOptionalArguments());
    }     
    
    @Test
    public void testAddOptionalArgAndTestDescription(){
        p.addPositionalArgument("Argument Name", "Argument Description", ArgumentParser.Types.INTEGER);
        p.addNamedArgument("Optional Argument Name 1", "Optional Argument Description 1", ArgumentParser.Types.INTEGER, 10);   
        p.addNamedArgument("Optional Argument Name 2", "Optional Argument Description 2", ArgumentParser.Types.STRING, "value"); 
        p.addNamedArgument("Optional Argument Name 3", "Optional Argument Description 3", ArgumentParser.Types.BOOLEAN, true); 
        p.addNamedArgument("Optional Argument Name 4", "Optional Argument Description 4", ArgumentParser.Types.FLOAT, 2.0f); 
        assertEquals("Optional Argument Description 1", p.getArgumentDescription("Optional Argument Name 1"));        
        assertEquals("Optional Argument Description 2", p.getArgumentDescription("Optional Argument Name 2"));      
        assertEquals("Optional Argument Description 3", p.getArgumentDescription("Optional Argument Name 3"));  
        assertEquals("Optional Argument Description 4", p.getArgumentDescription("Optional Argument Name 4"));
    }    
    
    @Test
    public void testAddOptionalIntegerAndTestType(){
        p.addPositionalArgument("Argument Name", "Argument Description", ArgumentParser.Types.INTEGER);
        p.addNamedArgument("Optional Argument Name 1", "Optional Argument Description 1", ArgumentParser.Types.INTEGER, 10); 
        assertEquals(ArgumentParser.Types.INTEGER, p.getArgumentType("Optional Argument Name 1"));        
    }     
    
    @Test
    public void testAddOptionalStringAndTestType(){
        p.addPositionalArgument("Argument Name", "Argument Description", ArgumentParser.Types.INTEGER);
        p.addNamedArgument("Optional Argument Name 2", "Optional Argument Description 2", ArgumentParser.Types.STRING, "value");     
        assertEquals(ArgumentParser.Types.STRING, p.getArgumentType("Optional Argument Name 2"));    
    }  
    
    @Test
    public void testAddOptionalBooleanAndTestType(){
        p.addPositionalArgument("Argument Name", "Argument Description", ArgumentParser.Types.INTEGER);
        p.addNamedArgument("Optional Argument Name 3", "Optional Argument Description 3", ArgumentParser.Types.BOOLEAN, true);     
        assertEquals(ArgumentParser.Types.BOOLEAN, p.getArgumentType("Optional Argument Name 3"));    
    }  
    
    @Test
    public void testAddOptionalFloatAndTestType(){
        p.addPositionalArgument("Argument Name", "Argument Description", ArgumentParser.Types.INTEGER);
        p.addNamedArgument("Optional Argument Name 4", "Optional Argument Description 4", ArgumentParser.Types.FLOAT, 2.0f);   
        assertEquals(ArgumentParser.Types.FLOAT, p.getArgumentType("Optional Argument Name 4"));
    } 
    
    @Test
    public void testAddOptionalIntegerAndTestTypeUsingValueOf(){
        p.addPositionalArgument("Argument Name", "Argument Description", ArgumentParser.Types.INTEGER);
        p.addNamedArgument("Optional Argument Name 1", "Optional Argument Description 1", ArgumentParser.Types.valueOf("INTEGER"), 10);  
        assertEquals(ArgumentParser.Types.INTEGER, p.getArgumentType("Optional Argument Name 1"));        
    }     
    
    @Test
    public void testAddOptionalStringAndTestTypeUsingValueOf(){
        p.addPositionalArgument("Argument Name", "Argument Description", ArgumentParser.Types.INTEGER);
        p.addNamedArgument("Optional Argument Name 2", "Optional Argument Description 2", ArgumentParser.Types.valueOf("STRING"), "value"); 
        assertEquals(ArgumentParser.Types.STRING, p.getArgumentType("Optional Argument Name 2"));      
    }  
    
    @Test
    public void testAddOptionalBooleanAndTestTypeUsingValueOf(){
        p.addPositionalArgument("Argument Name", "Argument Description", ArgumentParser.Types.INTEGER);
        p.addNamedArgument("Optional Argument Name 3", "Optional Argument Description 3", ArgumentParser.Types.valueOf("BOOLEAN"), true); 
        assertEquals(ArgumentParser.Types.BOOLEAN, p.getArgumentType("Optional Argument Name 3"));    
    }  
    
    @Test
    public void testAddOptionalFloatAndTestTypeUsingValueOf(){
        p.addPositionalArgument("Argument Name", "Argument Description", ArgumentParser.Types.INTEGER);
        p.addNamedArgument("Optional Argument Name 4", "Optional Argument Description 4", ArgumentParser.Types.valueOf("FLOAT"), 2.0f); 
        assertEquals(ArgumentParser.Types.FLOAT, p.getArgumentType("Optional Argument Name 4"));   
    } 
    
    @Test
    public void testAddOptionalIntegerAndTestTypeAsString(){
        p.addPositionalArgument("Argument Name", "Argument Description", ArgumentParser.Types.INTEGER);        
        p.addNamedArgument("Optional Argument Name 1", "Optional Argument Description 1", ArgumentParser.Types.INTEGER, 10); 
        assertEquals("INTEGER", p.getArgumentTypeAsString("Optional Argument Name 1"));      
    }  
    
    @Test
    public void testAddOptionalStringAndTestTypeAsString(){
        p.addPositionalArgument("Argument Name", "Argument Description", ArgumentParser.Types.INTEGER);
        p.addNamedArgument("Optional Argument Name 2", "Optional Argument Description 2", ArgumentParser.Types.STRING, "value"); 
        assertEquals("STRING", p.getArgumentTypeAsString("Optional Argument Name 2"));      
    }  
    
    @Test
    public void testAddOptionalBooleanAndTestTypeAsString(){
        p.addPositionalArgument("Argument Name", "Argument Description", ArgumentParser.Types.INTEGER);
        p.addNamedArgument("Optional Argument Name 3", "Optional Argument Description 3", ArgumentParser.Types.BOOLEAN, true); 
        assertEquals("BOOLEAN", p.getArgumentTypeAsString("Optional Argument Name 3"));    
    }  
    
    @Test
    public void testAddOptionalFloatAndTestTypeAsString(){
        p.addPositionalArgument("Argument Name", "Argument Description", ArgumentParser.Types.INTEGER);
        p.addNamedArgument("Optional Argument Name 4", "Optional Argument Description 4", ArgumentParser.Types.FLOAT, 2.0f); 
        assertEquals("FLOAT", p.getArgumentTypeAsString("Optional Argument Name 4"));    
    }
    
    @Test
    public void testAddOptionalIntAndTestDefaultValue(){
        p.addPositionalArgument("Argument Name", "Argument Description", ArgumentParser.Types.INTEGER);
        p.addNamedArgument("Optional Argument Name 1", "Optional Argument Description 1", ArgumentParser.Types.INTEGER, 10);  
        int intValue = p.getDefaultValueOf("Optional Argument Name 1");
        assertEquals(10, intValue);           
    }
    
    @Test
    public void testAddOptionalStringAndTestDefaultValue(){
        p.addPositionalArgument("Argument Name", "Argument Description", ArgumentParser.Types.INTEGER);
        p.addNamedArgument("Optional Argument Name 2", "Optional Argument Description 2", ArgumentParser.Types.STRING, "value"); 
        String stringValue = p.getDefaultValueOf("Optional Argument Name 2");
        assertEquals("value", stringValue);                
    }
    
    @Test
    public void testAddOptionalBooleanAndTestDefaultValue(){
        p.addPositionalArgument("Argument Name", "Argument Description", ArgumentParser.Types.INTEGER);
        p.addNamedArgument("Optional Argument Name 3", "Optional Argument Description 3", ArgumentParser.Types.BOOLEAN, false); 
        boolean boolValue = p.getDefaultValueOf("Optional Argument Name 3");
        assertEquals(false, boolValue);               
    }
    
    @Test
    public void testAddOptionalFloatAndTestDefaultValue(){
        p.addPositionalArgument("Argument Name", "Argument Description", ArgumentParser.Types.INTEGER);
        p.addNamedArgument("Optional Argument Name 4", "Optional Argument Description 4", ArgumentParser.Types.FLOAT, 2.0f); 
        float floatValue = p.getDefaultValueOf("Optional Argument Name 4");
        assertEquals(2.0f, floatValue, 0.1f);           
    }
    
    @Test
    public void testAddProgramDescription(){        
        p.setProgramDescription("This is simply a test.");
        assertEquals("This is simply a test.", p.getProgramDescription()); 
    }
    
    @Test
    public void testGetValueReturnsCorrectValue(){
        p.addPositionalArgument("Length", "The length of the box", ArgumentParser.Types.INTEGER);
        p.addPositionalArgument("Width", "The width of the box", ArgumentParser.Types.INTEGER);
        p.addPositionalArgument("Height", "The height of the box", ArgumentParser.Types.INTEGER);
        
        p.printProgramInformation();
                
        String[] args = {"1", "2", "3"};
        p.parse(args);
        
        int length = p.getValueOf("Length");
        int width = p.getValueOf("Width");
        int height = p.getValueOf("Height");
        
        assertEquals(1, length);
        assertEquals(2, width);
        assertEquals(3, height);
    }
    
    @Test
    public void testGetValueOfOptionalArgumentAtEndOfTheList(){
        p.addPositionalArgument("Length", "The length of the box", ArgumentParser.Types.INTEGER);
        p.addPositionalArgument("Width", "The width of the box", ArgumentParser.Types.INTEGER);
        p.addPositionalArgument("Height", "The height of the box", ArgumentParser.Types.INTEGER);
        
        p.addNamedArgument("Color", "The color of the box", ArgumentParser.Types.STRING, "white");
        
        p.printProgramInformation();
                
        String[] args = {"1", "2", "3", "--Color", "red"};
        p.parse(args);
        
        int length = p.getValueOf("Length");
        int width = p.getValueOf("Width");
        int height = p.getValueOf("Height");
        String color = p.getValueOf("Color");
        
        assertEquals(1, length);
        assertEquals(2, width);
        assertEquals(3, height);
        assertEquals("red", color);
    }   
    
    @Test
    public void testGetValueOfOptionalArgumentInTheMiddleOfTheList(){
        p.addPositionalArgument("Length", "The length of the box", ArgumentParser.Types.INTEGER);
        p.addPositionalArgument("Width", "The width of the box", ArgumentParser.Types.INTEGER);
        p.addPositionalArgument("Height", "The height of the box", ArgumentParser.Types.INTEGER);
        
        p.addNamedArgument("Color", "The color of the box", ArgumentParser.Types.STRING, "white");
                
        String[] args = {"1", "--Color", "red", "2", "3"};
        p.parse(args);
        
        int length = p.getValueOf("Length");
        int width = p.getValueOf("Width");
        int height = p.getValueOf("Height");
        String color = p.getValueOf("Color");
        
        assertEquals(1, length);
        assertEquals(2, width);
        assertEquals(3, height);
        assertEquals("red", color);
    }       
    
    @Test
    public void testGetValueOfOptionalArgumentAtBeginningOfTheList(){
        p.addPositionalArgument("Length", "The length of the box", ArgumentParser.Types.INTEGER);
        p.addPositionalArgument("Width", "The width of the box", ArgumentParser.Types.INTEGER);
        p.addPositionalArgument("Height", "The height of the box", ArgumentParser.Types.INTEGER);
        
        p.addNamedArgument("Color", "The color of the box", ArgumentParser.Types.STRING, "white");
                
        String[] args = {"--Color", "red", "1", "2", "3"};
        p.parse(args);
        
        int length = p.getValueOf("Length");
        int width = p.getValueOf("Width");
        int height = p.getValueOf("Height");
        String color = p.getValueOf("Color");
        
        assertEquals(1, length);
        assertEquals(2, width);
        assertEquals(3, height);
        assertEquals("red", color);
    }
    
    @Test
    public void testCallMultipleArgumentsFromOneArgument(){
        p.addNamedArgument("Box", "The length, width, height of the box", ArgumentParser.Types.INTEGER, 0);
        
        p.readyAdditionalValues("Box", 3);
        
        String[] args = {"--Box", "10", "20", "30"};
        p.parse(args);
        
        int[] compare = {10, 20, 30};
        int value1 = p.getValueOf("Box", 0);
        int value2 = p.getValueOf("Box", 1);
        int value3 = p.getValueOf("Box", 2);
        assertEquals(compare[0], value1);
        assertEquals(compare[1], value2);
        assertEquals(compare[2], value3);

    }
    
    @Test
    public void testWriteMultipleArgumentFromOneArgumentTypeInteger(){
        p.addNamedArgument("Box", "The length, width, height of the box", ArgumentParser.Types.INTEGER, 0);
        
        p.readyAdditionalValues("Box", 3);
        
        String[] args = {"--Box", "10", "20", "30"};
        p.parse(args);
        XMLManager.writeArguments("testXML/testMultipleArguments.xml", p);
        p = new ArgumentParser();
        XMLManager.loadArguments("testXML/testMultipleArguments.xml", p);
        
        int numOfValues = p.getNumberOfAdditionalValues("Box");
        assertEquals(3, numOfValues);
    }
    
    @Test
    public void testWriteMultipleArgumentFromOneArgumentTypeString(){
        p.addNamedArgument("Named", "Named Argument", ArgumentParser.Types.STRING, "Name");
        p.readyAdditionalValues("Named", 2);
        
        String[] args = {"--Named", "A", "B"};
        p.parse(args);
        String value1 = p.getValueOf("Named", 0);
        String value2 = p.getValueOf("Named", 1);
        assertEquals("A", value1);
        assertEquals("B", value2);
        
    }
    
    @Test
    public void testWriteMultipleArgumentFromOneArgumentTypeFloat(){
        p.addNamedArgument("Float", "f", "Float argument", ArgumentParser.Types.FLOAT, 0.0f);
        p.readyAdditionalValues("Float", 2);
        
        String[] args = {"-f", "1.0f", "2.0f"};
        p.parse(args);
        float value1 = p.getValueOf("Float", 0);
        float value2 = p.getValueOf("Float", 1);
        assertEquals(1.0f, value1, 0.1f);
        assertEquals(2.0f, value2, 0.1f);
    }
    
    @Test
    public void testWriteMultipleArgumentsHasRestrictedValuesTypeString(){
        Object[] values = {"Yes", "No", "Maybe"};
        p.addNamedArgument("String", "String argument", ArgumentParser.Types.STRING, "String");
        p.readyAdditionalValues("String", 2);
        p.setRestrictedValues("String", values);
        
        String[] args = {"--String", "Yes", "No"};
        p.parse(args);
        
        String value1 = p.getValueOf("String", 0);
        String value2 = p.getValueOf("String", 1);
        
        assertEquals("Yes", value1);
        assertEquals("No", value2);
    }
    
    @Test
    public void testWriteMultipleArgumentsHasRestrictedValuesTypeFloat(){
        Object[] values = {2f, 3f, 4f};
        p.addNamedArgument("Float", "Float argument", ArgumentParser.Types.FLOAT, 0f);
        p.readyAdditionalValues("Float", 3);
        p.setRestrictedValues("Float", values);
        
        String[] args = {"--Float", "2f", "3f", "4f"};
        p.parse(args);
        
        float value1 = p.getValueOf("Float", 0);
        float value2 = p.getValueOf("Float", 1);
        float value3 = p.getValueOf("Float", 2);
        
        assertEquals(2f, value1, 0.1f);
        assertEquals(3f, value2, 0.1f);
        assertEquals(4f, value3, 0.1f);
    }
    
    @Test(expected=InvalidArgumentException.class)
    public void testWriteMultipleArgumentValuesThrowsException(){
        p.addNamedArgument("Int", "Int argument", ArgumentParser.Types.INTEGER, 10);
        p.readyAdditionalValues("Int", 2);
        
        String[] args = {"--Int", "2f", "3f"};
        p.parse(args);
    }
    
    @Test(expected=InvalidArgumentException.class)
    public void testWriteMultipleArgumentsHasRestrictedValuesThrowsException(){
        Object[] values = {2f, 3f};
        p.addNamedArgument("String", "String argument", ArgumentParser.Types.STRING, "String");
        p.readyAdditionalValues("String", 2);
        p.setRestrictedValues("String", values);
        
        String[] args = {"--String", "2", "3"};
        p.parse(args);
    }
    
    @Test
    public void testGetValueOfMultipleOptionalArguments(){
        p.addPositionalArgument("Length", "The length of the box", ArgumentParser.Types.INTEGER);
        p.addPositionalArgument("Width", "The width of the box", ArgumentParser.Types.INTEGER);
        p.addPositionalArgument("Height", "The height of the box", ArgumentParser.Types.INTEGER);
        
        p.addNamedArgument("Color", "The color of the box", ArgumentParser.Types.STRING, "white");
        p.addNamedArgument("Weight", "The weight of the box", ArgumentParser.Types.INTEGER, 1);
                
        String[] args = {"--Color", "red", "1", "2", "3", "--Weight", "5"};
        p.parse(args);
        
        int length = p.getValueOf("Length");
        int width = p.getValueOf("Width");
        int height = p.getValueOf("Height");
        String color = p.getValueOf("Color");
        int weight = p.getValueOf("Weight");
        
        assertEquals(1, length);
        assertEquals(2, width);
        assertEquals(3, height);
        assertEquals("red", color);
        assertEquals(5, weight);
    }
    
    @Test
    public void testAddRequiredArgumentsWorksLikeNormalNamedArguments(){
        p.addPositionalArgument("Argument Name", "Argument Description", ArgumentParser.Types.INTEGER);
        p.addRequiredNamedArgument("Optional1", "Optional Argument Description 1", ArgumentParser.Types.INTEGER, 10);        
        p.addRequiredNamedArgument("Optional2", "Optional Argument Description 2", ArgumentParser.Types.INTEGER, 10);         
        p.addRequiredNamedArgument("Optional3", "O", "Optional Argument Description 3", ArgumentParser.Types.INTEGER, 10);  
        p.addNamedArgument("Optional4", "Optional Argument Description 4", ArgumentParser.Types.INTEGER, 10);
        
        Object[] restricted = {12, 14, 45};
        
        p.setRestrictedValues("Optional1", restricted);
        
        String[] args = {"-O", "99", "3", "--Optional1", "45", "--Optional2", "55"};
        p.parse(args);
        
        p.printProgramInformation();
        
        int intValue1 = p.getValueOf("Optional1");
        int intValue2 = p.getValueOf("Optional2");
        int intValue3 = p.getValueOf("Optional3");
        
        assertEquals(45, intValue1);  
        assertEquals(55, intValue2);          
        assertEquals(99, intValue3);
    }
    
    @Test
    public void testAddRestrictedIntegerValuesToArguments(){
        Object[] restrictedValues = {10, 15, 20};
        
        p.addPositionalArgument("Argument Name", "Argument Description", ArgumentParser.Types.INTEGER);
        p.addRequiredNamedArgument("Optional", "Optional Argument Description 1", ArgumentParser.Types.INTEGER, 10);  
        p.setRestrictedValues("Argument Name", restrictedValues);
        p.setRestrictedValues("Optional", restrictedValues);
                
        String[] args = {"10", "--Optional", "10"};
        p.parse(args);
        
        int intValue = p.getValueOf("Argument Name");        
        int intNamedValue = p.getValueOf("Optional");
        assertEquals(10, intValue);  
        assertEquals(10, intNamedValue);  
    }
    
    @Test
    public void testAddRestrictedFloatValuesToArguments(){
        Object[] restrictedValues = {2f, 4f, 6f};
        
        p.addPositionalArgument("Argument Name", "Argument Description", ArgumentParser.Types.FLOAT);
        p.setRestrictedValues("Argument Name", restrictedValues);
                
        String[] args = {"2f"};
        p.parse(args);
        
        float floatValue = p.getValueOf("Argument Name");
        assertEquals(2f, floatValue, 0.1f);  
    }
    
    @Test
    public void testAddRestrictedStringValuesToArguments(){
        Object[] restrictedValues = {"cat", "dog", "Cat", "Dog"};
        
        p.addPositionalArgument("Argument Name", "Argument Description", ArgumentParser.Types.STRING);
        p.setRestrictedValues("Argument Name", restrictedValues);
                
        String[] args = {"Dog"};
        p.parse(args);
        
        String stringValue = p.getValueOf("Argument Name");
        assertEquals("Dog", stringValue);  
    }
    
    @Test
    public void testAddArgumentToGroup(){        
        p.addPositionalArgument("Argument Name", "Argument Description", ArgumentParser.Types.STRING);
        p.addNamedArgument("Optional", "Optional Argument Description 1", ArgumentParser.Types.INTEGER, 10);  
        p.addArgumentToGroup("Optional", "Group 1");

        assertEquals("Group 1", p.getArgumentGroup("Optional"));
    }
    
    @Test
    public void testAddMultipleArgumentsToMultipleGroups(){        
        p.addPositionalArgument("Argument Name", "Argument Description", ArgumentParser.Types.STRING);
        p.addNamedArgument("Optional1", "Optional Argument Description 1", ArgumentParser.Types.INTEGER, 10);  
        p.addNamedArgument("Optional2", "Optional Argument Description 2", ArgumentParser.Types.INTEGER, 10);  
        p.addNamedArgument("Optional3", "Optional Argument Description 3", ArgumentParser.Types.INTEGER, 10); 
        p.addArgumentToGroup("Optional1", "Group 1"); 
        p.addArgumentToGroup("Optional2", "Group 1");
        p.addArgumentToGroup("Optional3", "Group 2");
        
        p.printProgramInformation();

        assertEquals("Group 1", p.getArgumentGroup("Optional1"));
        assertEquals("Group 1", p.getArgumentGroup("Optional2"));
        assertEquals("Group 2", p.getArgumentGroup("Optional3"));
    }
    
    @Test(expected=NotInTheSameGroupException.class)
    public void testUsingArgumentsInDifferentGroupsThrowsException(){
        p.addNamedArgument("Optional1", "Optional Argument Description 1", ArgumentParser.Types.INTEGER, 10);  
        p.addNamedArgument("Optional2", "Optional Argument Description 2", ArgumentParser.Types.INTEGER, 10);  
        p.addNamedArgument("Optional3", "Optional Argument Description 2", ArgumentParser.Types.INTEGER, 10);    
        p.addArgumentToGroup("Optional1", "Group 1"); 
        p.addArgumentToGroup("Optional2", "Group 1");
        p.addArgumentToGroup("Optional3", "Group 2");        
                
        String[] args = {"--Optional1", "45", "--Optional2", "55", "--Optional3", "65"};
        p.parse(args);
    }
    
    @Test(expected=InvalidArgumentException.class)
    public void testAddPositionalArgumentToGroupThrowsException(){        
        p.addPositionalArgument("Argument Name", "Argument Description", ArgumentParser.Types.STRING);
        p.addArgumentToGroup("Argument Name", "Group 1");
    }
    
    @Test(expected=UnknownArgumentException.class)
    public void testAddUnknownArgumentToGroupThrowsException(){        
        p.addPositionalArgument("Argument Name", "Argument Description", ArgumentParser.Types.STRING);
        p.addArgumentToGroup("wrong", "Group 1");
    }
    
    @Test(expected=NotInGroupException.class)
    public void testGetArgumentNotInGroupThrowsException(){        
        p.addPositionalArgument("Argument Name", "Argument Description", ArgumentParser.Types.STRING);
        p.addNamedArgument("Optional", "Optional Argument Description 1", ArgumentParser.Types.INTEGER, 10);  
        p.getArgumentGroup("Optional");
    }
    
    @Test(expected=InvalidArgumentException.class)
    public void testGetPositionalArgumentGroupThrowsException(){        
        p.addPositionalArgument("Argument Name", "Argument Description", ArgumentParser.Types.STRING);  
        p.getArgumentGroup("Argument Name");
    }
    
    @Test(expected=UnknownArgumentException.class)
    public void testGetUnknownArgumentGroupThrowsException(){        
        p.addPositionalArgument("Argument Name", "Argument Description", ArgumentParser.Types.STRING);  
        p.getArgumentGroup("wrong");
    }
    
    @Test(expected=UnknownArgumentException.class)
    public void testAddRestricteArgumentsToUnknownArgumentsThrowsException(){
        Object[] restrictedValues = {"cat", "dog"};
        
        p.addPositionalArgument("Argument Name", "Argument Description", ArgumentParser.Types.STRING);
        p.setRestrictedValues("wrong", restrictedValues);
    }
    
    @Test(expected=InvalidArgumentException.class)
    public void testGivingWrongRestrictedValuesTypeThrowsException(){
        Object[] restrictedValues = {2f, 4f, 6f};
        
        p.addPositionalArgument("Argument Name", "Argument Description", ArgumentParser.Types.INTEGER);
        p.setRestrictedValues("Argument Name", restrictedValues);
    }
    
    @Test(expected=InvalidArgumentException.class)
    public void testNotUsingRestrictedArgumentsThrowsException(){
        Object[] restrictedValues = {"cat", "dog"};
        
        p.addPositionalArgument("Argument Name", "Argument Description", ArgumentParser.Types.STRING);
        p.setRestrictedValues("Argument Name", restrictedValues);
                
        String[] args = {"wrong"};
        p.parse(args); 
    }
    
    @Test(expected=InvalidArgumentException.class)
    public void testNotUsingRestrictedFloatThrowsException(){
        Object[] restrictedValues = {2f, 4f, 6f};
        
        p.addPositionalArgument("Argument Name", "Argument Description", ArgumentParser.Types.FLOAT);
        p.setRestrictedValues("Argument Name", restrictedValues);
                
        String[] args = {"3f"};
        p.parse(args); 
    }
    
    @Test(expected=NotAllArgumentsUsedException.class)
    public void testRequiredArgumentsThrowExceptionWhenNotUsed(){
        p.addPositionalArgument("Argument Name", "Argument Description", ArgumentParser.Types.INTEGER);  
        p.addRequiredNamedArgument("Optional1", "Optional Argument Description 1", ArgumentParser.Types.INTEGER, 10);        
        p.addRequiredNamedArgument("Optional2", "Optional Argument Description 2", ArgumentParser.Types.INTEGER, 10);      
                
        String[] args = {"3", "--Optional1", "45"};
        p.parse(args);      
    }
    
    @Test(expected=MissingArgumentValueException.class)
    public void testOptionalArgumentAtEndOfTheListWithNoValueThrowsException(){
        p.addPositionalArgument("Length", "The length of the box", ArgumentParser.Types.INTEGER);
        p.addPositionalArgument("Width", "The width of the box", ArgumentParser.Types.INTEGER);
        p.addPositionalArgument("Height", "The height of the box", ArgumentParser.Types.INTEGER);
        
        p.addNamedArgument("Color", "The color of the box", ArgumentParser.Types.STRING, "white");
                
        String[] args = {"1", "2", "3", "--Color"};
        p.parse(args);
    }   
    
    @Test(expected=UnknownArgumentException.class)
    public void testUnknownOptionalArgumentThrowsException(){
        p.addPositionalArgument("Length", "The length of the box", ArgumentParser.Types.INTEGER);
        p.addPositionalArgument("Width", "The width of the box", ArgumentParser.Types.INTEGER);
        p.addPositionalArgument("Height", "The height of the box", ArgumentParser.Types.INTEGER);
        
        p.addNamedArgument("Color", "The color of the box", ArgumentParser.Types.STRING, "white");
                
        String[] args = {"1", "2", "3", "--Nice", "Nice"};
        p.parse(args);
    }
    
    @Test
    public void testGetValueOfIntegerReturnsInteger(){
        p.addPositionalArgument("Length", "The length", ArgumentParser.Types.INTEGER);
                
        String[] args = {"2"};
        p.parse(args);
        
        assertEquals("INTEGER", p.getArgumentTypeAsString("Length"));
        
        int length = p.getValueOf("Length");
        
        assertEquals(2, length);
    }
    
    @Test
    public void testGetValueOfStringReturnsString(){
        p.addPositionalArgument("Current Month", "The current month", ArgumentParser.Types.STRING);
                
        String[] args = {"January"};
        p.parse(args);
        
        assertEquals("STRING", p.getArgumentTypeAsString("Current Month"));
        
        String month = p.getValueOf("Current Month");
        
        assertEquals("January", month);
    }
    
    @Test
    public void testGetValueOfBooleanReturnsBoolean(){
        p.addPositionalArgument("Raining", "Whether or not it is raining", ArgumentParser.Types.BOOLEAN);
                
        String[] args = {"false"};
        p.parse(args);
        
        assertEquals("BOOLEAN", p.getArgumentTypeAsString("Raining"));
        
        boolean isRaining = p.getValueOf("Raining");
        
        assertEquals(false, isRaining);
    }
    
    @Test
    public void testGetValueOfFloatReturnsFloat(){
        p.addPositionalArgument("Precipitation", "The amount of precipitation in the last week", ArgumentParser.Types.FLOAT);
        String[] args = {"2.0f"};
        p.parse(args);
        assertEquals("FLOAT", p.getArgumentTypeAsString("Precipitation"));
        float precipiation = p.getValueOf("Precipitation");
        assertEquals(2.0f, precipiation, 0.1f);
    }
    
    @Test
    public void testSetOptionalFlagAtBeginning(){
        p.addNamedArgument("Raining", "Is it snowing?", ArgumentParser.Types.BOOLEAN, false);
        p.addPositionalArgument("Length", "The length of the box", ArgumentParser.Types.INTEGER);
        p.addPositionalArgument("Width", "The width of the box", ArgumentParser.Types.INTEGER);
        p.addPositionalArgument("Height", "The height of the box", ArgumentParser.Types.INTEGER);
        
        p.printProgramInformation();
        
        String[] args = {"--Raining", "1", "2" , "3"};
        p.parse(args);
        
        int length = p.getValueOf("Length");
        int width = p.getValueOf("Width");
        int height = p.getValueOf("Height");
        boolean value = p.getValueOf("Raining");
        
        assertEquals(1, length);
        assertEquals(2, width);
        assertEquals(3, height);
        assertEquals(true, value);
    }
    
    @Test
    public void testSetOptionalFlagAtEnd(){
        p.addNamedArgument("Raining", "Is it snowing?", ArgumentParser.Types.BOOLEAN, false);
        p.addPositionalArgument("Length", "The length of the box", ArgumentParser.Types.INTEGER);
        p.addPositionalArgument("Width", "The width of the box", ArgumentParser.Types.INTEGER);
        p.addPositionalArgument("Height", "The height of the box", ArgumentParser.Types.INTEGER);
        
        String[] args = {"1", "2" , "3", "--Raining"};
        p.parse(args);
        
        int length = p.getValueOf("Length");
        int width = p.getValueOf("Width");
        int height = p.getValueOf("Height");
        boolean value = p.getValueOf("Raining");
        
        assertEquals(1, length);
        assertEquals(2, width);
        assertEquals(3, height);
        assertEquals(true, value);
    }
    
    @Test
    public void testSetOptionalFlagInMiddle(){
        p.addNamedArgument("Raining", "Is it snowing?", ArgumentParser.Types.BOOLEAN, false);
        p.addPositionalArgument("Length", "The length of the box", ArgumentParser.Types.INTEGER);
        p.addPositionalArgument("Width", "The width of the box", ArgumentParser.Types.INTEGER);
        p.addPositionalArgument("Height", "The height of the box", ArgumentParser.Types.INTEGER);
        
        String[] args = {"1", "--Raining", "2" , "3"};
        p.parse(args);
        
        int length = p.getValueOf("Length");
        int width = p.getValueOf("Width");
        int height = p.getValueOf("Height");
        boolean value = p.getValueOf("Raining");
        
        assertEquals(1, length);
        assertEquals(2, width);
        assertEquals(3, height);
        assertEquals(true, value);
    }
    
    @Test
    public void testShorthandArgument(){
        p.addPositionalArgument("Length", "The length of the box", ArgumentParser.Types.INTEGER);
        p.addPositionalArgument("Width", "The width of the box", ArgumentParser.Types.INTEGER);
        p.addPositionalArgument("Height", "The height of the box", ArgumentParser.Types.INTEGER);
        p.addNamedArgument("Color", "C", "The color of the shape", ArgumentParser.Types.STRING, "None");
        
        String[] args = {"2", "3", "4", "-C", "red"};
        p.parse(args);
        
        assertEquals("red", p.getValueOf("Color"));
    }
    
    @Test
    public void testGetArgumentsFromFile(){
        XMLManager.loadArguments("testXML/testRead.xml", p);        
        
        p.printProgramInformation();
        
        assertEquals("Argument 1 description", p.getArgumentDescription("Argument1"));
        assertEquals(ArgumentParser.Types.INTEGER, p.getArgumentType("Argument1"));
        
        assertEquals("Optional Argument 1 description", p.getArgumentDescription("OptionalArgument1"));
        assertEquals(ArgumentParser.Types.STRING, p.getArgumentType("OptionalArgument1"));
        assertEquals("Value1", p.getDefaultValueOf("OptionalArgument1"));
        
        assertEquals("Optional Flag 1 description", p.getArgumentDescription("OptionalFlag1"));
        assertEquals(ArgumentParser.Types.BOOLEAN, p.getArgumentType("OptionalFlag1"));
        assertEquals(false, p.getDefaultValueOf("OptionalFlag1"));
        
    }
    
    @Test
    public void testWriteArgumentsToFile(){
        p.addPositionalArgument("Length", "The length of the shape", ArgumentParser.Types.STRING);
        p.addNamedArgument("Color", "C", "The color of the shape", ArgumentParser.Types.STRING, "red");
        p.addNamedArgument("Flag", "Is there a flag", ArgumentParser.Types.BOOLEAN, false);
        
        p.addArgumentToGroup("Color","Group 1");
        p.addArgumentToGroup("Flag", "Group 1");
        
        String[] args = {"3", "-C", "red"};
        p.parse(args);
        p.printProgramInformation();
        
        XMLManager.writeArguments("testXML/testWrite.xml", p);
        p = new ArgumentParser();
        XMLManager.loadArguments("testXML/testWrite.xml", p);
        
        assertEquals("The length of the shape", p.getArgumentDescription("Length"));
        assertEquals(ArgumentParser.Types.STRING, p.getArgumentType("Length"));
        
        assertEquals("The color of the shape", p.getArgumentDescription("Color"));
        assertEquals(ArgumentParser.Types.STRING, p.getArgumentType("Color"));
        assertEquals("red", p.getDefaultValueOf("Color"));
        assertEquals("Group 1", p.getArgumentGroup("Color"));
        
        assertEquals("Is there a flag", p.getArgumentDescription("Flag"));
        assertEquals(ArgumentParser.Types.BOOLEAN, p.getArgumentType("Flag"));
        assertEquals(false, p.getDefaultValueOf("Flag"));     
        assertEquals("Group 1", p.getArgumentGroup("Flag"));   
    }
    
    @Test
    public void testWriteRequiredArgumentsToFile(){
        p.addPositionalArgument("Length", "The length of the shape", ArgumentParser.Types.STRING);
        p.addNamedArgument("Color", "C", "The color of the shape", ArgumentParser.Types.STRING, "red");
        p.addRequiredNamedArgument("Required", "A required argument", ArgumentParser.Types.STRING, "HELLO");
        
        String[] args = {"3", "-C", "red", "--Required", "OLLEH"};
        p.parse(args);
        
        XMLManager.writeArguments("testXML/testWriteRequired.xml", p);
        p = new ArgumentParser();
        XMLManager.loadArguments("testXML/testWriteRequired.xml", p);
        
        assertEquals("The length of the shape", p.getArgumentDescription("Length"));
        assertEquals(ArgumentParser.Types.STRING, p.getArgumentType("Length"));
        
        assertEquals("The color of the shape", p.getArgumentDescription("Color"));
        assertEquals(ArgumentParser.Types.STRING, p.getArgumentType("Color"));
        assertEquals("red", p.getDefaultValueOf("Color"));
        
        assertEquals("A required argument", p.getArgumentDescription("Required"));
        assertEquals(ArgumentParser.Types.STRING, p.getArgumentType("Required"));
        assertEquals("HELLO", p.getDefaultValueOf("Required"));
    }
    
    @Test
    public void testWriteRestrictedValuesToFile(){
        Object[] restrictedValues1 = {10, 20, 30};
        Object[] restrictedValues2 = {10, 20, 30};
        
        p.addPositionalArgument("Argument", "Argument Description", ArgumentParser.Types.INTEGER);
        p.addNamedArgument("Named", "Named Description", ArgumentParser.Types.INTEGER, 10);
        p.setRestrictedValues("Argument", restrictedValues1);
        p.setRestrictedValues("Named", restrictedValues2);
        
        String[] args = {"10", "--Named", "20"};
        p.parse(args);
        
        XMLManager.writeArguments("testXML/testWriteRestricted.xml", p);
        
        p = new ArgumentParser();
        
        XMLManager.loadArguments("testXML/testWriteRestricted.xml", p);        
        
        p.parse(args);
        
        int intValue1 = p.getValueOf("Argument");
        int intValue2 = p.getValueOf("Named");
        
        p.printProgramInformation();
        
        assertEquals(10, intValue1);
        assertEquals(20, intValue2);
    }
    
    @Test(expected=UnknownArgumentException.class)
    public void testGetDescriptionOfUnknownArgumentThrowsException(){
        p.addPositionalArgument("Length", "The length of the box", ArgumentParser.Types.INTEGER);
        
        p.getArgumentDescription("Not length");
    }    
    
    @Test(expected=UnknownArgumentException.class)
    public void testGetTypeOfUnknownArgumentThrowsException(){     
        p.addPositionalArgument("Length", "The length of the box", ArgumentParser.Types.INTEGER);
        
        p.getArgumentType("Not length");
    }    
    
    @Test(expected=UnknownArgumentException.class)
    public void testGetTypeAsStringOfUnknownArgumentThrowsException(){
        p.addPositionalArgument("Length", "The length of the box", ArgumentParser.Types.INTEGER);
        
        p.getArgumentTypeAsString("Not length");
    }   
    
    @Test(expected=UnknownArgumentException.class)
    public void testGetValueOfUnknownArgumentThrowsException(){
        p.addPositionalArgument("Length", "The length of the box", ArgumentParser.Types.INTEGER);
        
        String[] args = {"7"};

        p.parse(args);
        p.getValueOf("8");      
    }
    
    @Test(expected=UnknownArgumentException.class)
    public void testGetDescriptionOfUnknownOptionalArgumentThrowsException(){
        p.addPositionalArgument("Length", "The length of the box", ArgumentParser.Types.INTEGER);
        p.addNamedArgument("Optional Argument", "Optional Argument Description", ArgumentParser.Types.INTEGER, 20);
        
        p.getArgumentDescription("Not optional argument");
    }    
    
    @Test(expected=UnknownArgumentException.class)
    public void testGetTypeOfUnknownOptionalArgumentThrowsException(){
        p.addPositionalArgument("Length", "The length of the box", ArgumentParser.Types.INTEGER);
        p.addNamedArgument("Optional Argument", "Optional Argument Description", ArgumentParser.Types.INTEGER, 20);
        
        p.getArgumentType("Not optional argument");
    }    
    
    @Test(expected=UnknownArgumentException.class)
    public void testGetTypeAsStringOfUnknownOptionalArgumentThrowsException(){
        p.addPositionalArgument("Length", "The length of the box", ArgumentParser.Types.INTEGER);
        p.addNamedArgument("Optional Argument", "Optional Argument Description", ArgumentParser.Types.INTEGER, 20);
        
        p.getArgumentTypeAsString("Not optional argument");
    }   
    
    @Test(expected=UnknownArgumentException.class)
    public void testGetValueOfUnknownOptionalArgumentThrowsException(){
        p.addPositionalArgument("Length", "The length of the box", ArgumentParser.Types.INTEGER);
        p.addNamedArgument("Optional Argument", "Optional Argument Description", ArgumentParser.Types.INTEGER, 20);

        p.getValueOf("Not optional argument");
    }   
    
    @Test(expected=InvalidArgumentException.class)
    public void testSendInvalidOptionalArgumentDefaultValueThrowsException(){
        p.addPositionalArgument("Length", "The length of the box", ArgumentParser.Types.INTEGER);
        p.addNamedArgument("Optional Argument", "Optional Argument Description", ArgumentParser.Types.INTEGER, "bad");        
    }
    
    @Test(expected=InvalidArgumentException.class)
    public void testSendInvalidArgumentThrowsException(){
        p.addPositionalArgument("Length", "The length of the box", ArgumentParser.Types.INTEGER);
        
        String[] args = {"nice"};

        p.parse(args);  
    }
    
    @Test(expected = NotEnoughArgumentsException.class)
    public void testNotEnoughArgumentsThrowsException(){
        p.addPositionalArgument("Length", "The length of the box", ArgumentParser.Types.INTEGER);
        p.addPositionalArgument("Width", "The width of the box", ArgumentParser.Types.INTEGER);
        
        String[] args = {"7"};
        p.parse(args);
    }
    
    @Test(expected = TooManyArgumentsException.class)
    public void testTooManyArgumentsThrowsException(){
        p.addPositionalArgument("Length", "The length of the box", ArgumentParser.Types.INTEGER);
        p.addPositionalArgument("Width", "The width of the box", ArgumentParser.Types.INTEGER);
        
        String[] args = {"7", "4", "8"};
        p.parse(args);
    }
    
    @Test(expected = UnknownArgumentException.class)
    public void testGetDefaultValueOfArgumentDoesNotExistsThrowsException(){
        p.addNamedArgument("Optional", "Optional argument description", ArgumentParser.Types.STRING, "Default");
        
        p.printProgramInformation();
        
        p.getDefaultValueOf("Optional Argument");
    }
    
    @Test(expected = InvalidArgumentException.class)
    public void testGetDefaultValueOfPositionalArgumentInvalidThrowsException(){
        p.addPositionalArgument("Pos", "Description", ArgumentParser.Types.STRING);
        
        p.getDefaultValueOf("Pos");
    }
    
    @Test(expected = InvalidArgumentException.class)
    public void testGetNumberRestrictedValuesOfNonRestrictedPositionalArgumentThrowsException(){
        p.addPositionalArgument("test", "test", ArgumentParser.Types.STRING);
        
        p.getNumberOfRestrictedArguments("test");
    }
    
    @Test(expected = InvalidArgumentException.class)
    public void testGetNumberRestrictedValuesOfNonRestrictedNamedArgumentThrowsException(){
        p.addNamedArgument("test", "test", ArgumentParser.Types.STRING, "test");
        
        p.getNumberOfRestrictedArguments("test");
    }
    
    @Test(expected = UnknownArgumentException.class)
    public void testGetNumberRestrictedValuesOfUnknownArgumentThrowsException(){
        p.getNumberOfRestrictedArguments("test");        
    }
    
    @Test(expected = UnknownArgumentException.class)
    public void testGetRestrictedValuesOfUnknownArgumentThrowsException(){
        p.getAllRestrictedValues("test");
    }
    
    @Test(expected = UnknownArgumentException.class)
    public void testGetRestrictedValueOfUnknownArgumentThrowsException(){
        p.getRestrictedValue("test", 0);
    }
    
    @Test(expected = ArgumentAlreadyInGroupException.class)
    public void testAddArgumentAlreadyInGroupThrowsException(){
        p.addNamedArgument("test", "test", ArgumentParser.Types.STRING, "test");
        p.addArgumentToGroup("test", "test group");
        p.addArgumentToGroup("test", "test group");
    }
    
    @Test(expected = InvalidArgumentException.class)
    public void testGetRestrictedValueOfNonRestrictedPositionalArgumentThrowsException(){        
        p.addPositionalArgument("test", "test", ArgumentParser.Types.STRING);
        p.getRestrictedValue("test", 0);
    }
    
    @Test(expected = InvalidArgumentException.class)
    public void testGetRestrictedValueOfNonRestrictedNamedArgumentThrowsException(){        
        p.addNamedArgument("test", "test", ArgumentParser.Types.STRING, "test");
        p.getRestrictedValue("test", 0);
    }
    
    @Test(expected = InvalidArgumentException.class)
    public void testGetAllRestrictedValuesOfNonRestrictedPositionalArgumentThrowsException(){        
        p.addPositionalArgument("test", "test", ArgumentParser.Types.STRING);
        p.getAllRestrictedValues("test");
    }
    
    @Test(expected = InvalidArgumentException.class)
    public void testGetAllRestrictedValuesOfNonRestrictedNamedArgumentThrowsException(){        
        p.addNamedArgument("test", "test", ArgumentParser.Types.STRING, "test");
        p.getAllRestrictedValues("test");
    }
}