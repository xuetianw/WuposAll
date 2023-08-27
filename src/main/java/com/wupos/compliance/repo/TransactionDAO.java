package com.wupos.compliance.repo;

import com.wupos.compliance.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionDAO extends JpaRepository<Transaction, Long> {
    List<Transaction> findByPCP(String PCP);

}
