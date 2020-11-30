package com.example.numgeneratar.responses;

import org.springframework.stereotype.Component;

import java.util.UUID;
@Component
public class TaskResponse {

    public TaskResponse(UUID uuid){
        this.uuid = uuid;
    }

    public TaskResponse(){

    }
    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    UUID uuid;

}
