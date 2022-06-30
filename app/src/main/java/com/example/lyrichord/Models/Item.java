package com.example.lyrichord.Models;

public interface Item {
    abstract public void setTitle(String title) ;

    abstract public void setAuthor(String author);

    abstract public void setText(String text);

    abstract public void setType(String type);

    abstract public String getTitle();

    abstract public String getAuthor();

    abstract public String getText();

    abstract public String getInstrument();

    abstract public String getType();

}
