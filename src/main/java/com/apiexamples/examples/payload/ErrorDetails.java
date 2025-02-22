package com.apiexamples.examples.payload;

import java.util.Date;

public class ErrorDetails {
    private String message;
    private Date date;

    public void setMessage(String message) {
        this.message = message;
    }
    public String getMessage(){
        return message;}

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ErrorDetails(String message, Date date){
        this.message = message;
        this.date= date;


    }
}
