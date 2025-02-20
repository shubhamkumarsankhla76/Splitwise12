package com.example.Splitwise12.services;

import com.example.Splitwise12.modles.*;
import com.example.Splitwise12.repositories.UserRepository;
import com.example.Splitwise12.repository.ExpenseRepository;
import com.example.Splitwise12.repository.ExpenseUserOwedByRepository;
import com.example.Splitwise12.repository.ExpenseUserPaidByRepository;
import com.example.Splitwise12.repository.GroupRepository;
import com.example.Splitwise12.strategies.SettleUpStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SettleUpService {

    private UserRepository userRepository;
    private ExpenseUserPaidByRepository expenseUserPaidByRepository;
    private ExpenseUserOwedByRepository expenseUserOwedByRepository;
    private ExpenseRepository expenseRepository;

    private GroupRepository groupRepository;

    private SettleUpStrategy settleUpStrategy;

    public SettleUpService(UserRepository userRepository, ExpenseUserPaidByRepository expenseUserPaidByRepository, ExpenseUserOwedByRepository expenseUserOwedByRepository, ExpenseRepository expenseRepository, GroupRepository groupRepository, SettleUpStrategy settleUpStrategy) {
        this.userRepository = userRepository;
        this.expenseUserPaidByRepository = expenseUserPaidByRepository;
        this.expenseUserOwedByRepository = expenseUserOwedByRepository;
        this.expenseRepository = expenseRepository;
        this.groupRepository = groupRepository;
        this.settleUpStrategy = settleUpStrategy;
    }

    public List<Transaction> settleUser(int userId){
        // Opt 1: Just fetch lists of EUPB and EUOB,
        // using these 2 lists figure out all the transactions

        // Opt 2: Just fetch lists of EUPB and EUOB, now using these lists, find all the list
        // of expense objects and give the list of expense objects to the settleUpStrategy
        User user = this.userRepository.findById(userId);

        List<ExpenseUserOwedBy> expenseUserOwedByList = this.expenseUserOwedByRepository.findAllByUser(user);
        List<ExpenseUserPaidBy> expenseUserPaidByList = this.expenseUserPaidByRepository.findAllByUser(user);


        HashSet<Integer> expenseIdSet = new HashSet<>();

        for (ExpenseUserPaidBy expenseUserPaidBy : expenseUserPaidByList) {
            expenseIdSet.add(expenseUserPaidBy.getExpense().getId());
        }

        for (ExpenseUserOwedBy expenseUserOwedBy: expenseUserOwedByList){
            expenseIdSet.add(expenseUserOwedBy.getExpense().getId());
        }

        List<Integer> expenseIds = new ArrayList<>(expenseIdSet);

        // Using this list, I will fetch expenses object from DB
        // Then I will give this list of expense objects to the settleUpStrategy
        List<Expense> expenses = this.expenseRepository.findByIdIn(expenseIds);

        return settleUpStrategy.settle(expenses);
    }

    public List<Transaction> settleGroup(int groupId){
        Group group = this.groupRepository.findById(groupId);

        return this.settleUpStrategy.settle(group.getExpenses());
    }
}