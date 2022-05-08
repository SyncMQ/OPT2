package com.example.lyrichord;

public class Data {
    private String title;
    private String author;
    private String text;
    private String instrument;
    private String type;

    public Data(){
    }

    public Data(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public Data(String title, String author, String text) {
        this.title = title;
        this.author = author;
        this.text = text;
    }

    public Data(String title, String author, String text, String type) {
        this.title = title;
        this.author = author;
        this.text = text;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }

    public String getInstrument() {
        return instrument;
    }

    public String getType() {
        return type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String toString(){
        if (!instrument.equals("N/A") && type.equals("None")) {
            return title + " by " + author + "[" + instrument + "]";
        } else if (!instrument.equals("N/A") && author == null){
            return title + "[" + instrument + "]" + "[" + type + "]";
        } else if (instrument.equals("N/A")) {
            return title + " by " +  author;
        }
        return title + " by " + author + "[" + instrument + "]" + "[" + type + "]";
    }
}
