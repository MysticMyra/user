package com.ega.user.model;

import java.sql.Timestamp;

public class AccountDTO {

    private Long accountId;
    private User user;
    private String accountNumber;
    private Long currentBalance;
    private Timestamp transactionDateTime;
    private String transactionDescription;
    private String transferType;

    public AccountDTO() {
    }

    public AccountDTO(Long accountId, User user, String accountNumber, Long currentBalance, Timestamp transactionDateTime, String transactionDescription, String transferType) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Long getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(Long currentBalance) {
        this.currentBalance = currentBalance;
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

    @Override
    public String toString() {
        return "AccountDTO{" +
                "accountId=" + accountId +
                ", user=" + user +
                ", accountNumber='" + accountNumber + '\'' +
                ", currentBalance=" + currentBalance +
                ", transactionDateTime=" + transactionDateTime +
                ", transactionDescription='" + transactionDescription + '\'' +
                ", transferType='" + transferType + '\'' +
                '}';
    }
}
