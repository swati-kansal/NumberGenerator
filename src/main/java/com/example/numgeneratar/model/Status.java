package com.example.numgeneratar.model;

public enum Status {
    Success("Success"),
    InProgress("IN_PROGRESS"),
    Error("Error");

    String message;
    Status(String message){
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}
