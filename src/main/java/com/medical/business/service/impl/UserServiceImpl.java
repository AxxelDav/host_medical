package com.medical.business.service.impl;

import com.medical.business.service.UserService;
import com.medical.domain.model.User;
import com.medical.persistence.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(Long userId) throws Exception {
        return userRepository.findById(userId).orElseThrow(() -> new Exception("No existe USER con ID " + userId));
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) throws Exception {
        getUserById(user.getId());
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long UserId) throws Exception {
        getUserById(UserId);
        userRepository.deleteById(UserId);
    }

}
