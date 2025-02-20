package com.example.Splitwise12.modles;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class ExpenseUserOwedBy  extends BaseModel{
    private Expense expense;
    private User user;
    private double amount;
}