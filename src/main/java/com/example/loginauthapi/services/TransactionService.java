package com.example.loginauthapi.services;

import com.example.loginauthapi.domain.user.Transaction;
import com.example.loginauthapi.domain.user.TransactionType;
import com.example.loginauthapi.domain.user.User;
import com.example.loginauthapi.repositories.TransactionRepository;
import com.example.loginauthapi.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    public List<Transaction> getUSerTransaction(String userEmail){

        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(()-> new RuntimeException("User Not found"));

        return transactionRepository.findByUser(user);
    }

    public void deleteTransaction(Long id, String userEmail){
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Transaction not found"));

        if (!transaction.getUser().getEmail().equals(userEmail)){
            throw new RuntimeException("Unauthorized Action");
        }

        transactionRepository.delete(transaction);
    }

    public Map<String, Double> getFinancialSummary(String userEmail){

        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(()-> new RuntimeException("User Not found"));

        List<Transaction> transactions = transactionRepository.findByUser(user);


    }
}
