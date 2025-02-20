package com.example.Splitwise12.modles;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Transaction extends BaseModel{
    private int paid;
    private int owed;
    private double amount;
}