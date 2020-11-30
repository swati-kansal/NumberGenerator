package com.example.numgeneratar.reprository;

import com.example.numgeneratar.model.BulkTask;
import com.example.numgeneratar.model.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {
}
