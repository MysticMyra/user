package com.ega.user.service;

import com.ega.user.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    Optional<User> findById(Long aLong);
    List<User> getAllUsers();
    User save(User User);
    void delete(Long UserId);
}
