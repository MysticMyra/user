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
    private IAccountService iAccountService;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

//    @GetMapping(value = "/getUserAccount")
//    public Account getAccountDetail() {
//
//      //  iAccountService
//        //iAc.getAllUsers().stream().forEach(System.out::println);
//        return iUserService.getAllUsers();
//    }

    @GetMapping("/account/{accountNumber}")
    public ResponseEntity<Account> getAccountByAccountNumber(@PathVariable(required = true) Long accountNumber){

        Optional<Account> account = accountRepository.findByAccountNumberEquals(accountNumber);

        if(account.isEmpty()){
            return  new ResponseEntity("Account do not exists in Database", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(account, HttpStatus.ACCEPTED);
    }





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