package com.wupos.compliance.controller;

import com.wupos.compliance.advice.CustomResponse;
import com.wupos.compliance.model.Transaction;
import com.wupos.compliance.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ComplianceController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/sendMoney")
    public ResponseEntity<CustomResponse> sendMoneyValidation(@RequestBody Transaction transaction) {
        // System.out.println(transaction.getPCP());
        if (transaction == null) {
            return ResponseEntity.notFound().build();
        }

        String added = transactionService.validateTransaction(transaction);
        return new ResponseEntity<>(new CustomResponse("100", added), HttpStatus.ACCEPTED);
    }

    @GetMapping("/transactions")
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        List<Transaction> transactions = transactionService.getAllTransactions();
        return ResponseEntity.ok(transactions);
    }

    @PostMapping("/transactions")
    public ResponseEntity<String> createTransaction(@RequestBody Transaction transaction) {
        boolean created = transactionService.createTransaction(transaction);

        if (!created) {
            return ResponseEntity.badRequest().body("Failed to create transaction");

        } else {
            return ResponseEntity.ok("Transaction created successfully");
        }
    }

    @PostMapping("/processTransaction")
    public ResponseEntity<String> processTransaction(@RequestBody Transaction transaction) {
        // Deserializes into the DTO
        // ex. String firstName =
        // transactionRequest.getCustomerEntity().getName().getFirstName();
        if (transaction == null) {
            return ResponseEntity.badRequest().body("Failed to process transaction");
        }

        else {
            return ResponseEntity.ok("Transaction processed successfully");
        }
    }

    @DeleteMapping("/transactions/{id}")
    public ResponseEntity<String> deleteTransaction(@PathVariable Long id) {
        boolean deleted = transactionService.deleteTransaction(id);

        if (!deleted) {
            return ResponseEntity.notFound().build();

        } else {
            return ResponseEntity.ok("Transaction deleted successfully");
        }
    }
}
