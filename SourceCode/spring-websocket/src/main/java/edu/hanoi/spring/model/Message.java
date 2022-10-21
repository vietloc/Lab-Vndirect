package edu.hanoi.spring.model;

public class Message {
    public String content;


    public Message() {
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Message(String content){
        this.content=content;
    }

    public String getContent(){
        return content;
    }
}
