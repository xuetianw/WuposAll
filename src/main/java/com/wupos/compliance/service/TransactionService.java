package com.wupos.compliance.service;


import com.wupos.compliance.model.CustomerEntity;
import com.wupos.compliance.model.PaymentDetailsEntity;
import com.wupos.compliance.model.Transaction;
import com.wupos.compliance.repo.TransactionDAO;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Service
public class TransactionService {
    //transactions repo
    private static final int BUFFER = 100;
    private static final int TRANSACTION_LIMIT = 3000;
    private static final int TRANSACTION_MONTHLY_AMOUNT_LIMIT = 100000;
    private static final int TRANSACTION_NUMBER_LIMIT = 40;
    private TransactionDAO transactionDAO;
    //insert repo
    public TransactionService(TransactionDAO transactionDAO){
        //repo
        this.transactionDAO = transactionDAO;
    }

    public boolean validateTransaction(Transaction transaction){
        PaymentDetailsEntity paymentDetails = transaction.getPaymentDetailsEntity();
        int sentAmount = Integer.parseInt(paymentDetails.getSendAmount()) / BUFFER;
        if(sentAmount > TRANSACTION_LIMIT){ //get number from config
            return false;
        }
        return true;
    }


    public boolean validateMonthlyLimitAmount(CustomerEntity customer){
        //repo.getTransactionsByUser
        List<Transaction> userTransactions = transactionDAO.getTransactionsByCustomer(customer);
        LocalDate today = LocalDate.now();
        LocalDate monthAgo = today.minusDays(30);

        int monthlyTransaction = 0;

        for(Transaction transaction : userTransactions){
            LocalDate date = transaction.getDateAdded().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if(date.isAfter(monthAgo) && date.isBefore(today)){
                monthlyTransaction += Integer.parseInt(transaction.getPaymentDetailsEntity().getSendAmount());
            }

            if(monthlyTransaction > TRANSACTION_MONTHLY_AMOUNT_LIMIT){
                return false;
            }
        }

        return true;
    }

    public boolean validateMonthlyLimitNumber(CustomerEntity customer){
        //repo.getTransactionsByUser
        List<Transaction> userTransactions = transactionDAO.getTransactionsByCustomer(customer);
        LocalDate today = LocalDate.now();
        LocalDate monthAgo = today.minusDays(30);

        int monthlyTransaction = 0;

        for(Transaction transaction : userTransactions){
            LocalDate date = transaction.getDateAdded().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if(date.isAfter(monthAgo) && date.isBefore(today)){
                monthlyTransaction++;
            }

            if(monthlyTransaction > TRANSACTION_NUMBER_LIMIT){
                return false;
            }
        }
        return true;
    }

    // crud methods
    public List<Transaction> getAllTransactions() {
        return transactionDAO.findAll();
    }

    public Transaction getTransactionById(Long id) {
        return transactionDAO.findTransactionById(id);
    }

    public boolean createTransaction(Transaction transaction) {
        try {
            transactionDAO.save(transaction);
            return true;

        } catch (DataAccessException e) {
            return false;
        }
    }

    public boolean updateTransaction(Long id, Transaction updatedTransaction) {
        Transaction existingTransaction = transactionDAO.findTransactionById(id);

        if (existingTransaction != null) {
            transactionDAO.save(updatedTransaction);
            return true;

        } else {
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

}
