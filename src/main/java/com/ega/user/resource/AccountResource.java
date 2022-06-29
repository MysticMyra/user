package com.ega.user.resource;

import com.ega.user.model.Account;
import com.ega.user.model.AccountDTO;
import com.ega.user.model.User;
import com.ega.user.model.UserDTO;
import com.ega.user.repository.AccountRepository;
import com.ega.user.repository.UserRepository;
import com.ega.user.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class AccountResource {
    @Autowired
    private IAccountService accountService;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/generateAccountNumber")
    public String generateAccountNumber() {
       // Long newAccountNumber= accountRepository.getMaxAccountNumber()+1;
        Long newAccountNumber= (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
        System.out.println("-------------max account number--->"+newAccountNumber);
       return newAccountNumber.toString();
    }

    @PostMapping("/createAccount")
    public ResponseEntity<Void> createAccount(@RequestBody() AccountDTO accountDTO) {

        Optional<User> user = Optional.empty();
        Account account = new Account();

        if (accountDTO.getAccountId()== null || accountDTO.getAccountId().equals("")) {
            long id = accountService.getAllAccounts().size() + 1;
            System.out.println("New Account id"+id);
            account.setAccountId(id);
        }

            account.setAccountNumber(generateAccountNumber());
        if(accountDTO.getUser() != null){
            user = userRepository.findById(accountDTO.getUser().getUserId());
            if(user.isPresent()){
                accountDTO.setUser(user.get());
            }
        }
        account.setCurrentBalance(0l);
        account.setTransactionDateTime(null);
        account.setTransferType(null);
        account.setTransactionDescription(null);

        accountService.save(account);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(accountDTO.getAccountId())
                .toUri();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(uri);

        return new ResponseEntity(account, responseHeaders, HttpStatus.CREATED);
    }
//    @RequestMapping("/all")
//    public List<Account> all() {
//        return accountService.findAll();
//    }

//    @RequestMapping("/sendmoney")
//    public Response sendMoney(
//            @RequestBody TransferBalanceRequest transferBalanceRequest
//    ) {
//
//        return Response.ok().setPayload(
//                accountService.sendMoney(
//                        transferBalanceRequest
//                )
//        );
//    }
//    @RequestMapping("/statement")
//    public Response getStatement(
//            @RequestBody AccountStatementRequest accountStatementRequest
//
//    ){
//        return Response.ok().setPayload(
//                accountService.getStatement(accountStatementRequest.getAccountNumber())
//        );
//
//    }

}