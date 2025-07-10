package com.example.handlingformsubmission;

//Primary class greeting with class fields
public class Greeting {
    private long id;
    private String content;
    private String date;

    //Getter and setter for ID#
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }

    //Getter and setter for content
    public String getContent() {
        return this.content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return this.date;
    }
}
