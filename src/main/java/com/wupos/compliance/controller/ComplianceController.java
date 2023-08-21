package com.wupos.compliance.controller;

import com.wupos.compliance.model.Transaction;
import com.wupos.compliance.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ComplianceController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/sendMoney")
    public ResponseEntity<String> sendMoneyValidation(@RequestBody  Transaction transaction) {
        System.out.println(transaction.getPCP());
        if (transaction == null) {
            return ResponseEntity.notFound().build();
        }

        else if (transactionService.validateTransaction(transaction.getPaymentDetails())) {
            return ResponseEntity.badRequest().body("Invalid transaction ID");

        } else if (transactionService.validateMonthlyLimitAmount(transaction)) {
            //System.out.println(transaction.getCustomer());
            return ResponseEntity.badRequest().body("Exceeded monthly limit amount");

        } else if (transactionService.validateMonthlyLimitNumber(transaction)) {
            return ResponseEntity.badRequest().body("Exceeded number of monthly transactions");

        } else {
            // success();
            return ResponseEntity.ok("Transaction successfully validated");
        }
    }

    @GetMapping("/transactions")
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        List<Transaction> transactions = transactionService.getAllTransactions();
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/transactions/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable Long id) {
        Transaction transaction = transactionService.getTransactionById(id);
        if (transaction == null) {
            return ResponseEntity.notFound().build();

        } else {
            return ResponseEntity.ok(transaction);
        }
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
        // ex. String firstName = transactionRequest.getCustomerEntity().getName().getFirstName();
        if (transaction == null) {
            return ResponseEntity.badRequest().body("Failed to process transaction");
        }

        else {
            return ResponseEntity.ok("Transaction processed successfully");
        }
    }

    @PutMapping("/transactions/{id}")
    public ResponseEntity<String> updateTransaction(@PathVariable Long id, @RequestBody Transaction transaction) {
        boolean updated = transactionService.updateTransaction(id, transaction);

        if (!updated) {
            return ResponseEntity.notFound().build();

        } else {
            return ResponseEntity.ok("Transaction updated successfully");
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
