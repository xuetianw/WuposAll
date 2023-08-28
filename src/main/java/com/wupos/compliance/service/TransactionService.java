package com.wupos.compliance.service;


import com.wupos.compliance.exception.OverAmountLimitException;
import com.wupos.compliance.exception.OverMonthlyAmountLimitException;
import com.wupos.compliance.exception.OverMonthlyTransactionsLimitException;
import com.wupos.compliance.model.Transaction;
import com.wupos.compliance.repo.TransactionDAO;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TransactionService {
    //transactions repo
    private static final int BUFFER = 100;
    private static final int TRANSACTION_LIMIT = 1000;
    private static final int TRANSACTION_MONTHLY_AMOUNT_LIMIT = 10000;
    private static final int TRANSACTION_NUMBER_LIMIT = 3;
    private TransactionDAO transactionDAO;
    //insert repo
    public TransactionService(TransactionDAO transactionDAO){
        //repo
        this.transactionDAO = transactionDAO;
    }

    private boolean validatePaymentAmount(Transaction transaction){
        int sentAmount = Integer.parseInt(transaction.getPaymentDetails().getSendAmount()) / BUFFER;
        if(sentAmount > TRANSACTION_LIMIT && transaction.getCustomer().getCompliance() == null){ //get number from config
            throw new OverAmountLimitException("Transaction Amount limit is " + TRANSACTION_LIMIT);
        }
        return false;
    }


    private void validateMonthlyLimitAmount(Transaction transaction){
        //System.out.println(transaction.getPCP());
        List<Transaction> userTransactions = transactionDAO.findByPCP(transaction.getPCP());
        LocalDate today = LocalDate.now();
        LocalDate monthAgo = today.minusDays(30);

        int monthlyTransaction = Integer.parseInt(transaction.getPaymentDetails().getSendAmount()) /BUFFER;
        for(Transaction transactionByUser : userTransactions){
            LocalDate date = transactionByUser.getDateAdded();
            if(date.isAfter(monthAgo) && date.isBefore(today)){
                monthlyTransaction += Integer.parseInt(transactionByUser.getPaymentDetails().getSendAmount());
            }

            if(monthlyTransaction > TRANSACTION_MONTHLY_AMOUNT_LIMIT && transaction.getCustomer().getCompliance() == null ){
                throw new OverMonthlyAmountLimitException("User has exceeded the monthly amount limit");
            }
        }
    }

    private void validateMonthlyLimitNumber(Transaction transaction){
        //repo.getTransactionsByUser
        List<Transaction> userTransactions = transactionDAO.findByPCP(transaction.getPCP());
        LocalDate today = LocalDate.now();
        LocalDate monthAgo = today.minusDays(30);

        int monthlyTransaction = 1;

        for(Transaction t : userTransactions){
            LocalDate date = t.getDateAdded();
            if(date.isAfter(monthAgo) && date.isBefore(today)){
                monthlyTransaction++;
            }

            if(monthlyTransaction > TRANSACTION_NUMBER_LIMIT && transaction.getCustomer().getCompliance() == null){
                throw new OverMonthlyTransactionsLimitException("User exceeded monthly transaction limit");
            }
        }
    }

    // crud methods
    public List<Transaction> getAllTransactions() {
        return transactionDAO.findAll();
    }


    public boolean createTransaction(Transaction transaction) {
        try {
            transactionDAO.save(transaction);
            return true;

        } catch (DataAccessException e) {
            return false;
        }
    }



    public boolean deleteTransaction(Long id) {
        try {
            transactionDAO.deleteById(id);
            return true;

        } catch (DataAccessException e) {
            return false;
        }
    }

    public boolean validateTransaction(Transaction transaction) {
        validatePaymentAmount(transaction);
        validateMonthlyLimitAmount(transaction);
        validateMonthlyLimitNumber(transaction);
        return true;
    }
}
