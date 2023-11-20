package com.medical.business.service;

import com.medical.common.exception.IllegalArgumentException;
import com.medical.common.exception.NonExistingResourceException;
import com.medical.domain.model.User;

public interface UserService {

    User findById(Long UserId) throws NonExistingResourceException;

    User create(User user) throws IllegalArgumentException;

    User update(User user) throws NonExistingResourceException, IllegalArgumentException;

    void delete(Long UserId) throws NonExistingResourceException;

}