package com.example.fslrecognitionapp;

public class FSLWordsModel {
    private String fslWord;
    private int videoResource;  // Change the data type to int for video resource ID
    private String tagalogWord;
    private String description;
    private String example;

    public FSLWordsModel(String fslWord, int videoResource, String tagalogWord, String description, String example) {
        this.fslWord = fslWord;
        this.videoResource = videoResource;
        this.tagalogWord = tagalogWord;
        this.description = description;
        this.example = example;
    }

    public String getFslWord() {
        return fslWord;
    }

    public int getVideoResource() {
        return videoResource;
    }

    public String getTagalogWord(){
        return tagalogWord;
    }

    public String getDescription(){
        return description;
    }

    public String getExample(){
        return example;
    }
}
