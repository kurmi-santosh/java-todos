package com.kurmi.todos.others;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message){
        super(message);
    }
}
