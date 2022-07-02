package com.example.lyrichord.Models;

public class Guitar implements ItemGetter {
    private String title;
    private String author;
    private String text;
    private static final String INSTRUMENT = "Guitar";
    private String type;

    public Guitar(){
    }

    public Guitar(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public Guitar(String title, String author, String text) {
        this.title = title;
        this.author = author;
        this.text = text;
    }

    public Guitar(String title, String author, String text, String type) {
        this.title = title;
        this.author = author;
        this.text = text;
        this.type = type;
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
        return INSTRUMENT;
    }

    @Override
    public String getType() {
        return type;
    }
}
