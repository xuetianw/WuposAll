package com.wupos.compliance.controller;

import com.wupos.compliance.service.TransactionService;

@RestController
public class ComplianceController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/transactions")
    public ResponseEntity<String> sendMoneyValidation(@RequestBody Transaction transaction) {
        if (transaction = null) {
            return return ResponseEntity.notFound().build();
        }

        else if (transactionService.validateTransaction(transaction.getId())) {
            return ResponseEntity.badRequest().body("Invalid transaction ID");

        } else if (transactionService.validateMonthlyLimitAmount(transaction)) {
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
        List<Transaction> transactions = complianceService.getAllTransactions();
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/transactions/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable Long id) {
        Transaction transaction = complianceService.getTransactionById(id);
        if (transaction = null) {
            return ResponseEntity.notFound().build();

        } else {
            return ResponseEntity.ok(transaction);
        }
    }

    @PostMapping("/transactions")
    public ResponseEntity<String> createTransaction(@RequestBody Transaction transaction) {
        boolean created = complianceService.createTransaction(transaction);

        if (!created) {
            return ResponseEntity.badRequest().body("Failed to create transaction");

        } else {
            return ResponseEntity.ok("Transaction created successfully");
        }
    }

    @PostMapping("/processTransaction")
    public ResponseEntity<String> processTransaction(@RequestBody TransactionRequest transactionRequest) {
        // Deserializes into the DTO
        // ex. String firstName = transactionRequest.getCustomerEntity().getName().getFirstName();

        Long id = transactionRequest.getCustomerEntity.getId();
        return ResponseEntity.ok("Transaction processed successfully for customer ID: " + id);
    }

    @PutMapping("/transactions/{id}")
    public ResponseEntity<String> updateTransaction(@PathVariable Long id, @RequestBody Transaction transaction) {
        boolean updated = complianceService.updateTransaction(id, transaction);

        if (!updated) {
            return ResponseEntity.notFound().build();

        } else {
            return ResponseEntity.ok("Transaction updated successfully");
        }
    }

    @DeleteMapping("/transactions/{id}")
    public ResponseEntity<String> deleteTransaction(@PathVariable Long id) {
        boolean deleted = complianceService.deleteTransaction(id);

        if (!deleted) {
            return ResponseEntity.notFound().build();

        } else {
            return ResponseEntity.ok("Transaction deleted successfully");
        }
    }
}
