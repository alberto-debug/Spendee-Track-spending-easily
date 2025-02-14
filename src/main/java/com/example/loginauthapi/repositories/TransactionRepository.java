package com.example.loginauthapi.repositories;

import com.example.loginauthapi.domain.user.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Long, Transaction> {


}
