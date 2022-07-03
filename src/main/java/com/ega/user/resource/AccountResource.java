package com.ega.user.resource;

import com.ega.user.model.Account;
import com.ega.user.repository.AccountRepository;
import com.ega.user.repository.TransactionRepository;
import com.ega.user.repository.UserRepository;
import com.ega.user.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class AccountResource {
    @Autowired
    private IAccountService iAccountService;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping("/account/{accountNumber}")
    public ResponseEntity<Account> getAccountByAccountNumber(@PathVariable(required = true) Long accountNumber) {

        Optional<Account> account = accountRepository.findByAccountNumberEquals(accountNumber);
        if (account.isEmpty()) {
            return new ResponseEntity("Account do not exists in Database", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(account, HttpStatus.ACCEPTED);
    }

}