package com.example.lyrichord.FactoryMethod;

import com.example.lyrichord.FactoryMethod.Item;

public class Default implements Item {
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
