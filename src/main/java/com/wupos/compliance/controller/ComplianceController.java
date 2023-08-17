package com.wupos.compliance.controller;

import com.wupos.compliance.service.TransactionService;

@RestController
public class ComplianceController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/sendMoney")
    public String sendMoneyValidation(@RequestBody Transaction transaction){

        if(transactionService.validateTransaction(transaction.getId())){
            return //error code
        }
        else if(transactionService.validateMonthlyLimitAmount(transaction)){
            return //error code
        }
        else if(transactionService.validateMonthlyLimitNumber(tra){
            return //error code
        }
        else{
            success();
        }
    }
}
