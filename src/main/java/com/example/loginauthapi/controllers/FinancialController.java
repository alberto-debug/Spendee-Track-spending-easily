package com.example.loginauthapi.controllers;

import com.example.loginauthapi.domain.user.Transaction;
import com.example.loginauthapi.domain.user.User;
import com.example.loginauthapi.services.TransactionService;
import com.example.loginauthapi.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    private final UserRepository userRepository;

    @PostMapping("/transaction")
    public ResponseEntity<?> addTransaction(@RequestBody Transaction transaction,
                                            @AuthenticationPrincipal User user) {
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário não autenticado.");
        }

        return ResponseEntity.ok(transactionService.addTransaction(transaction, user.getEmail()));
    }

    @GetMapping("/transactions")
    public ResponseEntity<?> getUserTransactions(@AuthenticationPrincipal User user) {
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário não autenticado.");
        }

        return ResponseEntity.ok(transactionService.getUserTransaction(user.getEmail()));
    }

    @DeleteMapping("/transaction/{id}")
    public ResponseEntity<?> deleteTransactions(@PathVariable Long id, @AuthenticationPrincipal User user) {
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário não autenticado.");
        }

        transactionService.deleteTransaction(id, user.getEmail());
        return ResponseEntity.ok().body("Transação removida com sucesso.");
    }

    @GetMapping("/summary")
    public ResponseEntity<?> getFinancialSummary(@AuthenticationPrincipal User user) {
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário não autenticado.");
        }

        return ResponseEntity.ok(transactionService.getFinancialSummary(user.getEmail()));
    }
}
