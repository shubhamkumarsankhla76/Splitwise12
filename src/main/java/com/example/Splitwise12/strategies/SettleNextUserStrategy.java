package com.example.Splitwise12.strategies;

import com.example.Splitwise12.modles.Expense;
import com.example.Splitwise12.modles.Transaction;

import java.util.List;

public class SettleNextUserStrategy implements SettleUpStrategy{
    @Override
    public List<Transaction> settle(List<Expense> expenses) {
        return null;
    }
}