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
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;

    public Transaction addTransaction(Transaction transaction, String userEmail) {
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        transaction.setUser(user);
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getUserTransaction(String userEmail) {
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        return transactionRepository.findByUser(user);
    }

    public void deleteTransaction(Long id, String userEmail) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transação não encontrada"));

        if (!transaction.getUser().getEmail().equals(userEmail)) {
            throw new RuntimeException("Ação não autorizada");
        }

        transactionRepository.delete(transaction);
    }

    public Map<String, Double> getFinancialSummary(String userEmail) {
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        List<Transaction> transactions = transactionRepository.findByUser(user);

        double totalIncome = transactions.stream()
                .filter(t -> t.getType() == TransactionType.INCOME)
                .mapToDouble(Transaction::getAmount)
                .sum();

        double totalExpense = transactions.stream()
                .filter(t -> t.getType() == TransactionType.EXPENSE)
                .mapToDouble(Transaction::getAmount)
                .sum();

        return Map.of(
                "Total Income", totalIncome,
                "Total Expense", totalExpense,
                "Balance", totalIncome - totalExpense
        );
    }
}
