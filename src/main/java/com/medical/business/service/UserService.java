package com.medical.business.service;

import com.medical.domain.model.User;

public interface UserService {

    User getUserById(Long UserId) throws Exception;

    User createUser(User user);

    User updateUser(User user) throws Exception;

    void deleteUser(Long UserId) throws Exception;

}