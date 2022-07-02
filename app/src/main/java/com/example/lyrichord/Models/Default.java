package com.example.lyrichord.Models;

public class Default implements ItemGetter {
    private String title;
    private String author;
    private String text;
    private String type;

    public Default(){

    }

    public Default(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public Default(String title, String author, String text) {
        this.title = title;
        this.author = author;
        this.text = text;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public String getText() {
        return text;
    }

    public String getInstrument() {
        return "N/A";
    }

    @Override
    public String getType() {
        return type;
    }
}
