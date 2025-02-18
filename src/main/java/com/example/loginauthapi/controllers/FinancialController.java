package com.example.loginauthapi.controllers;

import com.example.loginauthapi.domain.user.Transaction;
import com.example.loginauthapi.domain.user.User;
import com.example.loginauthapi.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/finance")
@RequiredArgsConstructor
public class FinancialController {

    private final TransactionService transactionService;

    @PostMapping("/transaction")
    public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction transaction,
                                                      @AuthenticationPrincipal User user){
        return ResponseEntity.ok(transactionService.addTransaction(transaction, user.getEmail()));

    }

    @GetMapping("/transactions")
    public ResponseEntity<List<Transaction>> getUserTransactions(@AuthenticationPrincipal User user){
        return ResponseEntity.ok(transactionService.getUserTransaction(user.getEmail()));
    }

    @DeleteMapping("/transaction/{id}")
    public ResponseEntity<Void> deleteTransactions(@PathVariable Long id, @AuthenticationPrincipal User user){
        transactionService.deleteTransaction(id, user.getEmail());
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/summary")
    public ResponseEntity<Map<String , Double>> getFinancialSummary(@AuthenticationPrincipal User user){
        return ResponseEntity.ok(transactionService.getFinancialSummary(user.getEmail()));
    }

}
