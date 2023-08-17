package com.wupos.compliance.repo;

import com.wupos.compliance.model.CustomerEntity;
import com.wupos.compliance.model.Transaction;

import java.util.List;

public interface TransactionDAO {
    public void save(Transaction transaction);

    public List<Transaction> getTransactionsByCustomer(CustomerEntity customer);
    public Transaction getTransactionById(Long transactionId);
}
