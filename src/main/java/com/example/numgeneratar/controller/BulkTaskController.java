package com.example.numgeneratar.controller;

import com.example.numgeneratar.exception.InvalidRequestException;
import com.example.numgeneratar.exception.ResourceNotFoundException;
import com.example.numgeneratar.model.BulkTask;
import com.example.numgeneratar.model.Operation;
import com.example.numgeneratar.model.UnitTask;
import com.example.numgeneratar.reprository.BulkTaskRepository;
import com.example.numgeneratar.reprository.UnitTaskRepository;
import com.example.numgeneratar.responses.ResultMessage;
import com.example.numgeneratar.responses.TaskResponse;
import com.example.numgeneratar.services.TaskService;
import com.example.numgeneratar.validators.InputValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class BulkTaskController {
    @Autowired
    BulkTaskRepository taskRepository;
    @Autowired
    TaskService taskService;
    @Autowired
    InputValidator inputValidator;
    @PostMapping("/bulk/Generate")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public TaskResponse createTask(@Valid @RequestBody Operation[] operations) throws InvalidRequestException
    {
        for(Operation operation : operations){
        if(!inputValidator.validateOperation(operation)){
            throw new InvalidRequestException("Invalid Request"+operation.getStep());
        }
        }
        return taskService.bulkGenerate(operations);
    }
    @GetMapping("/bulk/tasks/{UUID}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public ResultMessage getNumberListByUUID(@RequestParam String action, @PathVariable(value = "UUID") UUID uuid)
            throws ResourceNotFoundException {
        if(action.equalsIgnoreCase("get_numlist")) {
            List<String> messages = new ArrayList<>();
            BulkTask task = taskRepository
                    .findById(uuid)
                    .orElseThrow(() -> new ResourceNotFoundException("Task not found on :: " + uuid));
            for(Operation operation : task.getOperations()){
                messages.add(operation.getNums().stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(",")));
            }

            return new ResultMessage(String.join(System.lineSeparator(),messages));
        }else{
            throw new ResourceNotFoundException("Invalid Action");
        }
    }
}
