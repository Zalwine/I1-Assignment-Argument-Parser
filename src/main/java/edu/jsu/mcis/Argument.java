package edu.jsu.mcis;

import edu.jsu.mcis.ArgumentParser.Types;
import java.lang.*;

public class Argument{
    private String description;
    private Types type;
    private Object value;
    private boolean hasRestrictedValues;
    private Object[] restrictedValues;
    private int numOfValues;
    
    public Argument(String description, Types type){
        this.description = description;
        restrictedValues = new Object[0];
        hasRestrictedValues = false;
        this.type = type;
    }
    
    public void setValue(String value) throws InvalidArgumentException{
        Object holdValue;
        
        try{
            switch(type){
                case INTEGER:
                    holdValue = Integer.parseInt(value);
                    break;
                case FLOAT:
                    holdValue = Float.parseFloat(value);
                    break;
                case BOOLEAN:
                    holdValue = Boolean.parseBoolean(value);
                    break;
                default:
                    holdValue = value;
                    break;
            }
        }catch(IllegalArgumentException ex){
            throw new InvalidArgumentException("\n\nInvalid argument \"" + value + "\"\n");
        }   
        
        if(hasRestrictedValues){
            boolean foundValue = false;
            int i = 0;
            while(i < restrictedValues.length && !foundValue){
                if(holdValue == restrictedValues[i]){
                    foundValue = true;
                }else if(type == ArgumentParser.Types.FLOAT){
                    if(Float.compare((float)holdValue, (float)restrictedValues[i]) == 0){
                        foundValue = true;
                    }
                }else if(type == ArgumentParser.Types.STRING){
                    if(holdValue.equals(restrictedValues[i])){
                        foundValue = true;                        
                    }
                }
                i++;
            }
            if(!foundValue){
                throw new InvalidArgumentException("\n\nDid not use restricted value\n");
            }
        }
        this.value = holdValue;
    }
    
    public Object getValue(){
        return value;
    }
    
    public String getDescription(){
        return description;
    }
    
    public Types getType(){
        return type;
    }
    
    public String getTypeAsString(){            
        switch(type){
            case INTEGER:
                return "INTEGER";
            case FLOAT:
                return "FLOAT";
            case BOOLEAN:
                return "BOOLEAN";
            default:
                return "STRING";
        }
    }
    
    public void setRestrictedValues(Object[] values){
        restrictedValues = new Object[values.length];
        numOfValues = 0;
        for(int i = 0; i < values.length; i++){
            try{
                switch(type){
                    case INTEGER:
                        restrictedValues[i] = Integer.parseInt(values[i] + "");
                        break;
                    case FLOAT:
                        restrictedValues[i] = Float.parseFloat(values[i] + "");
                        break;
                    default:
                        restrictedValues[i] = values[i];
                        break;
                }
                numOfValues++;
            }catch(IllegalArgumentException ex){
                throw new InvalidArgumentException("\n\nInvalid argument \"" + value + "\"\n");
            }   
        }
        hasRestrictedValues = true;
    }
    
    public boolean containsRestrictedValues(){
        return hasRestrictedValues;
    }
    
    public Object[] getRestrictedValues(){
        return restrictedValues;
    }
    
    public Object getRestrictedObject(int i){
        return restrictedValues[i];
    }
    
    public int numOfRestrictedValues(){
        return numOfValues;
    }
}