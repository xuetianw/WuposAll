package com.wupos.compliance.service;


public class TransactionService {
    //transactions repo

    //insert repo
    public TransactionService(){
        //repo
    }

    public boolean validateTransaction(Long transactionId){
        PaymentDetails paymentDetails = transactions.getPaymentDetails(transactionId);
        int sentAmount = paymentDetails.getSendAmount;
        if(sentAmount > 3000){ //get number from config
            return false;
        }
        else{
            return true;
        }
    }

    public List<Transaction> getAllTransactions(){
        return //repoFindall
    }

    public boolean validateMonthlyLimitAmount(long id){
        //repo.getTransactionsByUser
    }

    public boolean validateMonthlyLimitNumber(long id){
        //repo.getTransactionsByUser
    }
}
