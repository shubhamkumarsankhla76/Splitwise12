package com.example.Splitwise12.repositories;

import com.example.Splitwise12.modles.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @NotNull User save(@NotNull User user);

    User findById(int userId);
}