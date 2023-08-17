package com.wupos.compliance.controller;

import com.wupos.compliance.service.TransactionService;

@RestController
public class ComplianceController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/sendMoney")
    public ResponseEntity<String> sendMoneyValidation(@RequestBody Transaction transaction) {
        if (transactionService.validateTransaction(transaction.getId())) {
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
}
