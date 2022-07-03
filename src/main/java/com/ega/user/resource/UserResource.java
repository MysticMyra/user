package com.ega.user.resource;


import com.ega.user.model.Account;
import com.ega.user.model.User;
import com.ega.user.model.UserDTO;
import com.ega.user.repository.UserRepository;
import com.ega.user.service.IAccountService;
import com.ega.user.service.IUserService;
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
public class UserResource {

    @Autowired
    IUserService iUserService;
    @Autowired
    UserRepository userRepository;

    @Autowired
    IAccountService iAccountService;

    @GetMapping(value = "/users")
    public List<User> retrieveAllUsers() {
        iUserService.getAllUsers().stream().forEach(System.out::println);
        return iUserService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(required = true) Long id) {

        Optional<User> user = iUserService.findById(id);

        if (user.isEmpty()) {
            return new ResponseEntity("User not found in Database", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(user, HttpStatus.ACCEPTED);
    }

    @GetMapping("/users/find")
    public ResponseEntity<User> getUserByLoginName(@RequestParam("loginName") String loginName) {

        Optional<User> user = userRepository.findByLoginName(loginName);
        //http://localhost:9091/api/users/find?loginName=john.doe

        if (user.isEmpty()) {
            return new ResponseEntity("User not found in Database", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(user, HttpStatus.ACCEPTED);
    }

    @PostMapping("/addUser")
    public ResponseEntity<Void> adduserInfo(@RequestBody() UserDTO UserDTO) {

        User user = new User();
        long userId = 0;
        if (UserDTO.getUserId() == null || UserDTO.getUserId().equals("")) {
            userId = iUserService.getAllUsers().size() + 1;
            System.out.println("User ID" + userId);
            user.setUserId(userId);
        }
        if (UserDTO.getFirstName() == null || UserDTO.getFirstName().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            user.setFirstName(UserDTO.getFirstName());
        }

        if (UserDTO.getLastName() == null || UserDTO.getLastName().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            user.setLastName(UserDTO.getLastName());
        }

        if (UserDTO.getLoginName() == null || UserDTO.getLoginName().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            user.setLoginName(UserDTO.getLoginName());
        }

        if (UserDTO.getPassword() == null || UserDTO.getPassword().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            user.setPassword(UserDTO.getPassword());
        }

        if (UserDTO.getEmail() == null || UserDTO.getEmail().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            user.setEmail(UserDTO.getEmail());
        }
        if (UserDTO.getContactNumber() == null || UserDTO.getContactNumber().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            user.setContactNumber(UserDTO.getContactNumber());
        }
        if (UserDTO.getAddress() == null || UserDTO.getAddress().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            user.setAddress(UserDTO.getAddress());
        }
        user.setState(UserDTO.getState());
        user.setCountry(UserDTO.getCountry());
        user.setPincode(UserDTO.getPincode());

        Long generatedAccountNumber = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
        user.setAccountNumber(generatedAccountNumber);
        System.out.println("generated account number -->" + generatedAccountNumber);
        Account account = Account.builder()
                .accountNumber(generatedAccountNumber)
                .currentBalance(0l)
                .build();

        account.setUser(user);
        user.setAccount(account);
        iAccountService.save(account);
        iUserService.save(user);


        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(UserDTO.getUserId())
                .toUri();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(uri);

        return new ResponseEntity(user, responseHeaders, HttpStatus.CREATED);
    }
}
