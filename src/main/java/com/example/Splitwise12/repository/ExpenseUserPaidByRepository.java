package com.example.Splitwise12.repository;

import com.example.Splitwise12.modles.ExpenseUserPaidBy;
import com.example.Splitwise12.modles.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseUserPaidByRepository extends JpaRepository<ExpenseUserPaidBy, Integer> {
    List<ExpenseUserPaidBy> findAllByUser(User user);
}