package edu.jsu.mcis;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import edu.jsu.mcis.ArgumentParser.Types;

public class FileReader{
    private static final String ARGUMENT = "argument";
    private static final String OPTIONAL = "optional";
    private static final String NAME = "name";
    private static final String DESCRIPTION = "description";
    private static final String TYPE = "type";
    private static final String DEFAULT = "default";
    private static final String FLAG = "flag";
    private enum ArgumentType {POSITIONALARGUMENT, OPTIONALARGUMENT};
    
    public void readArguments(Sting fileName, List<String> argumentNames, 
        List<String> optionalArgumentNames, 
        Map<String, ArgumentInformation> argumentMap,
        Map<String, OptionalArgumentInformation> optionalArgumentMap){
            try{
                XMLInputFactory inputFactory = XMLInputFactory.newInstance();
                InputStream in = new FileInputStream(configFile);
                XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
                
                while(eventReader.hasNext()){
                    XMLEvent event = eventReader.nextEvent();
                    ArgumentInformation arg;
                    OptionalArgumentInformation optArg;
                    
                    String name = "";
                    String description = "";
                    Types type = null;
                    String value = "";
                    ArgumentType argType = null;
                    
                    if (event.isStartElement()) {
                        StartElement startElement = event.asStartElement();
                        if (startElement.getName().getLocalPart().equals(ARGUMENT)) {
                            argType = POSITIONALARGUMENT;
                        }
                        if (startElement.getName().getLocalPart().equals(OPTIONAL)) {
                            argType = OPTIONALARGUMENT;
                        }
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
                            name = event.asCharacters().getData();
                            continue;
                        }
                        if (startElement.getName().getLocalPart().equals(DEFAULT)) {
                            event = eventReader.nextEvent();
                            value = event.asCharacters().getData();
                            continue;
                        }
                        if (startElement.getName().getLocalPart().equals(FLAG)) {}
                    }
                    if (event.isEndElement()) {
                        EndElement endElement = event.asEndElement();
                        if (endElement.getName().getLocalPart().equals(ARGUMENT)) {
                            argumentNames.add(name);
                            argumentMap.put(name, new ArgumentInformation(description, type));
                        }
                        if (endElement.getName().getLocalPart().equals(OPTIONAL)) {
                            optionalArgumentNames.add(name);
                            optionalArgumentMap.put(name, new ArgumentInformation(description, type, value));
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