package com.example.numgeneratar.reprository;

import com.example.numgeneratar.model.UnitTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UnitTaskRepository extends JpaRepository<UnitTask, UUID> {
}
