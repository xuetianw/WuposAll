package com.wupos.compliance.repo;

import com.wupos.compliance.model.Transaction;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public class TransactionDAOImpl implements  TransactionDAO{
    private EntityManager entityManager;

    @Autowired
    public TransactionDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    @Transactional
    public void saveTransaction(Transaction transaction) {
        LocalDate date = LocalDate.now();
        transaction.setDateAdded(date);
        entityManager.persist(transaction);
    }


    @Override
    public List<Transaction> getTransactionsByCustomer(Transaction transaction) {
        //String pcp = transaction.getPCP();
        /**
        TypedQuery<Transaction> query = entityManager.createQuery("Select t from Transaction t where t.PCP= :PCP", Transaction.class);
        query.setParameter("pcp", customerEntity.getPCP());
        List<Transaction> transactions = query.getResultList();
        */
        return entityManager.createQuery("SELECT t FROM Transaction t WHERE t.PCP = :PCP").setParameter("PCP", transaction.getPCP()).getResultList();
    }

    @Override
    public Transaction getTransactionById(Long transactionId) {
        return null;
    }

    @Override
    public Transaction findTransactionById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void delete(Transaction entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Transaction> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Transaction> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Transaction> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Transaction> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Transaction> findAll() {
        return null;
    }



    @Override
    public List<Transaction> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Transaction> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Transaction> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Transaction> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Transaction getOne(Long aLong) {
        return null;
    }

    @Override
    public Transaction getById(Long aLong) {
        return null;
    }

    @Override
    public Transaction getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Transaction> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Transaction> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Transaction> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Transaction> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Transaction> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Transaction> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Transaction, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public List<Transaction> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Transaction> findAll(Pageable pageable) {
        return null;
    }
}
