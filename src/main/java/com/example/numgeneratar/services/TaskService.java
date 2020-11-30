package com.example.numgeneratar.services;

import com.example.numgeneratar.model.BulkTask;
import com.example.numgeneratar.model.Operation;
import com.example.numgeneratar.model.Status;
import com.example.numgeneratar.model.UnitTask;
import com.example.numgeneratar.reprository.BulkTaskRepository;
import com.example.numgeneratar.reprository.OperationRepository;
import com.example.numgeneratar.reprository.UnitTaskRepository;
import com.example.numgeneratar.responses.TaskResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TaskService {
    @Autowired
    UnitTaskRepository unitTaskRepository;
    @Autowired
    OperationRepository operationRepository;
    @Autowired
    BulkTaskRepository bulkTaskRepository;
    public TaskResponse generateNumber(Operation operation) {
        //TODO Move logic to thread
        UnitTask task = new UnitTask();
        task.setUUID(UUID.randomUUID());
        task.setOperation(operation);
        List<Integer> nums = new ArrayList<>();
        for (int i = operation.getGoal(); i > 0; i = i - operation.getStep()) {
            nums.add(i);
        }
        task.getOperation().setNums(nums);
        operationRepository.save(task.getOperation());
        task.setStatus(Status.Success);
        unitTaskRepository.save(task);
        return new TaskResponse(task.getUUID());
    }

    public TaskResponse bulkGenerate(Operation[] operations) {
        //todo move logic into thread
        BulkTask task = new BulkTask();
        task.setUUID(UUID.randomUUID());
        List<Operation> operationList = new ArrayList<>();
        for(Operation operation : operations) {
            List<Integer> nums = new ArrayList<>();
            for (int i = operation.getGoal(); i > 0; i = i - operation.getStep()) {
                nums.add(i);
            }
            operation.setNums(nums);
            operationRepository.save(operation);
            operationList.add(operation);
        }
        task.setStatus(Status.Success);
        task.setOperations(operationList);
        bulkTaskRepository.save(task);
        return new TaskResponse(task.getUUID());
    }
}
