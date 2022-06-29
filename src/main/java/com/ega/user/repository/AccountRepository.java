package com.ega.user.repository;

import com.ega.user.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByAccountNumberEquals(String accountNumber);
    @Query(value = "SELECT max(accountNumber) FROM Account")
    Long getMaxAccountNumber();


}