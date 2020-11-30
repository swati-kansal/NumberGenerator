package com.example.numgeneratar;

import com.example.numgeneratar.model.Operation;
import com.example.numgeneratar.responses.TaskResponse;
import javafx.application.Application;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = NumberGeneratarApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class NumberGeneratarApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port;
    }

    @Test
    public void testGenerate() {
        Operation operation = new Operation();
        operation.setGoal(10);
        operation.setStep(2);

        ResponseEntity<TaskResponse> postResponse = restTemplate.postForEntity(getRootUrl() + "/api/generate", operation, TaskResponse.class);
        Assert.assertEquals(postResponse.getStatusCode(), HttpStatus.ACCEPTED);
        Assert.assertNotNull(postResponse);
    }
    @Test
    void contextLoads() {
    }

}
