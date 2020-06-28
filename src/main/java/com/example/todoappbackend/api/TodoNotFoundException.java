package com.example.todoappbackend.api;

public class TodoNotFoundException extends RuntimeException{

    public TodoNotFoundException(Integer id){
        super("Could not find " + id);
    }
}
