package com.medical.business.service.impl;

import com.medical.business.service.UserService;
import com.medical.common.exception.IllegalArgumentException;
import com.medical.common.exception.NonExistingResourceException;
import com.medical.domain.model.User;
import com.medical.persistence.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long userId) throws NonExistingResourceException {
        return userRepository.findById(userId).orElseThrow(() -> new NonExistingResourceException("No existe USER con ID " + userId));
    }

    @Override
    public User create(User user) throws IllegalArgumentException {
        if (Objects.isNull(user)) {
            throw new IllegalArgumentException("Error creating user", "User can´t be null");
        }
        return userRepository.save(user);
    }

    @Override
    public User update(User user) throws NonExistingResourceException, IllegalArgumentException {
        if (Objects.isNull(user)) {
            throw new IllegalArgumentException("Error: with user", "User can´t be null");
        }
        findById(user.getId());
        return userRepository.save(user);
    }

    @Override
    public void delete(Long UserId) throws NonExistingResourceException {
        findById(UserId);
        userRepository.deleteById(UserId);
    }

}
