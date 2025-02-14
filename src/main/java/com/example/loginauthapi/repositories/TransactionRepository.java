package com.example.loginauthapi.repositories;

import com.example.loginauthapi.domain.user.Transaction;
import com.example.loginauthapi.domain.user.TransactionType;
import com.example.loginauthapi.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByUser(User user);
    List<Transaction> findByTypeAndUser(TransactionType type, User user);

}
