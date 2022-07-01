package com.ega.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.*;
import javax.persistence.*;
import java.sql.Timestamp;

@Builder
@Data
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long accountId;

    @JsonIgnore
    @OneToOne(mappedBy = "account")
    @JoinColumn(name = "user_id")
    private User user;

    private Long accountNumber;
    private Long currentBalance;
    private Timestamp transactionDateTime;
    private String transactionDescription;
    private String transferType;

    public Account() {
    }



    public Account(Long accountId, User user, Long accountNumber, Long currentBalance, Timestamp transactionDateTime, String transactionDescription, String transferType) {
        this.accountId = accountId;
        this.user = user;
        this.accountNumber = accountNumber;
        this.currentBalance = currentBalance;
        this.transactionDateTime = transactionDateTime;
        this.transactionDescription = transactionDescription;
        this.transferType = transferType;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Long getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(Long currentBalance) {
        this.currentBalance = currentBalance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public Timestamp getTransactionDateTime() {
        return transactionDateTime;
    }

    public void setTransactionDateTime(Timestamp transactionDateTime) {
        this.transactionDateTime = transactionDateTime;
    }

    public String getTransactionDescription() {
        return transactionDescription;
    }

    public void setTransactionDescription(String transactionDescription) {
        this.transactionDescription = transactionDescription;
    }

    public String getTransferType() {
        return transferType;
    }

    public void setTransferType(String transferType) {
        this.transferType = transferType;
    }
}