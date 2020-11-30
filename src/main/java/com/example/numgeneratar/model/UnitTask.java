package com.example.numgeneratar.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;
@Entity
@Table(name = "unit_task")
@EntityListeners(AuditingEntityListener.class)
public class UnitTask  extends Task{

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    @OneToOne
    Operation operation;

}
