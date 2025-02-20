package com.example.Splitwise12.repository;

import com.example.Splitwise12.modles.ExpenseUserOwedBy;
import com.example.Splitwise12.modles.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseUserOwedByRepository extends JpaRepository<ExpenseUserOwedByRepository, Integer> {

    List<ExpenseUserOwedBy> findAllByUser(User user);
}