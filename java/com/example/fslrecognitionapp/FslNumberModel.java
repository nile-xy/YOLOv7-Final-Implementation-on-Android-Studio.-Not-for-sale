package com.example.fslrecognitionapp;

public class FslNumberModel {
    private String fslNumber;
    private int imageResource;
    private String tagalogNumber;
    private String definitionNumber;

    public FslNumberModel(String fslNumber, int imageResource, String tagalogNumber, String definitionNumber){
        this.fslNumber = fslNumber;
        this.imageResource = imageResource;
        this.tagalogNumber = tagalogNumber;
        this.definitionNumber = definitionNumber;
    }

    public String getFslNumber(){
        return fslNumber;
    }

    public int getImageResource(){
        return imageResource;
    }

    public String getTagalogNumber(){ return tagalogNumber; }

    public String getDefinitionNumber(){return definitionNumber; }
}
