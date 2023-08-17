package com.wupos.compliance.repo;

import com.wupos.compliance.model.CustomerEntity;
import com.wupos.compliance.model.Transaction;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransactionDAOImpl implements  TransactionDAO{
    private EntityManager entityManager;

    @Autowired
    public TransactionDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    @Transactional
    public void save(Transaction transaction) {
        entityManager.persist(transaction);
    }

    @Override
    public List<Transaction> getTransactionsByCustomer(CustomerEntity customerEntity) {
        TypedQuery<Transaction> query = entityManager.createQuery("Select t from Transaction t where t.uid=:id", Transaction.class);
        List<Transaction> transactions = query.getResultList();
        return transactions;
    }

    @Override
    public Transaction getTransactionById(Long transactionId) {
        return null;
    }
}
