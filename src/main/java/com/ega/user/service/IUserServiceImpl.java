package com.ega.user.service;

import com.ega.user.model.User;
import com.ega.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IUserServiceImpl  implements  IUserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> findById(Long aLong) {
        return userRepository.findById(aLong);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User save(User User) {
        return userRepository.save(User);
    }

    @Override
    public void delete(Long UserId) {
        userRepository.deleteById(UserId);
    }
}
