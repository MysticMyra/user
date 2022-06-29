package com.ega.user.service;

import com.ega.user.model.Account;
import com.ega.user.model.User;

import java.util.List;

public interface IAccountService {
    List<Account> getAllAccounts();
    Account save(Account account);
//    Transaction sendMoney(
//            TransferBalanceRequest transferBalanceRequest
//    );
//    AccountStatement getStatement(String accountNumber);
}