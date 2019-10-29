package com.example.eventbustest;

public class MessageEvent {

    private String messageString;

    public MessageEvent(String messageString){
        this.messageString = messageString;
    }

    public String getMessageString(){
        return messageString;
    }

}
