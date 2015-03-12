package edu.jsu.mcis;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import edu.jsu.mcis.ArgumentParser.Types;

public class XMLManager{
    private static final String ARGUMENT = "argument";
    private static final String OPTIONAL = "optional";
    private static final String NAME = "name";
    private static final String DESCRIPTION = "description";
    private static final String TYPE = "type";
    private static final String DEFAULT = "default";
    private static final String FLAG = "flag";
    
    public void loadArguments(String fileName, ArgumentParser p){
        try{
            ClassLoader classLoader = getClass().getClassLoader();
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            InputStream in = new FileInputStream(classLoader.getResource(fileName).getFile());
            XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
                
            String name = "";
            String description = "";
            Types type = Types.valueOf("STRING");
            String value = "";
                
            System.out.println("\n");
            
            while(eventReader.hasNext()){
                XMLEvent event = eventReader.nextEvent();
                ArgumentInformation arg;
                OptionalArgumentInformation optArg;
                
                if (event.isStartElement()) {
                    StartElement startElement = event.asStartElement();
                    if (startElement.getName().getLocalPart().equals(NAME)) {
                        event = eventReader.nextEvent();
                        name = event.asCharacters().getData();
                        continue;
                    }
                    if (startElement.getName().getLocalPart().equals(DESCRIPTION)) {
                        event = eventReader.nextEvent();
                        description = event.asCharacters().getData();
                        continue;
                    }
                    if (startElement.getName().getLocalPart().equals(TYPE)) {
                        event = eventReader.nextEvent();
                        type = Types.valueOf(event.asCharacters().getData());
                        continue;
                    }
                    if (startElement.getName().getLocalPart().equals(DEFAULT)) {
                        event = eventReader.nextEvent();
                        value = event.asCharacters().getData();
                        continue;
                    }
                    //should be removed when we get rid of the flag definition
                    if (startElement.getName().getLocalPart().equals(FLAG)) {}
                }
                if (event.isEndElement()) {
                    EndElement endElement = event.asEndElement();
                    if (endElement.getName().getLocalPart().equals(ARGUMENT)) {
                        p.addArgument(name, description, type);
                        
                        name = "";
                        description = "";
                        type = Types.valueOf("STRING");
                        value = "";
                    }
                    if (endElement.getName().getLocalPart().equals(OPTIONAL)) {
                        p.addOptionalArgument(name, description, type, value);
                        
                        name = "";
                        description = "";
                        type = Types.valueOf("STRING");
                        value = "";
                    }
                }
            }
            
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(XMLStreamException e){
            e.printStackTrace();
        }
        
    }
}