package com.example.Splitwise12.repository;

import com.example.Splitwise12.modles.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Integer> {

    Group findById(int groupId);
}