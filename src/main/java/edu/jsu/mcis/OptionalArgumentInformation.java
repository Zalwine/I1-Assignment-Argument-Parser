package edu.jsu.mcis;

import edu.jsu.mcis.ArgumentParser.Types;

public class OptionalArgumentInformation extends ArgumentInformation{
    private boolean isFlagged;
    
    public OptionalArgumentInformation(String description, Types type, Object defaultValue){
        super(description, type);
        setValue(defaultValue + "");
    }
    
    public void setFlagStatus(boolean bool){
        isFlagged = bool;
    }
    
    public boolean getFlagStatus(){
        return isFlagged;
    }
}