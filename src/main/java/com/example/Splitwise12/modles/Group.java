package com.example.Splitwise12.modles;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Group extends BaseModel{
    private String name;
    private List<Expense> expenses;
    private List<User> users;
    private List<User> admins;
    private List<Transaction> transactions;
}