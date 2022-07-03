package com.ega.user.repository;

import com.ega.user.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query(value = "SELECT * FROM TRANSACTION WHERE ACCOUNT_ID = (SELECT ACCOUNT_ID FROM ACCOUNT WHERE ACCOUNT_NUMBER=?1);", nativeQuery = true)
    List<Transaction> findAllTransactionsByAccountNumber(Long accountNumber);
}
