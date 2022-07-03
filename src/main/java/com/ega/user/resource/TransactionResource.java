package com.ega.user.resource;

import com.ega.user.model.Transaction;
import com.ega.user.repository.AccountRepository;
import com.ega.user.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class TransactionResource {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private TransactionRepository transactionRepository;

    @PostMapping("/account/{accountNumber}/transactions")
    public ResponseEntity<Transaction> createTransaction(@PathVariable(value = "accountNumber") Long accountNumber,
                                                         @RequestBody Transaction transactionRequest) throws Exception {

        Transaction transaction = accountRepository.findByAccountNumberEquals(accountNumber).map(trans -> {
            transactionRequest.setAccount(trans);
            return transactionRepository.save(transactionRequest);
        }).orElseThrow(() -> new Exception("Not found Account with accountNumber = " + accountNumber));
        return new ResponseEntity<>(transaction, HttpStatus.CREATED);
    }

    @GetMapping("/account/{accountNumber}/transactions")
    public List<Transaction> getAllTransaction(@PathVariable(value = "accountNumber") Long accountNumber) {
        return transactionRepository.findAllTransactionsByAccountNumber(accountNumber);
    }
}
