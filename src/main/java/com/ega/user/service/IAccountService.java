package com.ega.user.service;

import com.ega.user.model.Account;

import java.util.List;

public interface IAccountService {
    List<Account> getAllAccounts();

    Account save(Account account);
}