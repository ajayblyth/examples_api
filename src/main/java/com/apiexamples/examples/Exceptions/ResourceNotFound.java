package com.apiexamples.examples.Exceptions;

public class ResourceNotFound  extends  RuntimeException{
    public ResourceNotFound(String message){
        super(message);
    }
}
