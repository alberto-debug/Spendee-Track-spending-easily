package com.example.loginauthapi.controllers;

import com.example.loginauthapi.domain.user.Transaction;
import com.example.loginauthapi.domain.user.User;
import com.example.loginauthapi.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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



}
