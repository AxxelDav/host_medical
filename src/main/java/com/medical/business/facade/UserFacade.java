package com.medical.business.facade;

import com.medical.common.exception.IllegalArgumentException;
import com.medical.common.exception.NonExistingResourceException;
import com.medical.domain.dto.response.UserResponse;
import com.medical.domain.dto.request.UserRequest;

public interface UserFacade {

    UserResponse findById(Long UserId) throws NonExistingResourceException;

    UserResponse create(UserRequest request) throws IllegalArgumentException;

    UserResponse update(UserRequest request, Long userId) throws NonExistingResourceException, IllegalArgumentException;

    void delete(Long UserId) throws NonExistingResourceException;

}
