package com.example.numgeneratar.model;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Collection;
@Entity
@Table(name = "operation")
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public int getGoal() {
        return goal;
    }

    @Column(nullable = false)
    private int goal;

    @Column(nullable = false)
    private int step;

    @ElementCollection
    private Collection<Integer> nums;

    public Collection<Integer> getNums() {
        return nums;
    }

    public void setNums(Collection<Integer> nums) {
        this.nums = nums;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

}
