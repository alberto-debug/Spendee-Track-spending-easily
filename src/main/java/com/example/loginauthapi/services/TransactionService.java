package com.example.loginauthapi.services;

import com.example.loginauthapi.domain.user.Transaction;
import com.example.loginauthapi.domain.user.TransactionType;
import com.example.loginauthapi.domain.user.User;
import com.example.loginauthapi.repositories.TransactionRepository;
import com.example.loginauthapi.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;

    public Transaction addTransaction(Transaction transaction, String userEmail) {

        User user = userRepository.findByEmail(userEmail).orElseThrow(()-> new RuntimeException("User Not Found"));

        transaction.setUser(user);
        return transactionRepository.save(transaction);

    }

    public List<Transaction> getUSerTransaction(String email){
        
    }
}
