package com.example.numgeneratar.validators;

import com.example.numgeneratar.model.BulkTask;
import com.example.numgeneratar.model.Operation;
import com.example.numgeneratar.model.UnitTask;
import org.springframework.stereotype.Component;

@Component
public class InputValidator {

    public boolean isStepValid(UnitTask task) {
        return validateOperation(task.getOperation());
    }
    public boolean isStepValid(BulkTask task) {
        for(Operation operation : task.getOperations()){
            if(validateOperation(operation)){
                return false;
            }
        }
        return true;
    }

    public boolean validateOperation(Operation operation){
        return operation.getStep() <= operation.getGoal() && operation.getStep() >= 0;
    }
}
