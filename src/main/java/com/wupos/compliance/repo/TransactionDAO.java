package com.wupos.compliance.repo;

import com.wupos.compliance.model.Customer;
import com.wupos.compliance.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionDAO extends JpaRepository<Transaction, Long> {


    public void saveTransaction(Transaction transaction);

    public List<Transaction> getTransactionsByCustomer(Customer customer);
    public Transaction getTransactionById(Long transactionId);

    public Transaction findTransactionById(Long id);

    void deleteById(Long id);

    List<Transaction> findAll();
}
