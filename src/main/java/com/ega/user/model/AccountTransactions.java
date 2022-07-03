package com.ega.user.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AccountTransactions {
    private Long accountId;
    private User user;
    private Long accountNumber;
    private Long currentBalance;
    private Transaction transaction;

}
