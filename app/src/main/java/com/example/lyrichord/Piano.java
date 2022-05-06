package com.example.lyrichord;

public class Piano implements Item {
    private String title;
    private String author;
    private String text;
    private static final String INSTRUMENT = "Piano";
    private String type;


    public Piano(){
    }

    public Piano(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public Piano(String title, String author, String text) {
        this.title = title;
        this.author = author;
        this.text = text;
    }

    public Piano(String title, String author, String text, String type) {
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

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

}
