package com.example.fslrecognitionapp;

public class FslPhrasesModel {
    private String fslPhrases;
    private int videoResource;
    private String fslTagalogPhrase;
    private String category;

    public FslPhrasesModel(String fslPhrase, int videoResource, String fslTagalogPhrase, String category) {
        this.fslPhrases = fslPhrase;
        this.videoResource = videoResource;
        this.fslTagalogPhrase = fslTagalogPhrase;
        this.category = category;
    }

    public String getFslPhrase() {
        return fslPhrases;
    }

    public int getVideoResource() {
        return videoResource;
    }

    public String getFslTagalogPhrase(){ return fslTagalogPhrase; }

    public String getCategory(){ return category; }

}
