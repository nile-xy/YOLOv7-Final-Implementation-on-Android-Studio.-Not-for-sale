package com.example.fslrecognitionapp;


public class FslAlphabetModel {
    private String fslAlphabet;
    private int imageResource;

    public FslAlphabetModel(String fslAlphabet, int imageResource){
        this.fslAlphabet = fslAlphabet;
        this.imageResource = imageResource;
    }

    public String getFslAlphabet(){
        return fslAlphabet;
    }

    public int getImageResource(){
        return imageResource;
    }
}
