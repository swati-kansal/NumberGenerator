package com.example.numgeneratar.responses;

public class ResultMessage {

    public ResultMessage(String result){
        this.result = result;
    }
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    String result;
}
