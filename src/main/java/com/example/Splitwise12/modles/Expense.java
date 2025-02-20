package com.example.Splitwise12.modles;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Expense extends BaseModel{
    private double amount;
    private Date dateOfExpense;
    private String description;
    private ExpenseStatus status;

    private List<ExpenseUserPaidBy> paidBy;
    private List<ExpenseUserOwedBy> owedBy;
}